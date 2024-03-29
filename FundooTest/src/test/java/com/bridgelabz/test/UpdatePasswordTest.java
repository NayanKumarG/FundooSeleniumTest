package com.bridgelabz.test;

import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;

import javax.annotation.PropertyKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class UpdatePasswordTest {
	
	public static WebDriver driver;
	
	
	private String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyNCJ9.SsxOKrdA-pkgRPoKphDdd2M2kLmkw0bURdtKu8yc4bD-ivlbqJXtsKqpj1q7HSNb8w-vTsTcP9LQH58dalnZ3Q";

  @BeforeMethod
  public void beforeMethod() {
	  driver = BrowserFactory.getDriver("chrome");
  }
  
  @Test
  public void forgotAccount() throws InterruptedException {
	  
	  driver.get("http://localhost:4200");
		Thread.sleep(4000);
		
		WebElement link = driver.findElement(By.linkText("Forgotten Account?"));
		link.click();
		Thread.sleep(4000);
		
		WebElement email = driver.findElement(By.id("mat-input-2")); 
		email.sendKeys("nayangunditharu@gmail.com");
		Thread.sleep(4000);
		WebElement submit = driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")); 
		submit.click();
		Thread.sleep(10000);
  }
  
  @Test
  public void updatePassword() throws InterruptedException {
	  
	  driver.get("http://localhost:4200/resetPassword/"+token);
		Thread.sleep(4000);
		
		WebElement password = driver.findElement(By.id("mat-input-0")); 
		password.sendKeys("nayan12345");
		Thread.sleep(4000);
		
		WebElement confirmPassword = driver.findElement(By.id("mat-input-1")); 
		confirmPassword.sendKeys("nayan12345");
		Thread.sleep(4000);
		

		WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'reset')]")); 
		submit.click();
		Thread.sleep(20000);
		
		String actualUrl="http://localhost:4200/login"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
		
		
  }
  
  @AfterClass
  public void afterMethod()
  {
	  driver.quit();
  }

}
