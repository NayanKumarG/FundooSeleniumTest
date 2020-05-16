package com.bridgelabz.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;

public class NoteServiceTest extends BrowserFactory  {
	@Test
	public void searchNoteTest() throws InterruptedException
	{
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']")); 
		search.sendKeys("fundoo");
		sleep(7);
		search.clear();
		search.sendKeys("notes");
		sleep(7);
		search.clear();
		search.sendKeys("note");
		sleep(7);
		
	}
	
	@Test
	public void createNote() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.id("createinput")).click();
		sleep(5);
		driver.findElement(By.id("notetitle")).sendKeys("FundooWebApp");
		sleep(3);
		driver.findElement(By.id("notedesc")).sendKeys("Selenium testing for fundoo");
		sleep(5);
		
		
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
