import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner  = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas: ");
        int lines = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas: ");
        int colluns = scanner.nextInt();

        int[][] matriz = new int[lines][colluns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < colluns; j++){
                matriz[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Qual o numero dejesado ? ");
        int number = scanner.nextInt();

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < colluns; j++){
                if (matriz[i][j] == number) {
                    System.out.println("Posição: " + i + ", " + j);
                    if (i > 0) {
                        System.out.println("Top: " + matriz[i - 1][j]);
                    }
                    if (j > 0) {
                        System.out.println("Left: " + matriz[i][j - 1]);
                    }
                    if (i < lines - 1) {
                        System.out.println("Botton: " + matriz[i + 1][j]);
                    }
                    if (j < colluns - 1) {
                        System.out.println("Right: " + matriz[i][j + 1]);
                    }
                }
            }
        }

        scanner.close();
    }
}