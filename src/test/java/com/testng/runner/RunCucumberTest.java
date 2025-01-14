package com.testng.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions; 


@CucumberOptions(

		features = "./src/test/resources/features/", glue = {"com.hooks", "com.stepdefinitions",
				"com.testng.runner"},

		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",	
				"html:target/cucumber-reports/cucumberreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		monochrome = true
		)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
