package utils;

public class CurrencyConverter {

    public static double price(double value, double dollar) {
        double netTotal = value * dollar;
        return netTotal + (netTotal * 0.06);
    }
}
