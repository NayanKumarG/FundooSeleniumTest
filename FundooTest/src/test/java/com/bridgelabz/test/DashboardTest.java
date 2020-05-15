package com.bridgelabz.test;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;

public class DashboardTest extends BrowserFactory{


	@Test
	public void dashboardTest() throws InterruptedException {

//		driver.get("http://localhost:4200/dashboard");
//		LocalStorage local = ((WebStorage) driver).getLocalStorage();    
//		local.setItem("token", token);

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(10);
		WebElement menu = driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")); 
		menu.click();
		sleep(10);
	
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click(); 
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Reminders')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Archive')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Trash')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click();
		sleep(5);
		
	
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(5);
		
		WebElement view = driver.findElement(By.xpath("//mat-icon[contains(text(),'view_agenda')]"));
		view.click();
		sleep(3);
	}
	
	@Test
	public void searchNoteTest() throws InterruptedException
	{
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(5);
		driver.get("http://localhost:4200/dashboard");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']")); 
		search.sendKeys("fundoo");
		sleep(7);
		search.clear();
		search.sendKeys("notes");
		sleep(10);
		
	}


	public void sleep(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
