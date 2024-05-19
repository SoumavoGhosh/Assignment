package com.common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Interaction {
	
	private static final Logger log = LogManager.getLogger(Interaction.class);
	 WebDriver driver= null;
	 
	private Interaction() {
		driver = DriverFactory.getDriver();
	}

	private static Interaction instance ;
	
	public static Interaction getInstance() {
		if (instance == null) {
			instance = new Interaction();
		}
		return instance;
	}

	public  boolean waitForElementToBeVisible(WebElement element) {
		
		WebElement elm = new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
		if (elm != null) {
			return true;
		} else {
			return false;
		}
	}

	public  boolean clickElement(WebElement element) throws InterruptedException {

		if (waitForElementToBeVisible(element)) {
			element.click();
			Thread.sleep(3000);
			return true;
		} else
			log.info("Couldnt click on " + element.getText());
		return false;
	}
	
	public  boolean clickElementUsingJSExecutor(WebElement element){

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		if (waitForElementToBeVisible(element)) {
			js.executeScript("arguments[0].click()",element);
				return true;
		} else 
				return false;
	}	

	public  boolean setTextToElement(WebElement element, String text) {
		
		if (waitForElementToBeVisible(element)) {
			element.clear();
			element.sendKeys(text);
			return true;
		} else {
			log.info("Couldnt set value " + text);
			return false;
		}
	}
		
	public boolean verifyElementText(WebElement element,String text){
		if (waitForElementToBeVisible(element)) {
			if(element.getText().trim().equalsIgnoreCase(text)){
				return true;
			}else{
				log.info(element.getText()+" is not matching with " + text);
				return false;
			}
			
		} else {
			log.info("Element not found "+ text);
			return false;
		}
	}

}
