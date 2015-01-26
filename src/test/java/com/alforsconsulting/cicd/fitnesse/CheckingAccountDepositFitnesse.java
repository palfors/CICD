package com.alforsconsulting.cicd.fitnesse;

import com.alforsconsulting.cicd.*;
import gherkin.formatter.Format;

/**
 * Created by palfors on 11/11/14.
 */
public class CheckingAccountDepositFitnesse {

    public CheckingAccountDepositFitnesse()
    {
    }

    Account account;

    private double balance = 0;
    private double amount = 0;

    public void setBalance(double startingBalance) {
        this.balance = startingBalance;
    }

    public void setAmount(double depositAmount) {
        this.amount = depositAmount;
    }

    public void execute() { // executed after each table row
        // create a checking account with initial balance
        account = new CheckingAccount(balance);

        account.deposit(amount);
    }

    public double result()
    {
        return account.getBalance();
    }


}
