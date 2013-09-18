package org.zakir;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class PaymentInfo extends Common{

	private static WebDriver DRIVER;
	
	public static void AllPaymentInformation(WebDriver browserDriver) {
		System.out.println("Entering All Payment Method method");
		DRIVER = browserDriver;
		
		PaymentInfo FFobj = new PaymentInfo();
		FFobj.validateScreen2E();
		FFobj.PaymentAmount();
		FFobj.PaymentMethod();
		FFobj.clickContinue();
		FFobj.verifyScreenNavigation();
	}
	
	public void validateScreen2E() {
		if(DRIVER.findElement(By.id("totalAmountDueRadio")).isSelected()) {
			System.out.println("Unexpected radio button is selected");
			Logger.getLogger("Unexpected radio button is selected");
		}
	}
	
	public String getTotalBalanceDue() {
		String tBalance;
		double output;
		tBalance = DRIVER.findElement(By.id("TotalAmountSpan")).getText();
		tBalance = tBalance.substring(tBalance.indexOf("$") + 1);
		output = Double.parseDouble(tBalance) * (Math.random() + 1);
		System.out.println("Amount entered = " + output);
		return Double.toString(output);
	}
	
	public void PaymentAmount() {
		DRIVER.findElement(By.id("totalAmountDueRadio")).click();
		DRIVER.findElement(By.id("paymentAmount")).sendKeys(getTotalBalanceDue());
		
	}
	
	public void PaymentMethod() {
		new Select(DRIVER.findElement(By.id("paymentMethod"))).selectByVisibleText("Credit Card");
	    new Select(DRIVER.findElement(By.id("creditCardType"))).selectByIndex(1);
	    CC_visa();
	}
	
	public void CC_visa() {
		DRIVER.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
		DRIVER.findElement(By.id("creditCardSecurityCode")).sendKeys("100");
		new Select(DRIVER.findElement(By.id("creditCardExpMonth"))).selectByVisibleText("02");
	    new Select(DRIVER.findElement(By.id("creditCardExpYear"))).selectByIndex(2);
	    DRIVER.findElement(By.id("creditCardNameOn")).sendKeys("Zakir Test");
	    DRIVER.findElement(By.id("creditCardbillingAddress1")).sendKeys("1234 ABC st");
		DRIVER.findElement(By.id("creditCardzipCode")).sendKeys("91205");
		addDelay(5000);
		new Select(DRIVER.findElement(By.id("creditCardcity"))).selectByIndex(0);
	}
	
	public void clickContinue() {
		DRIVER.findElement(By.id("continueButton")).click();
	    DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}

	
	public void verifyScreenNavigation() {
		if(DRIVER.findElement(By.id("bSubmitPayment")).isDisplayed()) {
			System.out.println("Payment Method test is successful.");
		}
		assertTrue(DRIVER.findElement(By.id("bSubmitPayment")).isDisplayed());
	}
}
