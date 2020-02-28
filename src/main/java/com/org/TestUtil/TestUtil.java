package com.org.TestUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtil 
{
	public static int PAGE_LOAD_TIMEOUT=10;
	
	public static int IMPLICIT_TIMEOUT=20;
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screen Shot taken");
	}
	
}
