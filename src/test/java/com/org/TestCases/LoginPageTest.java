package com.org.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.Pages.DashBoardPage;
import com.org.Pages.LoginPage;
import com.org.TestBase.TestBase;

public class LoginPageTest extends TestBase 
{

	public static LoginPage loginPage;
	public static DashBoardPage dashboard;
	@BeforeMethod
	public void setUp()
	{
		logger.info("Opening the Browser window");
		logger.info("Launching the Url Of the Application");
		Intialisation();
		loginPage=new LoginPage();		
	}
	
	@Test(priority = 1)
	public void testLogo()
	{
		logger.info("Validating the OrangeHRM Logo");
		boolean flag=loginPage.checkLogo();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void testTitle()
	{
		logger.info("Validating the title of the application");
		String title=loginPage.checkTitle();
		
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority = 3)
	public void checkLogin()
	{
		logger.info("log in to the application");
		dashboard=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
