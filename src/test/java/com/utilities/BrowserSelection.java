package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelection {
	static WebDriver driver;
	
	public static WebDriver UsingChrome()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		return driver;
	}	
	

}
