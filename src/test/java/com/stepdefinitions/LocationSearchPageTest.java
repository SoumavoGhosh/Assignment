package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.pages.LocationSearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class LocationSearchPageTest  {
	
	private static final Logger log = LogManager.getLogger(LocationSearchPageTest.class);
	 
	 LocationSearchPage locationSearchPage;
	 
	 public LocationSearchPageTest() {
		 locationSearchPage = new LocationSearchPage();
	 }
	
	@Given("user has launched url")
	public void user_has_launched_url() {
		Assert.assertTrue(locationSearchPage.verifyLaunchedURL());
	}

	@When("user types in {string} in the address search bar")
	public void user_types_in_in_the_address_search_bar(String address) {
		Assert.assertTrue(locationSearchPage.typeInAddress(address));
	}

	@Then("user is able to successfully locate {string} on map")
	public void user_is_able_to_successfully_locate_on_map(String address) {
		Assert.assertTrue(locationSearchPage.locateAddress(address));
	}
	
	@Then("user is able to see {string} on map")
	public void user_is_able_to_see_on_map(String componentName) {
	    Assert.assertTrue(locationSearchPage.validateAllMapComponents(componentName));
	}


	

}
