package com.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerate {

	public static ExtentReports getExtentReport() {

		ExtentReports report = new ExtentReports();
		File extentReportfile = new File(System.getProperty("user.dir") + "\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportfile);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("SD Test Report");
		sparkReport.config().setDocumentTitle("SD Report");
		sparkReport.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		report.attachReporter(sparkReport);
		return report;
	}
}
