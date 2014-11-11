package com.alforsconsulting.cicd;

/**
 * Created by palfors on 10/29/14.
 */
public class CheckingAccount implements Account {

    private int accountNumber;
    private AccountType accountType = AccountType.CHECKING;
    private double balance;

    public CheckingAccount(double balance)
    {
        setAccountNumber(generateAccountNumber());
        setBalance(balance);
    }

    public CheckingAccount(int accountNumber, double balance)
    {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public AccountType getAccountType() {
        return accountType;
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

    public void withdraw(double amount) throws InsufficientFundsException
    {
        if (balance < amount)
            throw new InsufficientFundsException(accountNumber, balance, amount);

        balance -= amount;
    }

    public void transferTo(Account account, double amount) throws InvalidAccountException, InsufficientFundsException
    {
        if (account == null)
            throw new InvalidAccountException();

        if (account.getBalance() < amount)
            throw new InsufficientFundsException(account.getAccountNumber(), account.getBalance(), amount);

        withdraw(amount);
        account.deposit(amount);
    }

    public static int generateAccountNumber()
    {
        // account #s are 5 digits
        return new Double(Math.round(100000 * Math.random())).intValue();
    }

}
