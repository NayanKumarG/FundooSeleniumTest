package com.bridgelabz.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver getDriver(String browserName)
	{
		if(driver==null)
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				//				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				//				driver = new ChromeDriver();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45 , TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45 , TimeUnit.SECONDS);
			}
		}

		return driver;

	}

	@BeforeMethod
	public void beforeMethod() {
		
		driver = BrowserFactory.getDriver("chrome");
	}
	
	 @AfterClass
	  public void afterMethod()
	  {
		  driver.quit();
	  }

}
