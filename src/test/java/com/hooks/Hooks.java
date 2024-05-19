package com.hooks;

import org.openqa.selenium.WebDriver;

import com.common.ConfigReader;
import com.common.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  {
	
	ConfigReader cnfgRedr=null;
	DriverFactory dvFctry=null;
	WebDriver driver=null;

	@Before(order=0)
	public  void setupBrowser() throws InterruptedException {

		cnfgRedr=new ConfigReader();
		dvFctry=new DriverFactory();
		driver = dvFctry.initializeDriver(cnfgRedr.initializeProp().getProperty("browser"));
	}
	
	@Before(order=1)
	public  void launchURL() {
		driver.get(cnfgRedr.initializeProp().getProperty("url"));
	}

	@After(order=0)
	public  void quitBrowser() throws Exception {
		driver.close();
	}

}
