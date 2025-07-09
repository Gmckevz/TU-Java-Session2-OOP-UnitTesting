package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

    private AccountManager accountManager;
    private Account savingsAccount;
    private Account checkingAccount;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();

        // Create test
        savingsAccount = accountManager.createSavingsAccount("John Doe", 1000.0);
        checkingAccount = accountManager.createCheckingAccount("Jane Doe", 1500.0);
    }

    // 1. Verify Account Creation
    @Test
    void testAccountCreation() {
        // Verify savings account creation
        assertNotNull(savingsAccount);
        assertEquals("John Doe", savingsAccount.accountHolder);
        assertEquals(1001, savingsAccount.getAccountNumber());
        assertEquals(1000.0, savingsAccount.getBalance(), 0.01);

        // Verify checking account creation
        assertNotNull(checkingAccount);
        assertEquals("Jane Doe", checkingAccount.accountHolder);
        assertEquals(1002, checkingAccount.getAccountNumber());
        assertEquals(1500.0, checkingAccount.getBalance(), 0.01);
    }

    // 2. Test Deposit Accuracy
    @Test
    void testDeposit() {
        // Deposit into savings account
        savingsAccount.deposit(500.0);
        assertEquals(1500.0, savingsAccount.getBalance(), 0.01);

        // Deposit into checking account
        checkingAccount.deposit(300.0);
        assertEquals(1800.0, checkingAccount.getBalance(), 0.01);
    }

    // 3. Test Withdraw Accuracy
    @Test
    void testWithdraw() {
        savingsAccount.withdraw(200.0);
        assertEquals(800.0, savingsAccount.getBalance(), 0.01);
        checkingAccount.withdraw(1200.0);
        assertEquals(290.0, checkingAccount.getBalance(), 0.01); // 1200 - 10 fee = 590


        double initialBalance = savingsAccount.getBalance();
        savingsAccount.withdraw(1000.0); // withdraw more than available
        assertEquals(initialBalance, savingsAccount.getBalance(), 0.01); // balance remain unchanged
    }

    // 4. Test Withdraw with Insufficient Funds
    @Test
    void testWithdrawWithInsufficientFunds() {
        double initialBalance = checkingAccount.getBalance();
        checkingAccount.withdraw(5000.0);
        assertEquals(initialBalance, checkingAccount.getBalance(), 0.01);
    }

    // 5. Test Compute Interest for Savings Account
    @Test
    void testComputeInterestForSavings() {
        // Assume savings account has 1000, and interest rate is 4%
        savingsAccount.computeInterest();
        assertEquals(1040.0, savingsAccount.getBalance(), 0.01);
    }

    // 6. Test Compute Interest for Checking Account
    @Test
    void testComputeInterestForChecking() {
        // Assume checking account has 1500, and interest rate is 1%
        checkingAccount.computeInterest();
        assertEquals(1515.0, checkingAccount.getBalance(), 0.01);
    }
}