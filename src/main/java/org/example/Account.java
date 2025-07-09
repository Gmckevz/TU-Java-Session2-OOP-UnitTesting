package org.example;

public class Account {
    protected String accountHolder;
    protected double balance;
    protected int accountNumber;

public Account(String accountHolder, double balance, int accountNumber) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Withdraw amount must be positive.");
        return;
    }
    if (amount > balance) {
        System.out.println("Insufficient funds.");
        return;
    }

    double fee = 0;
    if (amount > 1000) {
        fee = 10;
        System.out.println("A fee of " + fee + "is applied to this transaction");
    }
    balance -= (amount + fee);
    System.out.println("Withdrawn: " + amount + " (Fee: " + fee + ")");
}

    public void computeInterest() {

    }

    public void displayAccountDetails() {
    System.out.println("Account Holder: " + accountHolder);
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Balance: " + balance);
}

public double getBalance() {
    return balance;
}

public int getAccountNumber() {
    return accountNumber;
}

}
