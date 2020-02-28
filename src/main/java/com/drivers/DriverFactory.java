package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

public static WebDriver driver=null;
	
	private static final int DEFAULT_BROWSER_ID = 2;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			initizlizeDriver(DEFAULT_BROWSER_ID);
		}
		return driver;
	}
	
	private static void initizlizeDriver(int browserID) {
		
		switch (browserID) {
		case 1:
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
			break;
		case 2: 
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		driver.manage().window().maximize();
	}
}
