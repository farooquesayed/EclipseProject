import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReviewAndPay {
	private static WebDriver DRIVER;
	
	public static boolean allReviewAndPay(WebDriver browserDriver) {
		System.out.println("Entering All Review and Pay method");
		DRIVER = browserDriver;
		
		if(!Common.chpt_Exists(DRIVER, "paymentMethodValue")) return false;
		ReviewAndPay FFobj = new ReviewAndPay();
		FFobj.assertPaymentDetails();
		FFobj.clickSubmitPayment();
		FFobj.verifyScreenNavigation();
		
		return true;
	}
	
	public void assertPaymentDetails() {
		org.junit.Assert.assertEquals(DRIVER.findElement(By.id("paymentMethodValue")).getText(), "Credit Card");
		chkpt_innerText("firstFieldValue", "Visa");
		chkpt_innerText("endingValue", "1111");
		chkpt_innerText("expirationDateValue", "02/2014");
		chkpt_innerText("nameOnValue", "Zakir Test");
	}
	
	public void chkpt_innerText(String id, String value) {
		org.junit.Assert.assertEquals(DRIVER.findElement(By.id(id)).getText(), value);
		
	}
	
	public void clickSubmitPayment() {
		DRIVER.findElement(By.id("bSubmitPayment")).click();
	    	
	}
	
	public void verifyScreenNavigation() {
		if(Common.isElementPresent(DRIVER, "confirmationLegend")) 
			System.out.println("Login to policy is successful.");
		else
			System.out.println("FAILED: verifyScreenNavigation");
	}
}
