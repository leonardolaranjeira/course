package practice.course.atividades.interface01.model.services;

public class BrazilTaxService implements TaxService {
    private static final double TAX_MAX = 0.20;
    private static final double TAX_MIN = 0.15;


    public double tax(double amount) {
        if (amount <= 100) {
            return amount * TAX_MAX;
        } else {
            return amount * TAX_MIN;
        }
    }
}
