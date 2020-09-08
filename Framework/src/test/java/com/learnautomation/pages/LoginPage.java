package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{

		this.driver=ldriver;


	}
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement username;
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='pass']") WebElement password;
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement loginButton;





	public void loginToFB(String uname,String pwd)
	{   
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		username.sendKeys(uname);	
		password.sendKeys(pwd);
		loginButton.click();
	}


}
