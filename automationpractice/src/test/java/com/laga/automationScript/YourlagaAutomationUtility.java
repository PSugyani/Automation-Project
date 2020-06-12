package com.laga.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.YourLaga.utility.BrowserMethods;

public class YourlagaAutomationUtility extends BrowserMethods 
{
	String SignInXpath= "//div[@class='row']/nav/div[1]/a";
	String EmailAddressTextBoxXpath = "//input[@id='email_create']";
	String CreateAccountButtonXpath = "//button[@id='SubmitCreate']";
	String MrsButtonClickpath = "//div[@id='uniform-id_gender2']/span/input";
	String FirstNameTextBoxXpath = "//input[@id='customer_firstname']";
	String LastNameTextBoxXpath ="//input[@id='customer_lastname']";
	String PasswordTextBoxXpath ="//input[@id='passwd']";
	String DaySelectXpath = "//div[@id='uniform-days']";
	String Day15Xpath = "//select[@id='days']/option[15]";
	String MonthSelectXpath = "//div[@id='uniform-months']";
	String Month10Xpath= "//select[@id='months']/option[10]";
	String YearSelectXpath = "//div[@id='uniform-years']";
	String Year2002Xpath = "//select[@id='years']/option[19]";
	String FirstNameAddressXpath = "//input[@id='firstname']";
	String LastNameAddressXpath = "//input[@id='lastname']";
	String CompanyAddressXpath = "//input[@id='company']";
	String Address1TextBoxXpath="//input[@id='address1']";
	String Address2TextBoxXpath="//input[@id='address2']";
	String CityTextBoxXpath="//input[@id='city']";
	String StateSelectXpath = "//div[@id='uniform-id_state']";
	String StateIndiansOptionXpath = "//select[@id='id_state']/option[16]";

	String PostalCodeTextBoxXpath = "//input[@id='postcode']";
	String CountrySelectXpath ="//div[@id='uniform-id_country']";
	String CountryUsOptionXpath = "//select[@id='id_country']/option[2]";
	
	String HomePhoneTextBoxXpath = "//input[@id='phone']";
	String phone_mobileTextBoxXpath="//input[@id='phone_mobile']";
	String FutureRefAddressXpath="//input[@id='alias']";
	String RegisterbuttonXpath = "//button[@id='submitAccount']";
	String SignOutButtonXpath = "//div[@class='row']/nav/div[2]/a[@class='logout']";
	String WomanTabXpath = "//div[@id='block_top_menu']/ul/li[1]/a";
	

	
	public void getCreateAccount() throws Exception 
	{
		getWaitForElementPresent(SignInXpath, 10);
		WebElement SignInelement = driver.findElement(By.xpath(SignInXpath)); 
		getMouseMoveMentClick(SignInelement);
		getScrrolToWebElement(EmailAddressTextBoxXpath);
		getWaitForElementPresent(EmailAddressTextBoxXpath, 10);
		typeTextByXpath(EmailAddressTextBoxXpath, EmailAddressTextBoxXpath, emailId);
		clickIdentifierXpath(CreateAccountButtonXpath , CreateAccountButtonXpath);

	}
	public void getDetailOfCreateAccount() throws Exception
	{
		clickIdentifierXpath(MrsButtonClickpath, MrsButtonClickpath);
		typeTextByXpath(FirstNameTextBoxXpath, FirstNameTextBoxXpath, FirstName);
		typeTextByXpath(LastNameTextBoxXpath, LastNameTextBoxXpath, LastName);
		scroolToButtom();
		typeTextByXpath(PasswordTextBoxXpath, PasswordTextBoxXpath, Password1);
		getWaitForElementPresent(DaySelectXpath, 90);
		clickIdentifierXpath(DaySelectXpath,DaySelectXpath);
		clickIdentifierXpath(Day15Xpath, Day15Xpath);
		getWaitForElementPresent(MonthSelectXpath, 90);
		clickIdentifierXpath(MonthSelectXpath, MonthSelectXpath);
		clickIdentifierXpath(Month10Xpath, Month10Xpath);
		clickIdentifierXpath(YearSelectXpath, YearSelectXpath);
		clickIdentifierXpath(Year2002Xpath, Year2002Xpath);
		

	}
	public void getCustomerAddressDetails() throws Exception
	{
		scroolToButtom();
		typeTextByXpath(FirstNameAddressXpath, FirstNameAddressXpath, FirstName);
		typeTextByXpath(LastNameAddressXpath, LastNameAddressXpath, LastName);
		typeTextByXpath(CompanyAddressXpath, CompanyAddressXpath, CompanyName);
		typeTextByXpath(Address1TextBoxXpath, Address1TextBoxXpath, Address);
		typeTextByXpath(Address2TextBoxXpath, Address2TextBoxXpath, Address2);
		typeTextByXpath(CityTextBoxXpath, CityTextBoxXpath, City);
		clickIdentifierXpath(StateSelectXpath, StateSelectXpath);
		clickIdentifierXpath(StateIndiansOptionXpath, StateIndiansOptionXpath);
		
		typeTextByXpath(PostalCodeTextBoxXpath, PostalCodeTextBoxXpath, PostalCode);
		clickIdentifierXpath(CountrySelectXpath, CountrySelectXpath);
		clickIdentifierXpath(CountryUsOptionXpath, CountryUsOptionXpath);
		
		typeTextByXpath(HomePhoneTextBoxXpath, HomePhoneTextBoxXpath, HomePhone);
		typeTextByXpath(phone_mobileTextBoxXpath, phone_mobileTextBoxXpath, phonemobile);
		typeTextByXpath(FutureRefAddressXpath, FutureRefAddressXpath, FutureRefAddress);
		clickIdentifierXpath(RegisterbuttonXpath, RegisterbuttonXpath);
		clickIdentifierXpath(SignOutButtonXpath, SignOutButtonXpath);
	}
	public void getQuickView() throws Exception
	{
		getWaitForElementPresent(SignInXpath, 10);
	//	WebElement SignInelement = driver.findElement(By.xpath(SignInXpath)); 
		//getMouseMoveMentClick(SignInelement);
		clickIdentifierXpath(SignInXpath, SignInXpath);
		getLogin();
	
	}
}
