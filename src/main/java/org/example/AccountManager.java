package org.example;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;

    public AccountManager() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1001;
    }

    public SavingsAccount createSavingsAccount(String accountHolder, double initialDeposit) {
        SavingsAccount newAccount = new SavingsAccount(accountHolder, initialDeposit, nextAccountNumber++);
        accounts.add(newAccount);
        return newAccount;
    }

    public CheckingAccount createCheckingAccount(String accountHolder, double initialDeposit) {
        CheckingAccount newAccount = new CheckingAccount(accountHolder, initialDeposit, nextAccountNumber++);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
