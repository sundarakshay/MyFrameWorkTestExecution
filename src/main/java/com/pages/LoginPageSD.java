package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.UtilitiesSD;

public class LoginPageSD {

	WebDriver driver;
	By loginButton = By.xpath("//input[@id='login-button']");
	By alertEroorMessage = By.xpath("//h3[text()='Epic sadface: Username is required']");
	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@type='password']");
	By MainHeadingTitle = By.xpath("//div[text()='Swag Labs']");
	By subHeadingTitle = By.xpath("//span[text()='Products']");

	public LoginPageSD(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean verifyLoginButtonTest() {
		// Boolean button = driver.findElement(loginButton).isDisplayed();
		boolean button = UtilitiesSD.isElementDisplayed(driver, loginButton);
		return (button);
	}

	public String verifyAlertMessageBrforeLogin() {
		// String actualLoginErrorMessage =
		// driver.findElement(alertEroorMessage).getText();
		String actualLoginErrorMessage = UtilitiesSD.getTextValue(driver, alertEroorMessage);
		return (actualLoginErrorMessage);
	}

	public void loginButtonClick() {
		// driver.findElement(loginButton).click();
		UtilitiesSD.clickElement(driver, loginButton);
	}

	public void loginUsername(String loginUsername) {
		// driver.findElement(username).sendKeys(loginUsername);
		UtilitiesSD.enterText(driver, username, loginUsername);
	}

	public void loginPassword(String loginPassword) {

		// driver.findElement(password).sendKeys(loginPassword);
		UtilitiesSD.enterText(driver, password, loginPassword);

	}

}
