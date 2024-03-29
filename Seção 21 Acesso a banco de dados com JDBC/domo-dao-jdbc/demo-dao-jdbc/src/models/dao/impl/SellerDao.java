package models.dao.impl;

import db.DB;
import db.DBException;
import models.dao.Dao;
import models.entities.Departament;
import models.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDao implements Dao<Seller> {

    private final Connection connection;

    public SellerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller obj) {

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
        return null;
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
