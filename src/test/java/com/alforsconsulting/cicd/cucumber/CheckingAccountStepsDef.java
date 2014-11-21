package com.alforsconsulting.cicd.cucumber;

import com.alforsconsulting.cicd.CheckingAccount;
import com.alforsconsulting.cicd.InsufficientFundsException;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * Created by palfors on 11/11/14.
 */
public class CheckingAccountStepsDef {

    CheckingAccount account = null;

    @Given("I have an account with (\\d+)")
    public void I_have_an_account_with(double balance) throws Throwable
    {
        // create an account with <balance>
        account = new CheckingAccount(balance);
    }

    @When("I make a deposit of (\\d+)")
    public void I_make_a_deposit_of(double amount) throws Throwable
    {
        account.deposit(amount);
    }

    @Then("there should be (\\d+) in the account")
    public void There_should_be_amount_in_the_account(double expectedBalance)
    {
        assertEquals("Checking account deposit does not add up!", expectedBalance, account.getBalance(), 0);
    }

    @When("I make a withdrawal of (\\d+)")
    public void I_make_a_withdrawal_of(double amount) throws Throwable
    {
        account.withdraw(amount);
    }

    @When("I attempt to overdraw the account by requesting (\\d+)")
    public void I_attempt_to_overdraw_the_account_by_requesting(double amount) throws Throwable
    {
        try {
            account.withdraw(amount);
        }
        catch (InsufficientFundsException e)
        {
            // expected, do nothing
        }
    }

    @Then("the balance should remain (\\d+)")
    public void the_balance_should_remain(double expectedBalance) throws Throwable
    {
        assertEquals("Overdraw of checking account should not have changed the balance!", expectedBalance, account.getBalance(), 0);
    }

    @Given("the following deposits are applied")
    public void the_following_deposits_are_applied(DataTable dataTable) throws Throwable
    {
        List<Map<String, String>> dataList = dataTable.asMaps();

        Double calculatedResult = null;
        int row = 0;

        for (Map<String,String> map : dataList)
        {
            row++;

            Double initialBalance = new Double(map.get("initial"));
            Double deposit = new Double(map.get("deposit"));
            Double result = new Double(map.get("result"));

            calculatedResult = initialBalance + deposit;

            assertEquals("Failed on row " + row, result, calculatedResult);
        }
    }

}
