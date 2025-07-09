package org.example;

import java.util.Scanner;

public class Bank {
    private AccountManager accountManager;
    private AccountDisplay accountDisplay;

    public Bank() {
        accountManager = new AccountManager();
        accountDisplay = new AccountDisplay();
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.println("=====Welcome to GBank=====");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Checking Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Compute Interest");
        System.out.println("6. Display Account Details");
        System.out.println("7. Display All Accounts");
        System.out.println("8. Exit");
        do {
            System.out.print("Enter choice:");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String savingsHolder = scan.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double savingsDeposit = scan.nextDouble();
                    bank.accountManager.createSavingsAccount(savingsHolder, savingsDeposit);
                    SavingsAccount savingAccount = bank.accountManager.createSavingsAccount(savingsHolder, savingsDeposit);
                    System.out.println("Savings account added!" + savingAccount.getAccountNumber());
                    break;
                case 2:
                    System.out.print("Enter account holder name: ");
                    String checkingHolder = scan.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double checkingDeposit = scan.nextDouble();
                    bank.accountManager.createCheckingAccount(checkingHolder, checkingDeposit);
                    System.out.println("Checking account added!");
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scan.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scan.nextDouble();
                    Account depositAccount = bank.accountManager.findAccountByNumber(depositAccountNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scan.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scan.nextDouble();
                    Account withdrawAccount = bank.accountManager.findAccountByNumber(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter account number: ");
                    int interestAccountNumber = scan.nextInt();
                    Account interestAccount = bank.accountManager.findAccountByNumber(interestAccountNumber);
                    if (interestAccount != null) {
                        interestAccount.computeInterest();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 6:
                    System.out.println("Enter account number: ");
                    int accountDetailsNumber = scan.nextInt();
                    Account accountDetails = bank.accountManager.findAccountByNumber(accountDetailsNumber);
                    bank.accountDisplay.displayAccountDetails(accountDetails);
                    break;
                case 7:
                    bank.accountDisplay.displayAllAccounts(bank.accountManager.getAccounts());
                    break;
                case 8:
                    System.out.println("Exiting....");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);


    }
}