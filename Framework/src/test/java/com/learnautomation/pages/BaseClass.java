package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.externalconfig.model.Config;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up report and Test started", true);

		excel = new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FB.html"+Helper.getCurrentDateTime()+".html"));
	    report= new ExtentReports();
	    report.attachReporter(extent);
	    Reporter.log("Settings done Test can be started", true);

	}
    @Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url) {
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		driver=BrowserFactory.startApplication(driver, browser, url);
		System.out.println(driver.getTitle());
		Reporter.log("Browser started running", true);

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Reporter.log("Test is about to load", true);

			//Helper.captureScreenshot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Reports Generated", true);

	}

}
