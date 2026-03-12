package com.teck.swaglabs.generic.objectrepository ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.teck.swaglabs.generic.webdriverutility.WebDriverUtility;

public class InventoryItemPage extends WebDriverUtility {

	WebDriver driver;
	@FindBy(id="add-to-cart")
	private WebElement addtocartbtn;
	
	@FindBy(id =  "Remove")
	private WebElement remove;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;

	
	//	Rule 3:Initialization
	
	public InventoryItemPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getaddtocartbtn(){
		
		return addtocartbtn;
	}
	public WebElement getremove() {
		
		return remove;
	}

	
	
	public WebElement getCartContainerBtn() {
		
		return cartContainerBtn;
	}
	public void addAndNavigateToCart() {
		addtocartbtn.click();
		mouseMoveOnElement(driver, cartContainerBtn);
		cartContainerBtn.click();
	}

	
}
	
