package com.alforsconsulting.cicd.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by palfors on 11/10/14.
 */

@RunWith(Cucumber.class)
@CucumberOptions (
    tags = { "@login", "@uniqueName" }
)
public class HelloBankCukeIT
{

}
