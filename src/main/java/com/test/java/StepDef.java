package com.test.java;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class StepDef {

    @Given("I want to write a step with precondition")
    public void i_want_to_write_a_step_with_precondition() throws Throwable {
    	System.out.println("firstone");
    }

    @Given("I want to write a step with {string}")
    public void i_want_to_write_a_step_with(String str) throws Throwable {
    	System.out.println(str);
    }
    
    @Given("I am")
    public void i_am()
    {
    	System.out.println("I am");
    }
    
    @After
    public void before(Scenario scenario)
    {
    	System.out.println(scenario.getStatus());
    }

}