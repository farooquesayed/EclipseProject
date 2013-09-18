package org.zakir;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Confirmation extends Common{
	private static WebDriver DRIVER;
	
	public static void allConfirmation(WebDriver browserDriver) {
		System.out.println("Entering Confirmation page method");
		DRIVER = browserDriver;
		
		Confirmation FFobj = new Confirmation();
		FFobj.logConfirmationNumbers();
		FFobj.emailAddress();
		FFobj.verifyScreenNavigation();
	}
	
	public void logConfirmationNumbers() {
		System.out.println("Confirmation Number - " + getObj("confirmationNumberValue").getText());
		System.out.println("Policy Number - " + getObj("policyNumberValue").getText());

	}
	
	public void emailAddress() {
		getObj("tEmail").sendKeys("zakirsayed@cnico.com");
		getObj("bEmailReceipt").click();
		addDelay(3000);
	//	DRIVER.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	public WebElement getObj(String id) {
		return DRIVER.findElement(By.id(id));
	}
	
	public void PrinterFriendlyReceipt() {
		
	}
	
	public void verifyScreenNavigation() {
		if(DRIVER.findElement(By.id("bPrinterFriendlyReceipt")).isDisplayed()) {
			System.out.println("Payment Method test is successful.");
		}
		assertTrue(DRIVER.findElement(By.id("bPrinterFriendlyReceipt")).isDisplayed());
	}
	

}
