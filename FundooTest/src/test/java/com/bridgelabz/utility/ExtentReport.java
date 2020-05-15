package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public ExtentReports setExtent(String reportName) {
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName+".html");
		htmlReport.config().setDocumentTitle("Automation report");
		htmlReport.config().setReportName("Functional report");
		htmlReport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Tester name", "Nayan");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}
	
	public void endReport()
	{
		extent.flush();
	}
	
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed:"+result.getName());
			test.log(Status.FAIL, "Test case failed:"+result.getThrowable());
			test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath("D:\\FundooSelenium\\FundooTest\\screen-shots").build());
		}
	}
	
	public static String getScreenshot(WebDriver driver , String name) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"/screenshots/"+name+dateName+".png";
		File finalDest = new File(destination);
		FileUtils.copyFile(source , finalDest);
		return destination;
		
	}

}
