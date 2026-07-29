package ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // A lista agora armazena objetos Employee, não List<Object>
        List<EntTeste> employeeList = new ArrayList<>();

        System.out.print("\nHow many employees will be registered? ");
        int qtt = 0;
        do {
            if (!sc.hasNextInt()) {
                System.out.println("[ERRO] Por favor, digite um número inteiro.");
                sc.nextLine(); // Limpa o input inválido para tentar de novo
                continue;
            }
            qtt = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha
        } while (qtt <= 0);


        // --- ENTRADA DE DADOS ---
        for (int i = 0; i < qtt; i++) {
            System.out.println("\n--- Employee #" + (i + 1) + " ---");

            int id = 0;
            boolean idValido = false;
            do {
                System.out.print("\nId: ");
                if (!sc.hasNextInt()) {
                    System.out.println("[ERRO] Por favor, digite um número inteiro.");
                    sc.nextLine(); // Limpa o input inválido para tentar de novo
                    continue;
                }
                id = sc.nextInt();
                sc.nextLine();

                boolean idExiste = false;
                for (EntTeste existingEmployee : employeeList) {
                    if (existingEmployee.getId() == id) {
                        idExiste = true;
                        break;
                    }
                }

                if (idExiste) {
                    System.out.println("[ERRO] Este ID já foi cadastrado.");
                } else {
                    idValido = true;
                }
            } while (!idValido);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: $");
            double salary = sc.nextDouble();
            sc.nextLine();

            EntTeste employee = new EntTeste(id, name, salary);
            employeeList.add(employee);
        }


        // --- Aumento do salário ---

        int idToUpdate = 0;
        boolean validIdToUpdate = false;
        do {
            System.out.print("\nEnter the employee id that will have salary increase: ");
            if (!sc.hasNextInt()) {
                System.out.println("[ERRO] Por favor, digite um número inteiro.");
                sc.nextLine();
                continue;
            }
            idToUpdate = sc.nextInt();
            sc.nextLine();

            for (EntTeste employee : employeeList) {
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

        // Aumenta o salário do funcionário selecionado
        for (EntTeste employee : employeeList) {
            if (employee.getId() == idToUpdate) {
                System.out.print("Enter the percentage: ");
                double value = sc.nextDouble();
                double percentage = value / 100;

                double newSalary = employee.getSalary() + (employee.getSalary() * percentage);
                employee.setSalary(newSalary);
                System.out.printf("Salário atualizado para %s: $%.2f%n", employee.getName(), newSalary);
                break;
            }
        }

        // --- Exibe a lista de funcionários ---
        System.out.println("\nList of employees:");
        for (EntTeste employee : employeeList) {
            System.out.println(employee.getId() + ", " + employee.getName() + ", " + employee.getSalary());
        }

        sc.close();
    }
}
