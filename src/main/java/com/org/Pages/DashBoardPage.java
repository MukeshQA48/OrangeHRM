package com.org.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.TestBase.TestBase;

public class DashBoardPage extends TestBase
{

	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashboardLogo;
	
	@FindBy(xpath="//img[@src='/webres_5df488ddad8b23.30204013/orangehrmLeavePlugin/images/ApplyLeave.png']")
	WebElement assignLeavelogo;
	
	@FindBy(xpath = "//img[@src='/webres_5df488ddad8b23.30204013/orangehrmLeavePlugin/images/MyLeave.png']")
	WebElement leaveListLogo;
	
	@FindBy(linkText = "Admin")
	WebElement adminLink;
	
	@FindBy(css = "#menu_admin_UserManagement")
	WebElement userManagementtab;
	
	@FindBy(css = "a[id='menu_admin_viewSystemUsers']")
	WebElement usersTab;
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkleaveListLogo()
	{
		boolean check=leaveListLogo.isDisplayed();
		
		return check;
	}
	
	public boolean checkDashboardLogo()
	{
		boolean check1=dashboardLogo.isDisplayed();
		
		return check1;
	}
	
	public boolean checkAssignleaveLogo()
	{
		boolean check2=assignLeavelogo.isDisplayed();
		
		return check2;
	}
	
	public SystemUsersPage clickUsersTab()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminLink).build().perform();
		act.moveToElement(userManagementtab).build().perform();
		usersTab.click();
		
		return new SystemUsersPage();
		
	}
	
	
	
	
	
	
}
