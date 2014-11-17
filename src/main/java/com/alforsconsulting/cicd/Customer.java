package com.alforsconsulting.cicd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by palfors on 10/15/14.
 */
public class Customer {

    private String name = null;
    private Map<Integer, Account> accounts = new HashMap<Integer, Account>();

    public Customer()
    {

    }

    public Customer(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void addCheckingAccount(double initialBalance) throws DuplicateAccountException
    {
        Account account = new CheckingAccount(initialBalance);
        addAccount(account);
    }

    public void addAccount(Account account) throws DuplicateAccountException
    {
        // check if account exists
        int accountNumber = account.getAccountNumber();

        if (accounts.containsKey(accountNumber))
        {
            throw new DuplicateAccountException();
        }

        accounts.put(new Integer(accountNumber), account);
    }

    public Account getAccount(int accountNumber)
    {
        return accounts.get(accountNumber);
    }

    public List<Account> getAccounts()
    {
        return new ArrayList<Account>(accounts.values());
    }

}
