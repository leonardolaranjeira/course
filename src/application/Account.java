package application;

import java.util.Locale;
import java.util.Scanner;

public class Account {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int accountNumber;
        while (true) {
            System.out.print("Enter account number (4 digits): ");
            if (sc.hasNextInt()) { //Lê o que será digitado pelo usuário direto da condição if
                accountNumber = sc.nextInt();

                if (accountNumber >= entities.Account.MIN_ACCOUNT_NUMBER && accountNumber <= entities.Account.MAX_ACCOUNT_NUMBER) {
                    sc.nextLine(); // Limpa o buffer do Scanner
                    break;
                } else {
                    System.out.println("\n[ERROR] The account number must have exactly 4 digits. Please, Try again!\n");
                    sc.nextLine();
                }
            } else {
                System.out.println("\n[ERROR] Please enter a valid number.\n");
                sc.nextLine(); // Descarta a entrada inválida para evitar loop infinito
            }
        }

        String name = "";

        entities.Account account; //Objeto da classe conta
        account = new entities.Account(accountNumber, name);

        while (true) {
            System.out.print("Enter account holder: ");
            name = sc.nextLine().trim().toUpperCase();

            if (name.isBlank()) {
                System.out.println("[Error] Invalid name. Try again!\n");
            } else {
                account.setName(name);
                break;
            }
        }

        while (true) {
            System.out.print("Is there an initial deposit (y/n)? ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("\n[ERROR] Please enter a valid option.\n");
                continue;
            }

            if (input.charAt(0) == 'y') {
                double initialDeposit;
                while (true) {
                    System.out.print("Enter initial deposit value: ");
                    if (sc.hasNextDouble()) {
                        initialDeposit = sc.nextDouble();
                        if (initialDeposit >= 0.0) {
                            account.setInitialBalance(initialDeposit);
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("\n[ERROR] The value must be greater than 0 (zero). Please, try again!\n");
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("\n[ERROR] Invalid value. Please enter a valid number.\n");
                        sc.nextLine();
                    }
                }
                break;
            } else if (input.charAt(0) == 'n') {
                break;
            } else {
                System.out.println("\n[ERROR] Invalid option. Please enter y or n.\n");
            }
        }

        System.out.println("\nAccount data:");
        System.out.println(account);

        while (true) {
            System.out.print("\nDo you want to do anything else?\n" +
                            "1 - Make a deposit\n" +
                            "2 - Make a withdraw\n" +
                            "3 - Check balance\n" +
                            "4 - Exit\n" +
                            "Option: ");
            double amount;
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\nWhat is the deposit amount?");
                    while (true) {
                        System.out.print("Enter deposit value: $ ");
                        if (sc.hasNextDouble()) {
                            amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount >= 0.0) {
                                account.deposit(amount);
                                System.out.println("\nUpdate account data:\n" + account);
                                break;
                            } else {
                                System.out.println("\n[ERROR] The value must be greater than 0 (zero). Please, try again!\n");
                            }
                        } else {
                            System.out.println("\n[ERROR] Invalid value. Please enter a valid number.\n");
                            sc.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nWhat is the withdraw amount?");
                    while (true) {
                        System.out.print("Enter withdraw value: $ ");
                        if (sc.hasNextDouble()) {
                            amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount > 0 && amount <= account.getBalance()) {
                                account.withdraw(amount);
                                System.out.println("\nUpdate account data:\n" + account);
                                break;
                            } else {
                                System.out.println("\n[ERROR] The value must be greater than 0 (zero) or less than the balance amount\n");
                            }
                        } else {
                            System.out.println("\n[ERROR] Invalid value. Please enter a valid number.\n");
                            sc.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nAccount data:\n" + account);
                    break;
                case 4:
                    System.out.println("\nThank you for using our services. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("\n[ERROR] Please enter a valid option.");
                    break;
            }
        }
    }
}
