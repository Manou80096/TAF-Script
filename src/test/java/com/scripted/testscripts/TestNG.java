package com.scripted.testscripts;


import org.junit.Assert;
import org.testng.annotations.Test;

public class TestNG {

    @Test(priority = 0, description = "Sample TestNG Eclipse Che Test")
    public void sampleTestNG() throws Exception{
        System.out.println("First Step");        
        Assert.assertTrue("A Simple TestNG script from Eclipse Che", true);        
	}

}