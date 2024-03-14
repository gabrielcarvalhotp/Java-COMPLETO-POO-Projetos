import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int number;
        double salary;
        char letter;
        String phrase;
        
        letter = scanner.next().charAt(0);
        phrase = scanner.nextLine();
        number = scanner.nextInt();
        salary = scanner.nextDouble();

        System.out.println("Valores digitados");
        System.out.println(letter);
        System.out.println(phrase);
        System.out.println(number);
        System.out.println(salary);

        scanner.close();
    }
}