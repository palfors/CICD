package com.alforsconsulting.cicd;

/**
 * Created by palfors on 10/29/14.
 */
public class InsufficientFundsException extends Exception {

    private int accountNumber;
    private double accountBalance;
    private double amountRequested;

    public InsufficientFundsException(int accountNumber, double accountBalance, double amountRequested)
    {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.amountRequested = amountRequested;
    }

}
