package com.teck.swaglabs.inventorytest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.teck.swaglabs.generic.basetest.BaseClass;
import com.teck.swaglabs.generic.objectrepository.CartPage;
import com.teck.swaglabs.generic.objectrepository.InventoryItemPage;
import com.teck.swaglabs.generic.objectrepository.InventoryPage;
import com.teck.swaglabs.generic.webdriverutility.UtilityClassObjects;

import org.testng.Assert;
import org.testng.Reporter;


public class AddProductToCart extends BaseClass{

	
	@Test(groups="smokeTest")
	public void clickonProduct() throws  IOException {


		UtilityClassObjects.getTest().log(Status.INFO,"Read data from excel");
		String Productname=eUtil.getDataFromExcel("Products", 1, 2);
		
		UtilityClassObjects.getTest().log(Status.INFO,"Navigate to productpage");
		InventoryPage ip=new InventoryPage(driver);
		
		UtilityClassObjects.getTest().log(Status.INFO,"Add product to page");
		String ProductName=ip.addProductToCart(driver, Productname);
		
		Reporter.log(ProductName);
		
		UtilityClassObjects.getTest().log(Status.INFO,"Navigate to productitempage");
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.addAndNavigateToCart();
		
		UtilityClassObjects.getTest().log(Status.INFO,"Navigate to CartPage");
		CartPage cp=new CartPage(driver);
		String Productincart=cp.getItemName();
		Reporter.log(Productincart,true);
		Assert.assertEquals(ProductName,Productincart);
		cp.navigateToMenu();
		
		
		
		
		
		
	}
	
}
