import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        client.setName(scanner.nextLine());
        System.out.print("Email: ");
        client.setEmail(scanner.nextLine());
        System.out.print("Birth date (DD/MM/YYYY): ");
        client.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine());
        System.out.print("How many items to this order? ");
        int quantityOrderItems = scanner.nextInt();
        scanner.nextLine();
        Order order = new Order(new Date(), orderStatus, client);

        for (int i = 0; i < quantityOrderItems; i++) {
            Product product = new Product();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            product.setName(scanner.nextLine());
            System.out.print("Product price: ");
            product.setPrice(scanner.nextDouble());
            System.out.print("Quantity: ");
            OrderItem orderItem = new OrderItem(scanner.nextInt(), product);
            scanner.nextLine();
            order.getOrderItemList().add(orderItem);
        }
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        scanner.close();
    }
}