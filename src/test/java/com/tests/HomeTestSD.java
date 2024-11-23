package com.tests;

import java.io.Console;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utilities.UtilitiesSD;
import jxl.read.biff.BiffException;

public class HomeTestSD extends BaseTestSD {

	@Test(priority = 0, dataProvider = "data", groups = "unit")
	public void verifyMainHeadingTest(String username, String password) {

		login.loginUsername(username);
		login.loginPassword(password);
		login.loginButtonClick();
		String actual = home.verifyMainHeadingAfterLogin();
		Assert.assertEquals(actual, "Swag Labs");

	}

	@Test(priority = 1, dataProvider = "data", groups = "unit")
	public void verifyMainSubHeadingTest(String username, String password) {

		login.loginUsername(username);
		login.loginPassword(password);
		login.loginButtonClick();
		String actual = home.verifyMainSubHeadingAfterLogin();
		Assert.assertEquals(actual, "Products");
	}

	@DataProvider(name = "data")
	public Object[][] testdata() throws Exception {
		Object[][] retObjArr = UtilitiesSD.readExcel();
		return (retObjArr);
	}
}
