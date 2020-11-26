/*package com.scripted.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.scripted.configurations.SkriptmateConfigurations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/Webservices", plugin = { "json:target/cucumber.json"}, glue = {
				"com.scripted.apistepdefs" }, monochrome = true,tags = { "@testApi" })
public class JunitRunTest {
	 Enable the below code only if you are not using SkpritmateRunner 
	 Also provide the configuration details in SkriptmateConfigurations\SkriptmateConfig.Properties
	
	@BeforeClass
	public static void setup() {
		SkriptmateConfigurations.beforeSuite();
	}

	@AfterClass
	public static void teardown() {
		SkriptmateConfigurations.afterSuite();
	}
}*/