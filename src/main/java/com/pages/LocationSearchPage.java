package com.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.DriverFactory;
import com.common.Interaction;

public class LocationSearchPage {
	
	private static final Logger log = LogManager.getLogger(LocationSearchPage.class);
	 
	 private WebDriver driver= null;
	 private Interaction intrct = null;
	 

		@FindBy(xpath="//input[@id='search_property']")
		private WebElement addressSearchBar;
		
		@FindBy(xpath="//div[@id='search-icon']")
		private WebElement addressSearchButton;	
		
		@FindBy(xpath="//div[@class='autocom-box']//li[2]")
		private WebElement selectAddress;
		
		@FindBy(xpath="//div[@id='markerInfoContent']//span")
		private WebElement locatedAddress;	
		
		@FindBy(xpath="//div[@id='Community']")
		private WebElement community;	
		
		@FindBy(xpath="//div[@id='SchoolQueryInfo']")
		private WebElement schoolQuery;	
		
		@FindBy(xpath="//div[@id='Medical']")
		private WebElement medical;
		
		@FindBy(xpath="//div[@id='HawkerCentres']")
		private WebElement hawkerCentres;	
		
		@FindBy(xpath="//div[@id='btn2D3D']")
		private WebElement threeDMap;	
		
		@FindBy(xpath="//div[@id='drawTools']")
		private WebElement drawTools;	
		
		@FindBy(xpath="//div[@id='shareview']")
		private WebElement shareView;	
		
		@FindBy(xpath="//div[@id='getMyLoc']")
		private WebElement getMyLocation;	
		
		@FindBy(xpath="//div[@class='zoomBtnWrapper']")
		private WebElement zoomButton;	
		
		public LocationSearchPage(){
			driver= DriverFactory.getDriver();
			intrct= Interaction.getInstance();
			PageFactory.initElements(driver,this);
		}
		
		public boolean verifyLaunchedURL() {
			log.info(" verifying page launched");
			return intrct.waitForElementToBeVisible(addressSearchBar);
		} 
		
		public boolean typeInAddress(String address) {
			log.info(" verifying address typed successfully ");			
			if(intrct.setTextToElement(addressSearchBar, address)) {
				try {
					Thread.sleep(7000);
					if(intrct.clickElementUsingJSExecutor(selectAddress)) {
						return true;
					} else {
						return false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					return false;
				}			
			} else {
				return false;
			}
		}
		
		public boolean locateAddress(String address) {
			log.info(" verifying address located successfully ");
			return intrct.verifyElementText(locatedAddress, address);
		}
		
		public boolean validateAllMapComponents(String componentName) {
			
			String s=componentName;
				switch(s) {
				  case "address search bar":
					  if(intrct.waitForElementToBeVisible(addressSearchBar))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "community":
					  if(intrct.waitForElementToBeVisible(community))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "school query info":
					  if(intrct.waitForElementToBeVisible(schoolQuery))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "medical":
					  if(intrct.waitForElementToBeVisible(medical))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "hawker centres":
					  if(intrct.waitForElementToBeVisible(hawkerCentres))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "threeDMap":
					  if(intrct.waitForElementToBeVisible(threeDMap))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "draw tools":
					  if(intrct.waitForElementToBeVisible(drawTools))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "share view":
					  if(intrct.waitForElementToBeVisible(shareView))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "get my location":
					  if(intrct.waitForElementToBeVisible(getMyLocation))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  case "zoom button":
					  if(intrct.waitForElementToBeVisible(zoomButton))
					  {
						  log.info(s+" found successfully ");
						  return true;
					  }else {
						  log.info(s+" was not found ");
					  }						 
				    break;
				  default:
					  log.info("No match found ");
					  break;
				}
			return false;
		}
	
}