package entities;

public class Employee {
    public String name;
    public double GrossSalary;
    public double Tax;

    public double NetSalary() {
        return GrossSalary -= Tax;
    }

    public void IncreseSalary(double percentage) {
        this.GrossSalary += this.GrossSalary * (percentage / 100.0);
    }
}
