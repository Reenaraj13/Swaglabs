package com.teck.swaglabs.generic.basetest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.teck.swaglabs.generic.fileutility.ExcelUtility;
import com.teck.swaglabs.generic.fileutility.FileUtility;
import com.teck.swaglabs.generic.objectrepository.InventoryPage;
import com.teck.swaglabs.generic.objectrepository.LoginPage;
import com.teck.swaglabs.generic.webdriverutility.UtilityClassObjects;
import com.teck.swaglabs.generic.webdriverutility.WebDriverUtility;


@Listeners(com.teck.swaglabs.generic.listenerutility.ListImpClass.class)
public class BaseClass  {
	
	/**
	 * This class consists of all basic Configuration annotations
	 * of TestNG
	 * @author  
	 *
	 */
	public FileUtility fUtil= new FileUtility();
	public ExcelUtility eUtil= new ExcelUtility();
	public WebDriverUtility sUtil= new WebDriverUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	
	
	
//	public WebElement element;
//	for Listeners
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void bsConfig(){
		

		System.out.println("_----------Database Connection Successful-----");
	}
	
//	@BeforeTest
	@BeforeClass(groups={"smokeTest","regressionTest"})
//	@Parameters("browser")
	public void bcConfig(/*String browser*/ ) throws IOException{
	    String Browser; //= browser;
	    		Browser=System.getProperty("browser",fUtil.getDataFromPropertiesFile("browser"));
	    if (Browser.equalsIgnoreCase("chrome")) {

	        ChromeOptions options = new ChromeOptions();

	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("profile.password_manager_leak_detection", false);  

	        options.setExperimentalOption("prefs", prefs);

	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-save-password-bubble");
	        options.addArguments("--disable-infobars");

	        driver = new ChromeDriver(options);
	        
	    } else if(Browser.equalsIgnoreCase("firefox")) {

	        driver = new FirefoxDriver();

	    } else if(Browser.equalsIgnoreCase("edge")) {

	        driver = new EdgeDriver();

	    } else {

	        driver = new ChromeDriver();
	    }  
	    sdriver=driver;
	    UtilityClassObjects.setDriver(driver);
    }
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void bmConfig() throws IOException {
	
	
//		reading data from cmd incase we are not doing from cmd it will  reading data from propertifile
		String url=System.getProperty("url",fUtil.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",fUtil.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",fUtil.getDataFromPropertiesFile("password"));  
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(url,USERNAME, PASSWORD);
		System.out.println("_---------Login to App Successful-----");
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void amConfig() {
		InventoryPage ip= new InventoryPage(driver);
		System.out.println("---- Logout of App Successful ----");	
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void acConfig() {
		driver.quit();
		System.out.println("---- Browser closure Successful ----");	
	}
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void asConfig()
	{
		System.out.println("---- Database closure Successful ----");	
	}
}
