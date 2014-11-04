package com.alforsconsulting.cicd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by palfors on 10/15/14.
 */
public class HelloBank
{

    private Map<String, Customer> customers = new HashMap<String, Customer>();

    public void addCustomer(Customer customer) throws DuplicateCustomerException
    {
        // check if account exists
        String name = customer.getName();
        if (customers.containsKey(name))
        {
            throw new DuplicateCustomerException();
        }

        customers.put(name, customer);
    }

    public Customer getCustomer(String name)
    {
        return customers.get(name);
    }

    public List<Customer> getCustomers()
    {
        return new ArrayList<Customer>(customers.values());
    }

    public void removeCustomer(Customer customer)
    {
        customers.remove(customer.getName());
    }

}
