package com.bridgelabz.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bridgelabz.framework.BrowserFactory;
import com.bridgelabz.utility.ExtentReport;

public class NoteServiceTest extends BrowserFactory  {
	
	
	public ExtentTest test;
	public ExtentReports extent;
	ExtentReport report = new ExtentReport();
	String testName = "noteTestReport";
	

	@BeforeTest 
	public void beforeTest()
	{

		extent = report.setExtent(testName);
	}
	
	@Test
	public void searchNoteTest() throws InterruptedException
	{
		
		test = extent.createTest("Search note");
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
		
		test = extent.createTest("create note");
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
		
		test = extent.createTest("update note");
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
		
		test = extent.createTest("delete note");
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[5]//span[1]//mat-icon[1]")).click();
		sleep(5);
		driver.findElement(By.xpath("//button[contains(text(),'Delete Note')]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(7);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();; 
		sleep(5);
	
		driver.findElement(By.xpath("//span[contains(text(),'Trash')]")).click(); 
		sleep(5);
		
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[3]//mat-card-footer[1]//button[2]//span[1]//mat-icon[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click(); 
		sleep(5);


		
	}
	
	@Test
	public void archieveNote() throws InterruptedException {
		
		test = extent.createTest("archive note");
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(20);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//div[1]//button[1]//span[1]//mat-icon[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(7);
	
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();; 
		sleep(5);
	
		driver.findElement(By.xpath("//span[contains(text(),'Archive')]")).click(); 
		sleep(10);
		
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//div[1]//button[1]//span[1]//mat-icon[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click(); 
		sleep(7);

	
	}
	
	@Test
	public void addColor() throws InterruptedException {
		
		test = extent.createTest("Add color");
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
		
		test = extent.createTest("add reminder");
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
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();; 
		sleep(5);
	
		driver.findElement(By.xpath("//span[contains(text(),'Reminders')]")).click(); 
		sleep(5);

	
	}
	
	@Test
	public void addColloborator() throws InterruptedException {
		
		test = extent.createTest("Add collaborator");
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='ng-star-inserted']//div[@class='container']//div//div[1]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[2]//span[1]//mat-icon[1]")).click();
		sleep(5);
	
		driver.findElement(By.id("collabemail")).sendKeys("nayangkumar@gmail.com");
		sleep(5);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'done')]")).click();
		sleep(5);
		
	
	}
	
	@Test
	public void pinTesting() throws InterruptedException {
		
		test = extent.createTest("pin note");
		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[1]//button[1]//span[1]//mat-icon[1]//img[1]")).click();
		sleep(5);
	
			
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);
		
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[1]//button[1]//span[1]//mat-icon[1]//img[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);

	
	}
	
	  @AfterMethod
	  public void result(ITestResult result) throws IOException
	  {
		  if(result.getStatus() == ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "Test case failed:"+result.getName());
				test.log(Status.FAIL, "Test case failed:"+result.getThrowable());
				String screenshotpath = ExtentReport.getScreenshot(driver, result.getName());
				test.addScreenCaptureFromPath(screenshotpath);
				//				test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screen-shot/reg.jpg").build());
			}
		  else if(result.getStatus() == ITestResult.SUCCESS)
				{
					test.log(Status.PASS, "Test case passed:"+result.getName());
					String screenshotpath = ExtentReport.getScreenshot(driver, result.getName());
					test.addScreenCaptureFromPath(screenshotpath);
//					test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screen-shot/reg.jpg").build());
				}
	  }
	  @AfterTest
	public void afterTest()
	{
		  extent.flush();
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
