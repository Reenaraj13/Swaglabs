package com.teck.swaglabs.generic.objectrepository ;




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teck.swaglabs.generic.webdriverutility.WebDriverUtility;



public class InventoryPage extends WebDriverUtility  	  {

	WebDriver driver;

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement productbackpack;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement CartContainerBtn;
	
	@FindBy(xpath = "//option[text()='Price (low to high)']/.")
	private WebElement rangelowtohigh;
	
	@FindBy(xpath ="//select[@data-test='product-sort-container']")
	private WebElement productSortContainer;
	

	//	Rule 3:Initialization
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCartContainerBtn(){
		
		return CartContainerBtn;
	}
	
	public WebElement getproductSortContainer() {
		
		return productSortContainer;
	}
	public String addProductToCart(WebDriver driver,String Productname){

		WebElement prod=driver.findElement(By.xpath("//div[.='"+Productname+"']"));
		String ProductDetails=prod.getText();
		prod.click();
		return ProductDetails;
		
	}

	public void navigateToProductSortContainer() {
		productSortContainer.click();
		select(productSortContainer,1);
	}
	

}
