package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.teck.swaglabs.generic.basetest.BaseClass;

import org.testng.asserts.*;


public class InventoryTest extends BaseClass {


	@Test(retryAnalyzer =com.teck.swaglabs.generic.listenerutility.RetryListenerImp.class)
	public void addProduct() {
	
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,"Swag Labs");
		System.out.println();
		
	}
	@Test
	public void addProductTocart() {
		
	}
	
}
