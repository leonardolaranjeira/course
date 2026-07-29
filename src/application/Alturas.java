package application;

import java.util.Locale;
import java.util.Scanner;

public class Alturas {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("\nQuantas pessoas serão digitadas? ");
        int persons = sc.nextInt();
        sc.nextLine();

        int count = 0;
        String[] names = new String[persons];

        double heights = 0.0;
        for (int i = 0; i < persons; i++) {
            System.out.println("\nDados da " + (i + 1) + "° Pessoa: ");

            System.out.print("Nome: ");
            String name = sc.nextLine();

            System.out.print("Idade: ");
            int age = sc.nextInt();

            if (age < 16) {
                count++;
                names[count - 1] = name;
            }

            System.out.print("height: ");
            double height = sc.nextDouble();
            heights += height;

            sc.nextLine();
        }

        double height_average = 0.0;
        height_average = heights / persons;
        System.out.printf("\nAltura média: %.2f\n", height_average);

        double percentage = ((double) count / persons) * 100;
        System.out.printf("Pessoas com menos de 16 anos: %.2f%%\n", percentage);

        for (int i = 0; i < count; i++) {
            System.out.println(names[i]);
        }

        sc.close();
    }
}
