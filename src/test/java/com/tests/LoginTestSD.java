package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageSD;

public class LoginTestSD extends BaseTestSD {

	@Test(priority = 0)
	public void verifyLoginTest() {

		Boolean actual = login.verifyLoginButtonTest();
		Assert.assertEquals(actual, true);
	}

	@Test(priority = 1)
	public void verifyAlertMessageLoginTest() {

		LoginPageSD login = new LoginPageSD(driver);
		login.loginButtonClick();
		String actual = login.verifyAlertMessageBrforeLogin();
		Assert.assertEquals(actual, "Epic sadface: Username is required");
	}

}
