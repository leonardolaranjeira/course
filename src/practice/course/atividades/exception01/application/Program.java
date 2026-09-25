package practice.course.atividades.exception01.application;

import practice.course.atividades.exception01.model.entities.Account;
import practice.course.atividades.exception01.model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        boolean exit = true;
        while (exit) {
            try {
                Account account = new Account();
                System.out.print("\nEnter account data\n"
                        + "Number: ");
                int num = sc.nextInt();
                account.setNumber(num);

                sc.nextLine();
                System.out.print("Holder: ");
                String holder = sc.nextLine();
                account.setHolder(holder);

                System.out.print("Initial balance: $");
                double balance = sc.nextDouble();
                account.deposit(balance);

                System.out.print("Withdraw limit: $");
                double limit = sc.nextDouble();
                account.setWithdrawLimit(limit);

                System.out.print("\nEnter amount for withdraw: ");
                double amount = sc.nextDouble();
                account.withdraw(amount);

                exit = false;
            } catch (DomainException e) {
                System.out.println(e.getMessage() + "Try Again!");

            } catch (RuntimeException e) {
                System.out.println("\nUnexpected error, Try again!");
            }
        }
    }
}
