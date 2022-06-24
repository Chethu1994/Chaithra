package com.crm.comcast.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplementClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(com.aventstack.extentreports.Status.PASS, result.getMethod().getMethodName());
		test.log(com.aventstack.extentreports.Status.PASS, result.getThrowable());	
		}
	/**
	 * To take screenshot of failed test scripts
	 */

	public void onTestFailure(ITestResult result) {
		test.log(com.aventstack.extentreports.Status.FAIL, result.getMethod().getMethodName());
		test.log(com.aventstack.extentreports.Status.FAIL, result.getThrowable());
		
		 try {
		    	String screenShotName=WebdriverUtility.takeScreenShot(BaseClass.SDriver, result.getMethod().getMethodName());
		    	test.addScreenCaptureFromPath(screenShotName);
		    	} catch (Throwable e) {
		    	e.printStackTrace();
		
//String testName = result.getMethod().getMethodName();
//System.out.println(testName+ "======= execute and i am Listening=====");

//EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.SDriver);
//File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
//try {
	//FileUtils.copyFile(srcFile, new File("./Screenshot/"+testName+".png"));
//}catch (IOException e) {
	//e.printStackTrace();
}
		}

	public void onTestSkipped(ITestResult result) {
		test.log(com.aventstack.extentreports.Status.SKIP, result.getMethod().getMethodName());
		test.log(com.aventstack.extentreports.Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/report.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("Chethan's document");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Chethan Kumar Nairy");
		report.setSystemInfo("ReviwedBy", "SanjayBabu");
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("ServerName","ApacheTomcat");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();		
	}

}
