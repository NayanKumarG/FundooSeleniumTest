package com.bridgelabz.test;

import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;
import com.bridgelabz.utility.ExcelReadUtil;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

@Slf4j
public class LoginTest extends BrowserFactory{


	@Test(dataProvider = "testdata")
	public void loginPage(String username , String pass) throws InterruptedException {


		driver.get("http://localhost:4200");
		Thread.sleep(4000);
		WebElement email = driver.findElement(By.id("mat-input-0")); 
		email.sendKeys(username);
		Thread.sleep(4000);
		WebElement password = driver.findElement(By.id("mat-input-1")); 
		password.sendKeys(pass);
		Thread.sleep(4000);
		WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]")); 
		login.click();
		Thread.sleep(15000);
		
		String actualUrl="http://localhost:4200/dashboard"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
		

	}

//	@DataProvider(name="testdata")
//	public Object[][] loginData()
//	{
//
//		Object[][] logindata = new Object[2][2];
//
//		logindata[0][0]="nayangunditharu@gmail.com";
//		logindata[0][1]="nayan123";
//
//		logindata[1][0]="nayan@gmail.com";
//		logindata[1][1]="nayan12345";
//
//
//
//		return logindata;
//
//	}
	
//	@Test
//	public void readFromExcel()
//	{
//		String[][] data = ExcelReadUtil.readExcelInto2DArray("./src/test/resources/login-data.xlsx", "Sheet1", 2);
//	    System.out.println(data);
//	}
	
	@DataProvider(name="testdata")
	public Object[][] loginData()
	{
		
		ExcelReadUtil config = new ExcelReadUtil("./src/test/resources/login-data.xlsx");

		int rows = config.getRowCount(0);
		Object[][] logindata = new Object[rows][2];
		
		for(int i=0 ; i <rows ; i++) {
			System.out.println(config.getData(0, i, 0));
			System.out.println(config.getData(0, i, 1));
			
			logindata[i][0]=config.getData(0, i, 0);
			logindata[i][1]=config.getData(0, i, 1);
			
			
		}
		return logindata;

	}




}
