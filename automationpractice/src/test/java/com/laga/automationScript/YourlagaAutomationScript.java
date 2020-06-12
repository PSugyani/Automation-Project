package com.laga.automationScript;

import org.testng.annotations.Test;

public class YourlagaAutomationScript extends YourlagaAutomationUtility
{
	@Test(priority=0)
	public void getCreateAccountTest() throws Exception
	{
		getCreateAccount();
	}
	@Test(priority=1)
	public void getDetailOfCreateAccountTest() throws Exception
	{
		getDetailOfCreateAccount();
	}
	@Test(priority=2)
	public void getCustomerAddressDetailsTest() throws Exception
	{
		getCustomerAddressDetails();
	}

}
