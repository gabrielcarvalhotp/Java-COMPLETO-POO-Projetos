import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        exercicio4();
    }

    public static void exercicio1() {
        /*
        Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma
        mensagem explicativa, conforme exemplos.
        */

        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        System.out.println("SOMA = " + (n1 + n2));

        scanner.close();
    }
    public static void exercicio2() {
        /* Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
        casas decimais conforme exemplos.
        Fórmula da área: area = π . raio2
        Considere o valor de π = 3.14159 */
        Scanner scanner = new Scanner(System.in);

        double radios = scanner.nextDouble();
        double area = Math.PI * Math.pow(radios, 2);

        System.out.printf("A = %.4f \n", area );

        scanner.close();
    }
    public static void exercicio3() {
        Scanner scanner = new Scanner(System.in);

        int a, b, c, d;

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        int result = a * b - c * d;

        System.out.println("DIFERENÇA = " + result);

        scanner.close();
    }
    public static void exercicio4() {
        /* Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
        hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
        decimais. */

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int workedHours = scanner.nextInt();
        double hourSalary = scanner.nextDouble();

        double salary = (double) workedHours * hourSalary;

        System.out.printf("NUMBER = %d \n", number);
        System.out.printf("SALARY = U$ %.2f \n", salary);

        scanner.close();
    }
}