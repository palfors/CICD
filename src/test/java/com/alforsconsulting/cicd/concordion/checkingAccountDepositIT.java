package com.alforsconsulting.cicd.concordion;

import com.alforsconsulting.cicd.CheckingAccount;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 * Created by palfors on 11/12/14.
 */
@RunWith(ConcordionRunner.class)
public class checkingAccountDepositIT
{

    public double validateDeposit(double initialBalance, double depositAmount)
    {
        CheckingAccount account = new CheckingAccount(initialBalance);
        account.deposit(depositAmount);

        return account.getBalance();
    }

}
