package com.bridgelabz.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bridgelabz.framework.BrowserFactory;
import com.bridgelabz.utility.ExcelReadUtil;
import com.bridgelabz.utility.ExtentReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

public class RegistrationTest extends BrowserFactory {
	

  
  @Test(dataProvider = "registerdata")
  public void registrationPage(String name , String useremail , String userpassword , long mob  ) throws InterruptedException {
	  
	  
		driver.get("http://localhost:4200");
		Thread.sleep(4000);
		
		WebElement link = driver.findElement(By.linkText("Create an Account"));
		link.click();
		Thread.sleep(4000);
		WebElement username = driver.findElement(By.id("mat-input-2")); 
		username.sendKeys(name);
		Thread.sleep(4000);
		WebElement email = driver.findElement(By.id("mat-input-3")); 
		email.sendKeys(useremail);
		Thread.sleep(4000);
		WebElement password = driver.findElement(By.id("mat-input-4")); 
		password.sendKeys(userpassword);
		Thread.sleep(4000);
		WebElement phonenum = driver.findElement(By.id("mat-input-5")); 
		phonenum.sendKeys(String.valueOf(mob));
		Thread.sleep(4000);
		WebElement register = driver.findElement(By.xpath("//span[contains(text(),'Register')]")); 
		register.click();
		Thread.sleep(40000);
		String actualUrl="http://localhost:4200/login"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
  }
  
	@DataProvider(name="registerdata")
	public Object[][] registerData()
	{

		ExcelReadUtil config = new ExcelReadUtil("./src/test/resources/register-data.xlsx");

		int rows = config.getRowCount(0);
		Object[][] registerdata = new Object[rows][4];
		
		for(int i=0 ; i <rows ; i++) {
			
			registerdata[i][0]=config.getData(0, i, 0);
			registerdata[i][1]=config.getData(0, i, 1);
			registerdata[i][2]=config.getData(0, i, 2);
			registerdata[i][3]=config.getNumericData(0, i, 3);
			
			
		}
		return registerdata;

	}
 


}
