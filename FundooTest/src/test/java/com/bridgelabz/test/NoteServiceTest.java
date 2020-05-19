package com.bridgelabz.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);
		
		
	}
	
	@Test
	public void updateNote() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scrollBy(0,1000)");
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		sleep(5);
		driver.findElement(By.xpath("//mat-card-title[contains(text(),'fundoo')]")).click();
		sleep(5);
		WebElement title = driver.findElement(By.id("updatetitle"));
		title.clear();
		sleep(5);
		title.sendKeys("Fundooupdated");
		sleep(5);
		WebElement desc = driver.findElement(By.id("updatedesc"));
		desc.clear();
		sleep(5);
		desc.sendKeys("updation testing");
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		sleep(10);
		
	
		
	}
	
	@Test
	public void deleteNote() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[5]//span[1]//mat-icon[1]")).click();
		sleep(5);
		driver.findElement(By.xpath("//button[contains(text(),'Delete Note')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();; 
		sleep(5);
	
		driver.findElement(By.xpath("//span[contains(text(),'Trash')]")).click(); 
		sleep(5);


		
	}
	
	@Test
	public void archieveNote() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(20);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//div[1]//button[1]//span[1]//mat-icon[1]")).click();
		sleep(5);
	
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();; 
		sleep(5);
	
		driver.findElement(By.xpath("//span[contains(text(),'Archive')]")).click(); 
		sleep(10);
	
	}
	
	@Test
	public void addColor() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[3]//span[1]//mat-icon[1]")).click();
		sleep(5);
	
		driver.findElement(By.xpath("//div[@class='mat-menu-content']//div[1]//div[1]//button[1]")).click();; 
		sleep(5);
		
//		driver.findElement(By.xpath("//div[@class='cdk-overlay-connected-position-bounding-box']//div[2]//div[3]//button[1]")).click();; 
//		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);

	
	}
	
	@Test
	public void addReminder() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//body/app-root/app-dashboard[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='sidenav-div']/mat-sidenav-container[@class='sidenav-container mat-drawer-container mat-sidenav-container']/mat-sidenav-content[@class='sidenav-content mat-drawer-content mat-sidenav-content']/app-displaynotes[@class='ng-star-inserted']/div[@class='ng-star-inserted']/div[@class='container']/div/div[1]/app-note[1]/div[1]/div[1]/mat-card[1]/div[4]/app-icons[1]/div[1]/button[1]")).click();
		sleep(5);
	
		driver.findElement(By.id("later")).click();
		sleep(5);
		
//		driver.findElement(By.xpath("tommorrow")).click();; 
//		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);

	
	}
	
	@Test
	public void addColloborator() throws InterruptedException {
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.cssSelector("app-dashboard.ng-star-inserted:nth-child(2) div.dashboard div.sidenav-div mat-sidenav-container.sidenav-container.mat-drawer-container.mat-sidenav-container mat-sidenav-content.sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-displaynotes.ng-star-inserted:nth-child(2) div.ng-star-inserted:nth-child(1) div.container:nth-child(3) div.ng-star-inserted:nth-child(1) div.container div.mat-display mat-card.mat-card div.ng-star-inserted:nth-child(6) app-icons:nth-child(1) div.note-icon button.mat-icon-button.mat-button-base:nth-child(2) span.mat-button-wrapper > mat-icon.mat-icon.notranslate.material-icons.mat-icon-no-color")).click();
		sleep(5);
	
		driver.findElement(By.id("collabemail")).sendKeys("nayangkumar@gmail.com");
		sleep(5);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'done')]")).click();
		sleep(5);
		

		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
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
