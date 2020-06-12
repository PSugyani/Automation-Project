
package com.YourLaga.utility;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

//import Flash.FlashObjectWebDriver;

import java.awt.datatransfer.Clipboard;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class WebAppCommon 
{

	public static ExtentReports report; 
	public static ExtentTest logger;
	public static WebDriver driver=null;
	public static Logger Log = Logger.getLogger(WebAppCommon.class.getName());
	protected static int timeoutSeconds = 30;
	private static WebDriverWait wait = null;
	private static String chromeDriver=PropertyHandler.getProperty("ChromeDriver");
	private static String greckoDrive=PropertyHandler.getProperty("FireFoxDriver");
	private static String IEDriver=PropertyHandler.getProperty("IEDriver");
	protected static String emailId=PropertyHandler.getProperty("Email1");
	protected static String FirstName=PropertyHandler.getProperty("FirstName1");
	protected static String LastName=PropertyHandler.getProperty("LastName1");
	protected static String Password1=PropertyHandler.getProperty("Password11");
	protected static String CompanyName=PropertyHandler.getProperty("CompanyName1");
	protected static String Address=PropertyHandler.getProperty("Address1");
	protected static String Address2=PropertyHandler.getProperty("Address21");
	protected static String City=PropertyHandler.getProperty("City1");
	protected static String PostalCode=PropertyHandler.getProperty("PostalCode1");
	protected static String HomePhone=PropertyHandler.getProperty("HomePhone1");
	protected static String phonemobile=PropertyHandler.getProperty("phonemobile1");
	protected static String FutureRefAddress=PropertyHandler.getProperty("FutureRefAddress1");
	protected static String LoginEmailAddress=PropertyHandler.getProperty("LoginEmailAddress1");
	protected static String LoginPassword=PropertyHandler.getProperty("LoginPassword1");
	protected static Screen screen = new Screen();
	protected static String fileDownloadPath = "\\ExportFile\\";
	public	static String  LoginEmailAddressTextBoxXpath ="//input[@id='email']";
	public	static String LoginpasswdTextBoxXpath="//input[@id='passwd']";
	public	static String LoginSignInButtonXpath="//button[@id='SubmitLogin']";
	public	static	String SignOutButtonXpath = "//div[@class='row']/nav/div[2]/a[@class='logout']";

	public static void getLogin() throws Exception
	{
		getWaitForElementPresent(LoginEmailAddressTextBoxXpath, 10);
		typeTextByXpath(LoginEmailAddressTextBoxXpath, LoginEmailAddressTextBoxXpath, LoginEmailAddress);
		typeTextByXpath(LoginpasswdTextBoxXpath, LoginpasswdTextBoxXpath, LoginPassword);
		clickIdentifierXpath(LoginSignInButtonXpath, LoginSignInButtonXpath);
	}
	public static void getLogOut() throws Exception
	{
		clickIdentifierXpath(SignOutButtonXpath, SignOutButtonXpath);
	}
	
	public static void openBrowser(String browser) throws AWTException 
	{
		try 
		{
			if (browser.equalsIgnoreCase("Firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", greckoDrive);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) 
			{

				

			} else if (browser.equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver",IEDriver);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			}

		} catch (WebDriverException e) 
		{

		}
	}

	public void waitPageComplete()
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	
	public static void getWaitForElementPresent(String elementXpath,int time)
	{ 	
		WebDriverWait wt = new WebDriverWait(driver,time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
	}

	public void scroolToButtom()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)", "");
	}
	
	public void getScrrolToWebElement(String ScroolLocater)
	{
		WebElement element = driver.findElement(By.xpath(ScroolLocater));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public  static void getMouseMoveMentClick(WebElement MoveToLocater)
	{
		Actions actions = new Actions(driver);
		WebElement subMenu = MoveToLocater;
		actions.moveToElement(subMenu).click().build().perform();;
	}
	public  static void getMouseMoveMentSendkeys(WebElement MoveToLocater , String sendkey)
	{
		Actions actions = new Actions(driver);
		WebElement subMenu = MoveToLocater;
		actions.moveToElement(subMenu).sendKeys(sendkey).build().perform();;
	}
	public static void clickIdentifierXpath(String element,String xpath) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();
		
	}

	public static void typeTextByXpath(String element,String strHTMLID, String strString) throws Exception
	{
		driver.findElement(By.xpath(strHTMLID)).clear();
		driver.findElement(By.xpath(strHTMLID)).sendKeys(strString);
		
	}

}