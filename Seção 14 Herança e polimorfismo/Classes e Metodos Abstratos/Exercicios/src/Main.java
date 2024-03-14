import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.printf("Tax payer #%d data: \n ", (i + 1));
            System.out.print("Individual or company (i/c)? ");
            char type = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = scanner.nextDouble();
            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else if (type == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = scanner.nextInt();
                taxPayerList.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
        System.out.println();
        double sumTax = 0;
        System.out.println("TAXES PAID:");

        for (TaxPayer taxPayer : taxPayerList) {
            System.out.printf("%s : $ %.2f \n", taxPayer.getName(), taxPayer.tax());
            sumTax += taxPayer.tax();
        }
        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", sumTax);

        scanner.close();
    }
}