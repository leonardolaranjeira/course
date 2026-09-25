package practice.course.atividades.exception01.model.entities;

import practice.course.atividades.exception01.model.exceptions.DomainException;

public class Account {
    private static final double BALANCE_ZERO = 0.0;

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account() {
        this.balance = BALANCE_ZERO;
        this.withdrawLimit = BALANCE_ZERO;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }


    public void deposit(double amount) {
        if (amount <= BALANCE_ZERO) {
            throw new DomainException("Deposit failed: The value must not be zero or less than zero."
                                    + "Try again!");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > withdrawLimit) {
            throw new DomainException("Withdrawal failed: The amount exceeds withdraw limit.\n");
        }
        if (amount > balance) {
            throw new DomainException("Withdrawal failed: Not enough balance.\n");
        }
        this.balance -= amount;
        System.out.print("New Balance: $" + String.format("%.2f", getBalance()));
    }
}
