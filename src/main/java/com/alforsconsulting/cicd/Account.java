package com.alforsconsulting.cicd;

/**
 * Created by palfors on 10/29/14.
 */
public class Account {

    private int accountNumber;
    private AccountType accountType;
    private double balance;


    public Account(AccountType accountType)
    {
        setAccountNumber(generateAccountNumber());
        setAccountType(accountType);
    }

    public Account(AccountType accountType, double balance)
    {
        setAccountNumber(generateAccountNumber());
        setAccountType(accountType);
        setBalance(balance);
    }

    public Account(int accountNumber, AccountType accountType, double balance)
    {
        setAccountNumber(accountNumber);
        setAccountType(accountType);
        setBalance(balance);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public static int generateAccountNumber()
    {
        // account #s are 5 digits
        return new Double(Math.round(100000 * Math.random())).intValue();
    }

}
