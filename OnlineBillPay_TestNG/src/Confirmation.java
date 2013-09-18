

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Confirmation {
	private static WebDriver DRIVER;
	
	public static boolean allConfirmation(WebDriver browserDriver) {
		System.out.println("Entering Confirmation page method");
		DRIVER = browserDriver;
		
		if(!Common.chpt_Exists(DRIVER, "policyNumberValue")) return false;
		Confirmation FFobj = new Confirmation();
		FFobj.logConfirmationNumbers();
		FFobj.emailAddress();
		FFobj.verifyScreenNavigation();
		return true;
	}
	
	public void logConfirmationNumbers() {
		System.out.println("Confirmation Number - " + getObj("confirmationNumberValue").getText());
		System.out.println("Policy Number - " + getObj("policyNumberValue").getText());

	}
	
	public void emailAddress() {
		getObj("tEmail").sendKeys("zakirsayed@cnico.com");
		getObj("bEmailReceipt").click();
		addDelay(3000);
		
	}
	
	public WebElement getObj(String id) {
		return DRIVER.findElement(By.id(id));
	}
	
	public void PrinterFriendlyReceipt() {
		
	}
	
	public void verifyScreenNavigation() {
		if(Common.isElementPresent(DRIVER, "bPrinterFriendlyReceipt")) 
			System.out.println("Login to policy is successful.");
		else
			System.out.println("FAILED: verifyScreenNavigation");
	}
	
	public void addDelay(int mSec) {
		try {
			Thread.sleep(mSec);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
