package com.bridgelabz.test;

import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegistrationTest {
	
	public static WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = BrowserFactory.getDriver("chrome");
  }
  
  @Test
  public void registrationPage() throws InterruptedException {
	  

		driver.get("http://localhost:4200");
		Thread.sleep(4000);
		
		WebElement link = driver.findElement(By.linkText("Create an Account"));
		link.click();
		Thread.sleep(4000);
		WebElement username = driver.findElement(By.id("mat-input-2")); 
		username.sendKeys("raj");
		Thread.sleep(4000);
		WebElement email = driver.findElement(By.id("mat-input-3")); 
		email.sendKeys("nayangkumar@gmail.com");
		Thread.sleep(4000);
		WebElement password = driver.findElement(By.id("mat-input-4")); 
		password.sendKeys("raj12345");
		Thread.sleep(4000);
		WebElement phonenum = driver.findElement(By.id("mat-input-5")); 
		phonenum.sendKeys("9048200622");
		Thread.sleep(4000);
		WebElement register = driver.findElement(By.xpath("//span[contains(text(),'Register')]")); 
		register.click();
		Thread.sleep(10000);
		String actualUrl="http://localhost:4200/login"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
