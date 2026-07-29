package application;

import java.util.Locale;
import java.util.Scanner;

public class Matriz {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("\nDimensão da matriz (Linhas): ");
        int m = sc.nextInt();

        System.out.print("Dimensões da matriz (Colunas): ");
        int n = sc.nextInt();
        System.out.println();

        int[][] matriz = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Digite o valor para colocar em [%d][%d]: ", i, j);
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.print("\nQuais são os valores que estão em volta do número escolhido na matriz?" +
                        "\nNúmero escolhido: ");
        int num = sc.nextInt();

        boolean hasNumber = false;
        for (int l = 0; l < m; l++) {
            for (int c = 0; c < n; c++) {
                if (matriz[l][c] == num) {
                    hasNumber = true;
                    System.out.printf("\nPosition %d,%d: \n", l, c);

                    if (c > 0) {
                        System.out.println("Left: " + matriz[l][c - 1]);
                    }

                    if (l > 0) {
                        System.out.println("Up: " + matriz[l - 1][c]);
                    }

                    if (c + 1 < n) {
                        System.out.println("Right: " + matriz[l][c + 1]);
                    }

                    if (l + 1 < m) {
                        System.out.println("Down: " + matriz[l + 1][c]);
                    }
                }
            }
        }

        if (hasNumber == false) {
            System.out.printf("\nNão tem número %d nesta matriz.", num);
        }

        sc.close();
    }
}
