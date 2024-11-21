package com.configurations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.utilities.UtilitiesSD;

public class BaseSD {
	
	public static WebDriver driver;
	public static ChromeOptions chromeOptions;
	public static FirefoxOptions firefoxOptions;
	public static EdgeOptions edgeOptions;
	String baseURL = "https://www.saucedemo.com/";
	
	
	public void initialiseBrowser() throws Exception {
		String browser =System.getProperty("browserName", UtilitiesSD.getPropertyFileDetails("browser"));
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("headlesschrome")) {
			
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browser.equalsIgnoreCase("headlessfirefox")) {
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			driver = new FirefoxDriver(firefoxOptions);
		}
		else if(browser.equalsIgnoreCase("headlessedge")) {
			edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
		}
		else {
			System.out.println("Entered browser name is Invalid");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		driver.get(UtilitiesSD.getPropertyFileDetails("url"));
		driver.manage().window().maximize();
	}

}
