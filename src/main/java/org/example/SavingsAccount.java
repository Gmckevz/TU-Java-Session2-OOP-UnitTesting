package org.example;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountHolder, double initialDeposit, int accountNumber) {
        super(accountHolder, initialDeposit, accountNumber);
    }

    @Override
    public void computeInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest Added: " + interest);
    }
}
