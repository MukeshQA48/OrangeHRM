package com.org.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.Pages.DashBoardPage;
import com.org.Pages.LoginPage;
import com.org.TestBase.TestBase;

public class DashBoardPageTest extends TestBase
{
	public static LoginPage loginPage;
	public static DashBoardPage dashBoardPage;

	@BeforeMethod
	public void setUp()
	{
		Intialisation();
		loginPage=new LoginPage();
		logger.info("Log in to the OrangeHRM Application.....");
		loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage=new DashBoardPage();
		
		
	}
	
	@Test(priority = 1)
	public void logoTest()
	{
		logger.info("Validating the OrangeHRM Logo");
		boolean testLogo=dashBoardPage.checkDashboardLogo();
		
		Assert.assertTrue(testLogo);
	}
	
	@Test(priority = 2)
	public void logoTest1()
	{
		logger.info("Validating the Assign Leave logo");
		boolean testLogo=dashBoardPage.checkAssignleaveLogo();
		
		Assert.assertTrue(testLogo);
	}
	
	@Test(priority = 3)
	public void logoTest2()
	{
		logger.info("Validating the checkLeave Logo");
		boolean testLogo=dashBoardPage.checkleaveListLogo();
		
		Assert.assertTrue(testLogo);
	}
	
	@Test(priority = 4)
	public void clickUsersTab()
	{
		logger.info("clicking the users tab");
		dashBoardPage.clickUsersTab();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
