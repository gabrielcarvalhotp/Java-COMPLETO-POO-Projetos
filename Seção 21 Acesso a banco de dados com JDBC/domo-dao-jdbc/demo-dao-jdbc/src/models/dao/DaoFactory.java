package models.dao;

import db.DB;
import models.dao.impl.SellerDao;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDao(DB.getConnection());
    }

}
