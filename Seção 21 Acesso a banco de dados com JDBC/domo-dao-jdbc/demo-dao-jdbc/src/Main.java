import models.dao.DaoFactory;
import models.dao.impl.SellerDao;
import models.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller sellerId = sellerDao.findById(3);
        System.out.println(sellerId);

        System.out.println();

        List<Seller> sellerList = sellerDao.findWhere("DepartmentId", 1);
        for (Seller seller : sellerList) {
            System.out.println(seller);
        }
    }
}