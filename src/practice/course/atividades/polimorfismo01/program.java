package practice.course.atividades.polimorfismo01;

import practice.course.atividades.polimorfismo01.entities.Employee;
import practice.course.atividades.polimorfismo01.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int num = sc.nextInt();

        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            sc.nextLine();
            System.out.print("\nEmployee #" + i + " data:\n"
                    + "Outsorced (y/n)? ");
            char ch = sc.nextLine().toLowerCase().charAt(0);

            while(ch != 'n' && ch != 'y') {
                System.out.print("\n[ERROR] Invalid option!" + "\nPlease type 'y' or 'n': ");
                ch = sc.nextLine().toLowerCase().charAt(0);
            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: $ ");
            double valuePerHour = sc.nextDouble();

            if(ch == 'y') {
                System.out.print("Additional charge: $ ");
                double additionalCharge = sc.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println("\nPAYMENTS:");
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }
        sc.close();
    }
}
