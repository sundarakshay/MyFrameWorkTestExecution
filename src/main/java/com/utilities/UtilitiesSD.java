package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UtilitiesSD {

	public static boolean isElementDisplayed(WebDriver driver, By byLocator) {
		boolean present = driver.findElement(byLocator).isDisplayed();
		return present;
	}

	public static void clickElement(WebDriver driver, By byLocator) {
		driver.findElement(byLocator).click();
	}

	public static String getTextValue(WebDriver driver, By byLocator) {
		String result = driver.findElement(byLocator).getText();
		return result;
	}

	public static void enterText(WebDriver driver, By byLocator, String textToSend) {
		driver.findElement(byLocator).clear();
		driver.findElement(byLocator).sendKeys(textToSend);
	}

	public static String getPropertyFileDetails(String propertyName) throws Exception {
		String propertyValue;
		Properties prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/config.properties");
		prop.load(fil);
		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}
	public static String[][] readExcel() throws BiffException, IOException {
		String FilePath = "./src/main/resources/TestData.xls";
		String[][] tabArray = null;
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Sheet1");
		int totalNoOfRows = sh.getRows();
		int totalNoOfCols = sh.getColumns();
		tabArray = new String[totalNoOfRows][totalNoOfCols];
		for (int row = 0; row < totalNoOfRows; row++) {
			for (int col = 0; col < totalNoOfCols; col++) {
				tabArray[row][col] = sh.getCell(col, row).getContents();
			}
		}
		return tabArray;
	}
}
