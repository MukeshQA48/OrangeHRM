package com.org.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.org.TestUtil.TestUtil;

public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;
	public static Logger logger;
	
public TestBase()
{
	try {
		FileInputStream fis=new FileInputStream("D:\\Orange HRM\\OrangeHRM\\src\\main\\java\\com\\org\\Config\\Config.properties");
		
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void Intialisation()
{
	logger=Logger.getLogger("OrangeHRM");
	PropertyConfigurator.configure("log4j.properties");
	if(prop.getProperty("browser").equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Orange HRM\\OrangeHRM\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	
	else if(prop.getProperty("browser").equals("firefox"))
	{
		System.setProperty("webdriver.geckodriver.driver","D:\\Orange HRM\\OrangeHRM\\Drivers\\geckodriver.exe");
		
		driver=new FirefoxDriver();
	}
	
	else if(prop.getProperty("browser").equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", "D:\\Orange HRM\\OrangeHRM\\Drivers\\IEDriverServer.exe");
		
		driver=new InternetExplorerDriver();
	}
	driver.manage().window().maximize();
	
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}

}
