import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typeOfProduct = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            Double price = scanner.nextDouble();
            scanner.nextLine();
            if (typeOfProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
                productList.add(new UsedProduct(name, price, manufactureDate));
            } else if (typeOfProduct == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = scanner.nextDouble();
                productList.add(new ImportedProduct(name, price, customsFee));
            }
        }

        for (Product produt: productList) {
            produt.priceTag();
        }

        scanner.close();
    }
}