package com.org.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.TestBase.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(xpath = "//div[@id='divLogo']/img")
	WebElement orangeLogo;
	
	@FindBy(name ="txtUsername")
	WebElement username;
	
	@FindBy(id ="txtPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement LoginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static String checkTitle()
	{
		return driver.getTitle();
	}
	
	public  boolean checkLogo()
	{
		return orangeLogo.isDisplayed();
	}
	
	public DashBoardPage Login(String un,String pw)
	{
		username.sendKeys(un);
		
		password.sendKeys(pw);
		
		LoginButton.click();
		
		return new DashBoardPage();
		
	}

}
