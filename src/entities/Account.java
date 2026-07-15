package entities;

public class Account {
    public static final int MIN_ACCOUNT_NUMBER = 1000;
    public static final int MAX_ACCOUNT_NUMBER = 9999;
    public static final double RATE = 5.00;

    private final int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.name = name;
    }

    public void setInitialBalance(double balance) { this.balance = balance; }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= (value + RATE);
    }

    public String toString() {
        return "Account: " +
                this.accountNumber +
                ", Holder: " +
                this.name +
                ", Balance: $ " +
                this.balance;
    }
}
