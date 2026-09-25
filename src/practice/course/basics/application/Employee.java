package practice.course.basics.application;

import java.util.Locale;
import java.util.Scanner;

public class Employee {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        practice.course.basics.entities.Employee employee;
        employee = new practice.course.basics.entities.Employee();
        System.out.println("Insert employee's data!");

        System.out.print("Name: ");
        employee.name = sc.nextLine();

        System.out.print("Gross salary: ");
        employee.GrossSalary = sc.nextDouble();

        System.out.print("Tax: ");
        employee.Tax = sc.nextDouble();

        employee.NetSalary();
        System.out.println("\nEmployee: " + employee.name + ", $" + employee.GrossSalary);

        System.out.print("\nWhich percentage to increase salary? ");
        double percentage = sc.nextDouble();
        employee.IncreseSalary(percentage);

        System.out.println("Update data: " + employee.name + ", $" + employee.GrossSalary);

        sc.close();
    }
}
