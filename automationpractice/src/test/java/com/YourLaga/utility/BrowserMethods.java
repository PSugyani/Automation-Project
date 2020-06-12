package com.YourLaga.utility;
import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;


public class BrowserMethods extends WebAppCommon
{
	public static String chromeDriverPath;
	private String BrowserName=PropertyHandler.getProperty("BrowserName");

	
	@BeforeSuite
	public void createHtmltView() throws IOException, AWTException  
	{
		openBrowser(BrowserName);
		driver.get(PropertyHandler.getProperty("url"));
		
	}
	@BeforeTest
	public void loadApplicationUrl()
	{
	}
	@BeforeClass
	public void openBrowser() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void loadLocater() throws IOException
	{
		
		
	}
	@AfterClass
	public void closeBrowser() throws Exception
	{
		
	}
	@AfterTest
	public void loadAllTestLogor() 
	{
	}
	@AfterSuite
	public void closeAllBrowser()
	{
		driver.quit();
	}

	

	@AfterMethod
	public void postTestCaseExecution(ITestResult result ,Method method) throws Exception
	{
		getLogOut();
	}

	}



