package com.alforsconsulting.cicd.cucumber;

import com.alforsconsulting.cicd.Customer;
import com.alforsconsulting.cicd.DuplicateCustomerException;
import com.alforsconsulting.cicd.HelloBank;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by palfors on 11/21/14.
 */
public class HelloBankStepsDef
{
    HelloBank helloBank = null;

    //Scenario: A customer's name is unique in the system
    @Given("a customer with name (.+) exists")
    public void a_customer_with_name_exists_in_the_system(String name)
        throws DuplicateCustomerException
    {
        helloBank = new HelloBank();
        helloBank.addCustomer(new Customer(name));
    }

    @When("I attempt to create a duplicate user named (.+)")
    public void I_attempt_to_create_a_duplicate_user_named(String name)
    {
        try {
            helloBank.addCustomer(new Customer(name));
        } catch (DuplicateCustomerException e) {
            // expected - do nothing
        }
    }

    @Then("the system should have (\\d+) customer named (.+)")
    public void the_system_should_have_1_customer_named(int count, String name)
    {
        List<Customer> customers = helloBank.getCustomers();

        int customerCount = 0;

        for (Customer customer : customers)
        {
            if (name.equals(customer.getName())) {
                customerCount++;
            }
        }

        assertEquals("Found " + customerCount + " customers named " + name + ".", count, customerCount);

    }

}
