package Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.ExtentReportGenerate;
import com.utilities.UtilitiesSD;

public class SDListener extends UtilitiesSD implements ITestListener {

	ExtentReports report = ExtentReportGenerate.getExtentReport();
	ExtentTest eTest;
	public static WebDriver driver;

	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		eTest = report.createTest(testName);
		eTest.log(Status.INFO, "Start the Execution of: " + testName + " here");
	}

	public void onTestSuccess(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		String testName = result.getName();
		eTest.log(Status.PASS, "Successfuly Executed: " + testName);
		eTest.addScreenCaptureFromPath(takesScreenshot(testName, driver), testName);


	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		String testName = result.getName();
		eTest.log(Status.FAIL, "Failed Executed: " + testName);
		eTest.addScreenCaptureFromPath(takesScreenshot(testName, driver), testName);
		eTest.log(Status.INFO, result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();
		eTest.log(Status.SKIP, "Skipped Executed: " + testName);
		eTest.log(Status.INFO, result.getThrowable());

	}

	public void onFinish(ITestContext context) {

		report.flush();
		try {
			Desktop.getDesktop()
					.browse(new File(System.getProperty("user.dir") + "\\ExtentReports\\ExtentReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
