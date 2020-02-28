package com.org.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.org.TestBase.TestBase;

public class SystemUsersPage extends TestBase
{

	@FindBy(css = "a[class='toggle tiptip activated']")
	WebElement systemUsertoggle;
	
	@FindBy(xpath = "//input[@name='chkSelectRow[]' and @value='6']")
	WebElement checkBox;
	
	@FindBy(xpath = "//input[@name='btnAdd']")
	WebElement addButton;
	
	@FindBy(xpath = "//select[@id='systemUser_userType']")
	WebElement userRole;
	
	@FindBy(css = "input[id='systemUser_employeeName_empName']")
	WebElement employeeName;
	
	@FindBy(css = "input[name='systemUser[userName]']")
	WebElement userName;
	
	@FindBy(xpath = "//select[@id='systemUser_status']")
	WebElement status;
	
	@FindBy(xpath = "//input[@id='systemUser_password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement saveButton;
	
	public SystemUsersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddButton()
	{
		addButton.click();
	}
	
	public void enterUserRole(String role)
	{
		Select sel=new Select(userRole);
		sel.selectByValue(role);
	}
	public void enterEmployeename(String EmployeeName)
	{
		
		employeeName.sendKeys(EmployeeName);
	}
	public void enterUname(String uname)
	{
		userName.sendKeys(uname);	
	}
	
	public void enterStatus(String Status)
	{
		Select sel1=new Select(status);
		sel1.selectByValue(Status);
	}
	public void enterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void enterConfirmPassword(String confirmPassword)
	{
		ConfirmPassword.sendKeys(confirmPassword);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
