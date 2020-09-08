package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestFB extends BaseClass {
    
	
		
	@Test
	public void loginApp()
	{
		
		logger=report.createTest("Login to FB");
		
		
		LoginPage loginpageinstance=PageFactory.initElements(driver, LoginPage.class);
		//loginpageinstance.loginToFB("thalaarun2018@gmail.com", "Ultimatearun1985");//Abstraction- showing the essential features and hiding the background details 
		logger.info("Starting Application");
		loginpageinstance.loginToFB(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login succesfully");
		Helper.captureScreenshot(driver);
		System.out.println(driver.getTitle());		
	}
	
	
}
