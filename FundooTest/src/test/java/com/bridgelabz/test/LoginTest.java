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

public class LoginTest extends BrowserFactory{


	
	public static void loginPage(String username , String pass) throws InterruptedException  {


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

	}
	
}
