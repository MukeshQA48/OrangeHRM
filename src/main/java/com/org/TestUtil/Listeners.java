package com.org.TestUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners extends TestListenerAdapter
{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;
	
	public void onStart(ITestContext ctx)
	{
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		
		String reportName="Test_Report_"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test_Output/"+reportName);
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extentReports=new ExtentReports();
		
		extentReports.attachReporter(htmlReporter);
		
		extentReports.setSystemInfo("Host Name", "Mukhesh Kummithi");

		extentReports.setSystemInfo("Environment", "QA");
		
		extentReports.setSystemInfo("user", "Mukhesh Kummithi");
		
		htmlReporter.config().setDocumentTitle("OrangeHRM_Report");
		
		htmlReporter.config().setReportName("Functional Test Report");
		
		htmlReporter.config().setTheme(Theme.DARK);
			
	}
	
	public void onTestSuccess(ITestResult Itr)
	{
		logger=extentReports.createTest(Itr.getName());
		
		logger.log(Status.PASS, MarkupHelper.createLabel(Itr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult Itr)
	{
		logger=extentReports.createTest(Itr.getName());
		
		logger.log(Status.FAIL, MarkupHelper.createLabel(Itr.getName(), ExtentColor.RED));
		
		String screenShotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+Itr.getName()+".png";
		
		File file=new File(screenShotPath);
		
		if(file.exists())
		{
			try {
				logger.fail("Screen Shot is below:"+logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult itr)
	{
		logger=extentReports.createTest(itr.getName());
		
		logger.log(Status.SKIP, MarkupHelper.createLabel(itr.getName(), ExtentColor.BLUE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extentReports.flush();
	}
	
	
	
	
	
}
