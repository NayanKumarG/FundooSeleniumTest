package com.bridgelabz.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bridgelabz.framework.BrowserFactory;

public class LabelServiceTest extends BrowserFactory{


	@Test
	public void createLabelTest() throws InterruptedException {

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
	
//	@Test
//	public void updateLabelTest() throws InterruptedException {
//
//		LoginTest.loginPage("nayangunditharu@gmail.com", "nayan123");
//		sleep(15);
//		driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]")).click();
//		sleep(5);
//		driver.findElement(By.xpath("//span[contains(text(),'Edit labels')]")).click(); 
//		sleep(5);
//		WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-editlabel[1]/div[1]/div[2]/div[2]/div[2]/input[1]")); 
//		element.click();
//		element.sendKeys("fundooTesting");
//		sleep(5);
//		
//		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-editlabel[1]/div[1]/div[2]/div[2]/div[3]/button[1]/span[1]/mat-icon[1]")).click(); 
//		sleep(7);
//		
//	}
	
	@Test
	public void addLabelTest() throws InterruptedException, AWTException {

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
