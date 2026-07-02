package application;

import utils.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Quotation {
    static void main() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? $ ");
        double dollar = sc.nextDouble();
        System.out.print("How many dollars will be bought? R$ ");
        double value = sc.nextDouble();

        double result = CurrencyConverter.price(value, dollar);
        System.out.print("Amount to be paid in reais = R$ " + String.format("%.2f", result));

        sc.close();
    }
}
