package com.alforsconsulting.cicd;

/**
 * Created by palfors on 10/29/14.
 */
public interface Account {

    public int getAccountNumber();
    public void setAccountNumber(int accountNumber);

    public double getBalance();
    public void setBalance(double balance);

    public void deposit(double amount);
    public void withdraw(double amount) throws InsufficientFundsException;
    public void transferTo(Account account, double amount) throws InvalidAccountException, InsufficientFundsException;

}
