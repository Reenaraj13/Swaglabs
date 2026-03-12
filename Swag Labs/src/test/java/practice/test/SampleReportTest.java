package practice.test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	public ExtentReports report;
	
	
	@BeforeSuite
	public void beforeCof() {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("Swag labs Test Suite Result");
		spark.config().setReportName("Swag lab");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS Name","Microsoft Windows 11");
		report.setSystemInfo("Browser","Chrome-OS 145.0.7632.68 ");
	}
	@AfterSuite
	public void afterCof() {
		report.flush();
	}
	
	@Test
	public void createTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		TakesScreenshot ts= (TakesScreenshot)driver; 
		String filepath=ts.getScreenshotAs(OutputType.BASE64);  
		
		
		ExtentTest test=report.createTest("createTest");
		test.log(Status.INFO,"-Login to app-----");
		
		
		
		test.log(Status.INFO,"_----------Navigate to contact page-----");
		test.log(Status.INFO,"_----------create contact-----");
		if("HDFC".equals("HgDFC")) {
			
			test.log(Status.PASS,"--Contact created");
		}else {
			
			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
		driver.close();
		System.out.println("_----------Login to app-----");
		
	}
}
