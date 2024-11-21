package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.UtilitiesSD;

public class HomePageSD {

	WebDriver driver;
	By MainHeadingTitle = By.xpath("//div[text()='Swag Labs']");
	By subHeadingTitle = By.xpath("//span[text()='Products']");

	public HomePageSD(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyMainHeadingAfterLogin() {
		//String actualHeading = driver.findElement(MainHeadingTitle).getText();
		String actualHeading=UtilitiesSD.getTextValue(driver, MainHeadingTitle);
		return (actualHeading);
	}

	public String verifyMainSubHeadingAfterLogin() {
		//String actualSubHeading = driver.findElement(subHeadingTitle).getText();
		String actualSubHeading = UtilitiesSD.getTextValue(driver, subHeadingTitle);
		return actualSubHeading;
	}
}
