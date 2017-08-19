package com.test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.functions.CommonFunctions;
import com.functions.Registration;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WearecuriousTest {
	ArrayList<String> credentials;
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	CommonFunctions function = new CommonFunctions();
	Registration register = new Registration();

	@BeforeTest
	public void beforeTest() {
		driver = function.setupBrowser();
		report = new ExtentReports("Reports/result.html");
	}

	@Test(priority=0)
	public void Register() {
		logger = report.startTest("Register");
		driver.get(Constants.URL);
		logger.log(LogStatus.PASS, "Browser started ");
		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, "Application is up and running");
		credentials = register.registerWearecurio(driver);
		logger.log(LogStatus.PASS, "User Registered");

	}
	@Test(priority=1)
	public void Login() { 
		logger = report.startTest("Login");
		driver.get(Constants.URL);
		function.loginWearecurio(credentials.get(0), credentials.get(1));
		logger.log(LogStatus.PASS, "User Logged In");
		driver.switchTo().defaultContent();

	}

	@AfterTest
	public void afterTest() {

		report.endTest(logger);
		report.flush();
		//driver.get("Reports/result.html");
		driver.quit();

	}

}
