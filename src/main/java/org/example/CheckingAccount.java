package org.example;

public class CheckingAccount extends Account{
    private static final double INTEREST_RATE = 0.01;

    public CheckingAccount(String accountHolder, double initialDeposit, int accountNumber) {
        super(accountHolder, initialDeposit, accountNumber);
    }

    @Override
    public void computeInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest Added: " + interest);
    }
}
