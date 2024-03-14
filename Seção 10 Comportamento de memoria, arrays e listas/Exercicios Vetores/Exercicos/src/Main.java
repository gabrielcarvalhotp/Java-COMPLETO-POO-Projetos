import entities.People;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        somaVetores();
    }

    public static void negativos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int[] vetor = new int[quantity];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = scanner.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS:");

        for (int j : vetor) {
            if (j < 0)
                System.out.println(j);
        }

        scanner.close();
    }
    public static void somaVetor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantity = scanner.nextInt();
        double[] vetor = new double[quantity];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = scanner.nextDouble();
        }

        System.out.print("VALORES = ");

        double sum = 0;
        for (double j : vetor) {
            System.out.printf("  %.2f  ", j);
            sum += j;
        }
        System.out.println();
        double average = sum / vetor.length;

        System.out.printf("SOMA = %.2f \n", sum);
        System.out.printf("MEDIA = %.2f \n", average);

        scanner.close();
    }
    public  static void alturas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        People[] people = new People[quantity];
        float heightSum = 0;
        int minor = 0;
        for (int i = 0; i < people.length; i++) {
            people[i] = new People();

            System.out.printf("Dados da %d aª pessoa: \n", i + 1);
            System.out.print("Nome: ");
            people[i].setName(scanner.nextLine());
            System.out.print("Idade: ");
            people[i].setAge(scanner.nextInt());
            System.out.print("Altura: ");
            people[i].setHeight(scanner.nextFloat());
            scanner.nextLine();

            heightSum += people[i].getHeight();
            if (people[i].getAge() < 16)
                minor++;

            System.out.println();
        }

        double heightAverage = heightSum / people.length;
        float percMinor = (float) minor / people.length * 100;

        System.out.printf("Altura média: %.2f \n", heightAverage);
        System.out.printf("Pessoas com menos de 16 anos: %.2f \n", percMinor);

        for (People j : people) {
            if (j.getAge() < 16)
                System.out.println(j.getName());
        }

        scanner.close();
    }
    public  static void numerosPares() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantity = scanner.nextInt();
        int[] vetor = new int[quantity];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = scanner.nextInt();
        }

        int evenNumbers = 0;
        System.out.println("\nNUMEROS PARES: ");
        for (int j : vetor) {
            if (j % 2 == 0) {
                System.out.printf("%d   ", j);
                evenNumbers++;
            }
        }
        System.out.printf("\nQUANTIDADE DE PARES = %d", evenNumbers);
        scanner.close();
    }
    public  static void maiorPosicao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantity = scanner.nextInt();
        double[] vetor = new double[quantity];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = scanner.nextDouble();
        }

        double maxValue = 0;
        int indexOf = 0;

        for (int i = 0; i < vetor.length; i++ ) {
            if (vetor[i] > maxValue) {
                maxValue = vetor[i];
                indexOf = i;
            }
        }
        System.out.printf("\nMAIOR VALOR = %.2f \n", maxValue);
        System.out.printf("POSICAO DO MAIOR VALOR = %d \n", indexOf);

        scanner.close();
    }
    public  static void somaVetores() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantity = scanner.nextInt();
        int[] vetorA = new int[quantity];
        int[] vetorB = new int[quantity];
        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < vetorA.length; i++) {
            System.out.print("Digite um numero: ");
            vetorA[i] = scanner.nextInt();
        }
        System.out.println("Digite os valores do vetor B: ");
        for (int i = 0; i < vetorB.length; i++) {
            System.out.print("Digite um numero: ");
            vetorB[i] = scanner.nextInt();
        }

        System.out.println("VETOR RESULTANTE: \n");
        for (int i = 0; i < quantity; i++) {
            System.out.println(vetorA[i] + vetorB[i]);
        }

        scanner.close();
    }

}