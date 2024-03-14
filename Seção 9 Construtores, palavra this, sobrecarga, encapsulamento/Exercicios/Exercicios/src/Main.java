import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Account account;
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account holder: ");
        String holder = scanner.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        if (scanner.next().equals("y")) {
            System.out.print("Enter initial deposit value: ");
            account = new Account(number, holder, scanner.nextDouble());
        } else {
            account = new Account(number, holder);
        }

        System.out.println("Account data: \n " + account);

        System.out.print("Enter a deposit value: ");
        account.deposit(scanner.nextDouble());
        System.out.println("Updated account data: \n " + account);

        System.out.print("Enter a withdraw value: ");
        account.withdraw(scanner.nextDouble());
        System.out.println("Updated account data: \n " + account);

        scanner.close();
    }
}