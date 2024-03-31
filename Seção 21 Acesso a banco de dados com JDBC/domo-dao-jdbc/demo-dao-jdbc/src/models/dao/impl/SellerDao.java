package models.dao.impl;

import db.DB;
import db.DBException;
import models.dao.Dao;
import models.entities.Departament;
import models.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerDao implements Dao<Seller> {

    private final Connection connection;

    public SellerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    " INSERT INTO `coursejdbc`.`seller` " +
                            "(`Id`, `Name`, `Email`, `BirthDate`, `BaseSalary`, `DepartmentId`) " +
                            "VALUES " +
                            " (?, ?, ?, ?, ?, ?, ?); ",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setDate(4 ,new java.sql.Date(obj.getBirthDate().getTime()));
            preparedStatement.setInt(5 ,obj.getDepartament().getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new DBException("Unexpected error! no rows affected");
            }

            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            obj.setId(resultSet.getInt(1));

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT seller.*, department.Name as DepartmentName \n" +
                    "FROM seller \n" +
                    "INNER JOIN department ON department.Id = seller.DepartmentId \n"+
                    "WHERE seller.Id = ? "
            );
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return instantiateSeller(resultSet);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seller> sellerList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT seller.*, department.Name as DepartmentName \n" +
                            "FROM seller \n" +
                            "INNER JOIN department ON department.Id = seller.DepartmentId "
            );

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            while (resultSet.next()) {
                sellerList.add(instantiateSeller(resultSet));
            }
            return sellerList;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findWhere(String field, Integer value) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seller> sellerList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT seller.*, department.Name as DepartmentName \n" +
                            "FROM seller \n" +
                            "INNER JOIN department ON department.Id = seller.DepartmentId \n"+
                            "WHERE seller." + field + " = ? "
            );
            preparedStatement.setInt(1, value);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sellerList.add(instantiateSeller(resultSet));
            }
            return sellerList;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    private Seller instantiateSeller(ResultSet resultSet) throws SQLException {
        return new Seller(
                resultSet.getInt("Id"),
                resultSet.getString("Name"),
                resultSet.getString("Email"),
                resultSet.getDate("birthDate"),
                resultSet.getDouble("BaseSalary"),
                instantiateDepartament(resultSet));
    }

    private Departament instantiateDepartament(ResultSet resultSet) throws SQLException {
        return new Departament(
                resultSet.getInt("DepartmentId"),
                resultSet.getString("DepartmentName")
        );
    }
}
