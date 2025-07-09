package org.example;

import java.util.ArrayList;

public class AccountDisplay {

    public void displayAccountDetails(Account account) {
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAllAccounts(ArrayList<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts/records.");
        } else {
            for (Account account : accounts) {
                account.displayAccountDetails();
                System.out.println("------------------------------");
            }
        }
    }
}
