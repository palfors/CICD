package com.alforsconsulting.cicd;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by palfors on 10/15/14.
 */
public class CustomerTest {

    @Test
    public void testAddAccount() throws DuplicateCustomerException, DuplicateAccountException {

        String name = "Test Customer";
        double balance = 10.50;

        Customer customer = new Customer(name);
        Account account = new Account(AccountType.CHECKING, balance);
        int accountNumber = account.getAccountNumber();
System.out.println("account #: " + accountNumber);
        customer.addAccount(account);

        assertTrue(customer.getAccount(accountNumber) != null);
    }

    @Test (expected = DuplicateAccountException.class)
    public void testAddDuplicateAccount() throws DuplicateCustomerException, DuplicateAccountException {

        String name = "Test Customer";
        double balance = 10.50;

        Customer customer = new Customer(name);
        Account account = new Account(AccountType.CHECKING, balance);

        int accountNumber = account.getAccountNumber();
        customer.addAccount(account);

        // add duplicate account
        Account duplicateAccount = new Account(accountNumber, AccountType.CHECKING, balance);
        customer.addAccount(duplicateAccount);
    }

}
