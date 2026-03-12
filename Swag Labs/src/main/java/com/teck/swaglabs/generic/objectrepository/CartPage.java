package com.teck.swaglabs.generic.objectrepository ;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teck.swaglabs.generic.webdriverutility.WebDriverUtility;

import net.bytebuddy.asm.Advice.This;

public class CartPage extends WebDriverUtility {

	WebDriver driver;
	
	@FindBy(xpath ="//div[text()='Sauce Labs Backpack']")
	private WebElement itemInfo;
	
	@FindBy(xpath="//button[.='Remove']")
	private WebElement removeBtn;
	
	@FindBy(id="checkout")
	private WebElement checkoutbtn;
	
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getItemInfo() {
		
		return itemInfo;
	}
	public WebElement getRemoveBtn() {
		
		return removeBtn;
	}
	public WebElement getcheckoutbtn() {
		
		return checkoutbtn;
	}
	public WebElement getlogout() {
		
		return logout;
	}

	public String getItemName() {
		
		return itemInfo.getText();
	}
	
	public void navigateToCheckOut() {
		
		mouseMoveOnElement(driver, checkoutbtn);
		checkoutbtn.click();
	}

	public void navigateToMenu() {
		
		menu.click();
		logout.click();
		
	}

}
