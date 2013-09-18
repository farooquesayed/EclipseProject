package org.zakir;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PolicySearch {
	
	private static WebDriver DRIVER;
	
	public static void allPolicySearch(WebDriver browserDriver) {
		System.out.println("Entering All Policy Search method");
		DRIVER = browserDriver;
		PolicySearch FFobj = new PolicySearch();
		FFobj.enterPolicyDetails("FCA0349165", "92557");
		FFobj.clickContinue();	
		FFobj.verifyScreenNavigation();
	}
	
	public void enterPolicyDetails(String PolicyNumber, String zipCode) {
		DRIVER.findElement(By.id("tPolicyNumber")).sendKeys(PolicyNumber);
		DRIVER.findElement(By.id("tZipCode")).sendKeys(zipCode);

	}
	
	public void clickContinue() {
		DRIVER.findElement(By.id("bContinue")).click();
	    DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void verifyScreenNavigation() {
		assertTrue(DRIVER.findElement(By.id("paymentMethod")).isDisplayed());
		if(DRIVER.findElement(By.id("paymentMethod")).isDisplayed()) {
			System.out.println("Login to policy is successful.");
		}
	}
	
}
