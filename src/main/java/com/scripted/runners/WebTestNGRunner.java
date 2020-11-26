package com.scripted.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features/test", plugin = { "json:target/cucumber.json",
		"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
		"html:target/cucumber.html" }, glue = { "com.test.java" }, monochrome = true, tags = { "@tag" })
public class WebTestNGRunner extends AbstractTestNGCucumberTests {
	/*@BeforeSuite
	public void setup() {
		SkriptmateConfigurations.beforeSuite();
	}

	@AfterSuite
	public void teardown() {
		SkriptmateConfigurations.afterSuite();
	}*/
}