package practice.course.atividades.abstract02.entities;

public class LegalPerson extends Person {
    private static final double EMPLOYEES = 10;
    private static final double TAX_RATE_MIN = 0.14;
    private static final double TAX_RATE_MAX = 0.16;


    private Integer quantityEmployees;


    public LegalPerson(String name, Double annualIncome) {
        super(name, annualIncome);
    }

    public LegalPerson(String name, Double annualIncome, Integer quantityEmployees) {
        super(name, annualIncome);
        this.quantityEmployees = quantityEmployees;
    }


    public Integer getQuantityEmployees() {
        return quantityEmployees;
    }

    public void setQuantityEmployees(Integer quantityEmployees) {
        this.quantityEmployees = quantityEmployees;
    }

    @Override
    public Double getAnnualIncome() {
        if (quantityEmployees <= EMPLOYEES) {
            return super.getAnnualIncome() * TAX_RATE_MAX;
        } else {
            return super.getAnnualIncome() * TAX_RATE_MIN;
        }
    }
}
