package com.teck.swaglabs.generic.otputility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OTPUtility {
	  public static void handleOTP(WebDriver driver, String otpValue) {
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for OTP textbox
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp")));

	        // Enter OTP
	        driver.findElement(By.id("otp")).sendKeys(otpValue);

	        // Click verify button
	        driver.findElement(By.id("verifyBtn")).click();
	    }
}
