package com.bridgelabz.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bridgelabz.framework.BrowserFactory;
import com.bridgelabz.utility.ExtentReport;

public class LabelServiceTest extends BrowserFactory{
	
	public ExtentTest test;
	public ExtentReports extent;
	ExtentReport report = new ExtentReport();
	String testName = "labelTestReport";
	

	@BeforeTest 
	public void beforeTest()
	{

		extent = report.setExtent(testName);
	}


	@Test
	public void createLabelTest() throws InterruptedException {
		
		test = extent.createTest("create label");

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Edit labels')]")).click(); 
		sleep(5);
		driver.findElement(By.id("labelName")).sendKeys("selenium");
		sleep(5);
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color'][contains(text(),'check')]")).click(); 
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click(); 
		sleep(7);
		
	}
	
	@Test
	public void deleteLabelTest() throws InterruptedException {
		
		test = extent.createTest("delete label");

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Edit labels')]")).click(); 
		sleep(5);
		driver.findElement(By.xpath("//div[@class='cdk-overlay-container']//div[4]//div[1]//button[1]//span[1]//mat-icon[1]")).click(); 
		sleep(5);
		
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click(); 
		sleep(7);
		
	}
	
	@Test
	public void updateLabelTest() throws InterruptedException {
		test = extent.createTest("update label");

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();
		sleep(5);
		driver.findElement(By.xpath("//span[contains(text(),'Edit labels')]")).click(); 
		sleep(5);
		WebElement element = driver.findElement(By.id("editlabels")); 
		element.clear();
		sleep(5);
		element.sendKeys("fundooTesting");
		sleep(5);
		
		driver.findElement(By.id("rename")).click(); 
		sleep(7);
		
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click(); 
		sleep(7);
		
	}
	
	@Test
	public void addLabelTest() throws InterruptedException, AWTException {
		
		test = extent.createTest("add label");

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[5]//span[1]//mat-icon[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add label')]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
		sleep(5);
		
		
		Robot robot = new Robot();
		robot.mouseMove(900, 420);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);
		
		driver.findElement(By.xpath("//mat-icon[@class='mat-icon notranslate mat-chip-remove mat-chip-trailing-icon material-icons mat-icon-no-color']")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'refresh')]")).click();
		sleep(10);
		
		
		
	}
	
	@Test
	public void addAndMapLabelTest() throws InterruptedException, AWTException {
		
		test = extent.createTest("addandmap label");

		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
		sleep(15);
		driver.findElement(By.xpath("//div[@class='container']//div[2]//app-note[1]//div[1]//div[1]//mat-card[1]//div[4]//app-icons[1]//div[1]//button[5]//span[1]//mat-icon[1]")).click();
		sleep(5);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add label')]")).click();
		sleep(5);
		
		driver.findElement(By.id("searchlabel")).sendKeys("seleniumTesting");;
		sleep(5);
		
		driver.findElement(By.xpath("//span[contains(text(),'create')]")).click();
		sleep(5);
	

		
		Robot robot = new Robot();
		robot.mouseMove(900, 420);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
