package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Collaborator {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // A lista agora armazena objetos Employee
        List<entities.Collaborator> employeeList = new ArrayList<>();

        System.out.print("\nHow many employees will be registered? ");
        int qtt = 0;
        do {
            if (!sc.hasNextInt()) {
                System.out.println("[ERRO] Please, type a integer number.");
                sc.nextLine();
                continue;
            }
            qtt = sc.nextInt();
            sc.nextLine();
        } while (qtt <= 0);

        // --- ENTRADA DE DADOS ---
        for (int i = 0; i < qtt; i++) {
            System.out.println("\n--- Employee #" + (i + 1) + " ---");

            int id = 0;
            boolean idValido = false;
            do {
                System.out.print("Id: ");
                if (!sc.hasNextInt()) {
                    System.out.println("[ERRO] Please enter an integer.");
                    sc.nextLine();
                    continue;
                }
                id = sc.nextInt();
                sc.nextLine();

                boolean idExiste = false;
                for (entities.Collaborator existingEmployee : employeeList) {
                    if (existingEmployee.getId() == id) {
                        idExiste = true;
                        break;
                    }
                }

                if (idExiste) {
                    System.out.println("[ERRO] This ID has already been registered.");
                } else {
                    idValido = true;
                }
            } while (!idValido);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: $");
            double salary = sc.nextDouble();
            sc.nextLine();

            entities.Collaborator employee = new entities.Collaborator(id, name, salary);
            employeeList.add(employee);
        }


        // --- Validação do ID ---
        int idToUpdate = 0;
        boolean validIdToUpdate = false;
        do {
            System.out.print("\nEnter the employee id that will have salary increase: ");
            if (!sc.hasNextInt()) {
                System.out.println("[ERRO] Please enter an integer.");
                sc.nextLine();
                continue;
            }
            idToUpdate = sc.nextInt();
            sc.nextLine();

            for (entities.Collaborator employee : employeeList) {
                if (employee.getId() == idToUpdate) {
                    validIdToUpdate = true;
                    break;
                }
            }

            if (!validIdToUpdate) {
                System.out.println("This ID does not exist!");
                validIdToUpdate = true;
            }
        } while (!validIdToUpdate);

        // Aumenta o salário do funcionário selecionado por ID
        for (entities.Collaborator employee : employeeList) {
            if (employee.getId() == idToUpdate) {
                System.out.print("Enter the percentage: ");
                double value = sc.nextDouble();
                double percentage = value / 100;

                double newSalary = employee.getSalary() + (employee.getSalary() * percentage);
                employee.setSalary(newSalary);
                System.out.printf("Salary updated to %s: $%.2f%n", employee.getName(), newSalary);
                break;
            }
        }

        // --- Exibe a lista de funcionários ---
        System.out.println("\nList of employees:");
        for (entities.Collaborator employee : employeeList) {
            System.out.println(employee.getId() + ", " + employee.getName() + ", " + employee.getSalary());
        }

        sc.close();
    }
}
