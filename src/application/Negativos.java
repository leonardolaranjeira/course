package application;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Negativos {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*
        * Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois N números inteiros
        e armazene-os em um vetor. Em seguida, mostrar na tela todos os números negativos lidos.
        * */

        entities.Negativos negativo;
        negativo = new entities.Negativos();

        System.out.print("\nQuantos números você vai digitar: ");
        int nums = sc.nextInt();

        int leng = 0;
        int[] novoVetor = new int[nums];
        System.out.println("\nDigite valores entre 10 e -10!");

        for (int i = 0; i < nums; i++) {
            System.out.print("Digite o " + (i + 1) + "° Número: ");
            int value = sc.nextInt();

            if (value >= -10 && value <= 10) {
                novoVetor[i] = value;
                if (value < 0) {
                    leng++;
                }
            } else {
                System.out.println("\n[ERRO] Valor fora dos limites solicitados.\n");
                i--;
            }
        }

        negativo.negativos(leng, novoVetor);

        System.out.println("\nNÚMEROS NEGATIVOS: ");
        int[] vet = negativo.getVetor();
        for (int i = 0; i < leng; i++) {
            System.out.println(vet[i]);
        }

        sc.close();
    }
}
