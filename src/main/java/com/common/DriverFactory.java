package com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public  WebDriver initializeDriver(String browserType) {
		
		if(browserType.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
		}else if (browserType.equalsIgnoreCase("")) {
			
		}else {
			System.out.println(" Please run the tests with chrome browser type");
			}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	    }
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public static void closeDriver() {
		tlDriver.get().close();
		tlDriver.remove();
	}
	
}