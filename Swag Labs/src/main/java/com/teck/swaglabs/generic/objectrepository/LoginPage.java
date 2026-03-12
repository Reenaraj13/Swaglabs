package com.teck.swaglabs.generic.objectrepository ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teck.swaglabs.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	
//	Rule 3:Initialization
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	Rule 4:Utilization
	public WebElement getusernameEdt(){
		
		return usernameEdt;
	}
	
	public WebElement getpasswordEdt(){
		
		return passwordEdt;
	}
	public WebElement getloginBtn(){
		
		return loginBtn;
	}
	
//	Rule 5: Business Library
	
	public void loginToApp(String url,String USERNAME,String PASSWORD) {
		driver.get(url);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
