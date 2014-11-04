package com.alforsconsulting.cicd;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by palfors on 10/15/14.
 */
public class HelloBankTest {

    @Test
    public void testAddCustomer() throws DuplicateCustomerException
    {
        HelloBank helloBank = new HelloBank();

        String name = "Test Customer";
        helloBank.addCustomer(new Customer(name));

        assertTrue(helloBank.getCustomer(name) != null);
    }

    @Test (expected = DuplicateCustomerException.class)
    public void testAddDuplicateCustomer() throws DuplicateCustomerException {
        HelloBank helloBank = new HelloBank();

        String name = "Test Customer";
        helloBank.addCustomer(new Customer(name));

        // add the duplicate
        helloBank.addCustomer(new Customer(name));
    }

}
