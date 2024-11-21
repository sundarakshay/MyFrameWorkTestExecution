package com.tests;

import org.testng.annotations.Test;
import com.configurations.BaseSD;
import com.pages.*;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTestSD extends BaseSD{

	//public WebDriver driver;
	//String baseURL = "https://www.saucedemo.com/";
	HomePageSD home;
	LoginPageSD login;

	@BeforeMethod
	public void browserInitialise() throws Exception {

		//initialiseBrowser();
		//driver = new ChromeDriver();
		//driver.get(baseURL);
		//driver.manage().window().maximize();
		initialiseBrowser();
		home = new HomePageSD(driver);
		login = new LoginPageSD(driver);
	}

	@AfterMethod
	public void browserQuit() {
		driver.quit();
	}

}