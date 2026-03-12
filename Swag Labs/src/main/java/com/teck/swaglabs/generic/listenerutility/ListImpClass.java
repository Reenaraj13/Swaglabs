package com.teck.swaglabs.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.teck.swaglabs.generic.basetest.BaseClass;
import com.teck.swaglabs.generic.webdriverutility.UtilityClassObjects;
public class ListImpClass implements ITestListener,ISuiteListener {

	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		
		System.out.println("Report Configuration");
//		Report configuration
		String time = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Swag labs Test Suite Result");
		spark.config().setReportName("Swag lab");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
//		add Environment info
		report.attachReporter(spark);
		report.setSystemInfo("OS Name","Microsoft Windows 11");
		report.setSystemInfo("Browser","Chrome-OS 145.0.7632.68 ");
		
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		
		System.out.println("====="+result.getMethod().getMethodName()+">===START====<");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObjects.setTest(test);
		 UtilityClassObjects.getTest().log(Status.INFO, result.getMethod().getMethodName()+"======>STARTED<====");
		 
	}
	
	public void onTestSuccess(ITestResult result) {
	
		System.out.println("====="+result.getMethod().getMethodName()+">===End====<");
		 UtilityClassObjects.getTest().log(Status.PASS, result.getMethod().getMethodName()+"===>COMPLETED<===");
		
	}
	public void onTestFailure(ITestResult result) {
		
		String tsname=result.getMethod().getMethodName();
		
	
		TakesScreenshot ts =(TakesScreenshot)(BaseClass.sdriver);
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		
		 UtilityClassObjects.getTest().addScreenCaptureFromBase64String(filepath,tsname );
		
		 UtilityClassObjects.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"===>FAILED<===");
	}
	public void onTestSkipped(ITestResult result) {
		
	}
}
