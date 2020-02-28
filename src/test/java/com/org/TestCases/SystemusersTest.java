package com.org.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.Pages.DashBoardPage;
import com.org.Pages.LoginPage;
import com.org.Pages.SystemUsersPage;
import com.org.TestBase.TestBase;
import com.org.TestUtil.XLUtils;

public class SystemusersTest extends TestBase
{
  public static LoginPage loginPage;
  public static DashBoardPage dashBoardPage;
  public static SystemUsersPage systemUsersPage;
  
  
  
  @BeforeMethod
  public void setUp()
  {
	  Intialisation();
	  loginPage=new LoginPage();
	  logger.info("Login to the Orange HRM application");
	  loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	  dashBoardPage=new DashBoardPage();
	  logger.info("Enter to users page by clicking Users Tab");
	  dashBoardPage.clickUsersTab();
  }
  
  @Test(dataProvider = "usersData")
  public void enterDetails(String role, String EmployeeName, String uname,String Status, String Password, String confirmPassword)
  {
	  systemUsersPage=new SystemUsersPage();
	  logger.info("clicking add button to enter details");
	  systemUsersPage.clickAddButton();
	  systemUsersPage.enterUserRole(role);
	  systemUsersPage.enterEmployeename(EmployeeName);
	  systemUsersPage.enterUname(uname);
	  systemUsersPage.enterPassword(Password);
	  systemUsersPage.enterConfirmPassword(confirmPassword);
	  systemUsersPage.enterStatus(Status);
	  logger.info("Saving the Details....");
	  systemUsersPage.clickSaveButton();
  }
  
  @DataProvider(name = "usersData")
  String[][] getData() throws IOException
  {
	  String path="D:\\Orange HRM\\OrangeHRM\\TestData\\SystemUsers.xlsx";
	  int rowNum=XLUtils.getRowCount(path, "Sheet1");
	  int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
	  String userData[][]=new String[rowNum][colCount];
	  for(int i=1;i<=rowNum;i++)
	  {
		  for(int j=0;j<colCount;j++)
		  {
			  userData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		  }
	  }
	return userData;
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
	
}
