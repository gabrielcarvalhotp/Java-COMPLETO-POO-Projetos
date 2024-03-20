import models.entities.Contract;
import models.entities.Installment;
import models.services.ContractService;
import models.services.PaypalService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Entre os dados do contrato:");
            System.out.print("Numero: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
            System.out.print("Valor do contrato: ");
            double totalValue = scanner.nextDouble();
            System.out.print("Entre com o numero de parcelas: ");
            int installments = scanner.nextInt();
            Contract contract = new Contract(number, date, totalValue);
            ContractService contractService = new ContractService(new PaypalService());
            contractService.processContract(contract, installments);
            System.out.println("Parcelas: ");
            for (Installment installment : contract.getInstallment()) {
                System.out.println(installment);
            }
        } finally {
            scanner.close();
        }
    }
}