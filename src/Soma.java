import java.util.ArrayList;
import java.util.Scanner;

public class Soma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int soma = 0;

        System.out.print("Digite a quantidade de números que deseja inserir: ");
        int quantidade = scanner.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o " + i + "º valor: ");
            int numero = scanner.nextInt();
            numeros.add(numero);
            soma += numero;
        }

        System.out.println("\n--- Resultado ---");
        System.out.println("Números armazenados: " + numeros);
        System.out.println("Soma total dos números: " + soma);

        scanner.close();
    }
}