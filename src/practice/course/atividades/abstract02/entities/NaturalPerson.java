package practice.course.atividades.abstract02.entities;

public class NaturalPerson extends Person {
    private static final double INCOME = 20000;
    private static final double TAX_RATE_HEALTHCARE = 0.50;
    private static final double TAX_RATE_MIN = 0.15;
    private static final double TAX_RATE_MAX = 0.25;


    private Double healthcareExpenses;


    public NaturalPerson(String name, Double annualIncome) {
        super(name, annualIncome);
    }

    public NaturalPerson(String name, Double annualIncome, Double healthcareExpenses) {
        super(name, annualIncome);
        this.healthcareExpenses = healthcareExpenses;
    }


    public Double getHealthcareExpenses() {
        return healthcareExpenses * TAX_RATE_HEALTHCARE;
    }

    public void setHealthcareExpenses(Double healthcareExpenses) {
        this.healthcareExpenses = healthcareExpenses;
    }

    @Override
    public Double getAnnualIncome() {
        if (super.getAnnualIncome() < INCOME) {
            return (super.getAnnualIncome() * TAX_RATE_MIN) - getHealthcareExpenses();
        } else {
            return (super.getAnnualIncome() * TAX_RATE_MAX) - getHealthcareExpenses();
        }
    }
}
