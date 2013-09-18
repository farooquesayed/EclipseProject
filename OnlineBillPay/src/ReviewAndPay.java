import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReviewAndPay {
	private static WebDriver DRIVER;
	
	public static void allReviewAndPay(WebDriver browserDriver) {
		System.out.println("Entering All Review and Pay method");
		DRIVER = browserDriver;
		
		ReviewAndPay FFobj = new ReviewAndPay();
		FFobj.assertPaymentDetails();
		FFobj.clickSubmitPayment();
		FFobj.verifyScreenNavigation();
		
		
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
	    DRIVER.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
	}
	
	public void verifyScreenNavigation() {
		if(DRIVER.findElement(By.id("confirmationLegend")).isDisplayed()) {
			System.out.println("Payment Method test is successful.");
		}
		assertTrue(DRIVER.findElement(By.id("confirmationLegend")).isDisplayed());
	}
}
