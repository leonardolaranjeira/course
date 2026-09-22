package practice.course.atividades.abstract02;

import practice.course.atividades.abstract02.entities.LegalPerson;
import practice.course.atividades.abstract02.entities.NaturalPerson;
import practice.course.atividades.abstract02.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the number of tax payers: ");
        int num = sc.nextInt();

        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            System.out.print("\nTax payer #" + i + " data:"
                            + "\nIndividual or company (i/c)? ");
            char ch = sc.next().trim().charAt(0);

            System.out.println();
            while (ch != 'i' && ch != 'c') {
                System.out.print("Invalid option, please Try again!"
                                + "\nIndividual or company (i/c): ");
                ch = sc.next().trim().charAt(0);
            }

            System.out.print("Name: ");
            String name = sc.next();

            sc.nextLine();
            System.out.print("Annual Income: ");
            Double annualIncome = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExp = sc.nextDouble();

                persons.add(new NaturalPerson(name, annualIncome, healthExp));
            } else {
                System.out.print("Number of employees: ");
                Integer numOfEmp = sc.nextInt();

                persons.add(new LegalPerson(name, annualIncome, numOfEmp));
            }
        }

        Double totalIncome = 0.0;
        System.out.println("\nTAXES PAID:");
        for (Person person : persons) {
            System.out.printf("%s: $ %.2f%n", person.getName(), person.getAnnualIncome());
            totalIncome += person.getAnnualIncome();
        }
        System.out.printf("\n%s: $ %.2f%n", "TOTAL TAXES: $ ", totalIncome);
        System.out.print("Resolução feita por: Leonardo Laranjeira!");
        sc.close();
    }
}
