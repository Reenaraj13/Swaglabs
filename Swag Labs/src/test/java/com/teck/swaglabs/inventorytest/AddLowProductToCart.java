package com.teck.swaglabs.inventorytest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.teck.swaglabs.generic.basetest.BaseClass;
import com.teck.swaglabs.generic.objectrepository.CartPage;
import com.teck.swaglabs.generic.objectrepository.InventoryItemPage;
import com.teck.swaglabs.generic.objectrepository.InventoryPage;

public class AddLowProductToCart extends BaseClass{

	
	@Test
	public void clickonProduct() throws  IOException {
		
		String Productname=eUtil.getDataFromExcel("Products", 1, 2);
		
		InventoryPage ip=new InventoryPage(driver);
		String ProductName=ip.addProductToCart(driver, Productname);
		
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.addAndNavigateToCart();
		
		CartPage cp=new CartPage(driver);
		String Productincart=cp.getItemName();
		cp.navigateToMenu();
		
		
		
		
		
		
		
	}
	
}
