package com.alforsconsulting.cicd;

/**
 * Created by palfors on 10/29/14.
 */
public class InvalidAccountException extends Exception {

    private int accountNumber;

    public InvalidAccountException()
    {
    }

    public InvalidAccountException(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

}
