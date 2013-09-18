import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PolicySearch {
	
	private static WebDriver DRIVER;
	
	public static boolean allPolicySearch(WebDriver browserDriver) {
		System.out.println("Entering All Policy Search method");
		DRIVER = browserDriver;
		if(!Common.chpt_Exists(DRIVER, "tPolicyNumber")) return false;
		PolicySearch FFobj = new PolicySearch();
		FFobj.enterPolicyDetails("FC11000838", "92243");
		FFobj.clickContinue();	
		FFobj.verifyScreenNavigation();
		return true;
	}
	
	public static void allPolicySearch(WebDriver browserDriver, String Pnum, Object Pzip) {
		System.out.println("Entering All Policy Search method");
		DRIVER = browserDriver;
		PolicySearch FFobj = new PolicySearch();
		FFobj.enterPolicyDetails(Pnum, Pzip.toString());
		FFobj.clickContinue();	
		FFobj.verifyScreenNavigation();
	}
	
	public void enterPolicyDetails(String PolicyNumber, String zipCode) {
		DRIVER.findElement(By.id("tPolicyNumber")).sendKeys(PolicyNumber);
		DRIVER.findElement(By.id("tZipCode")).sendKeys(zipCode);

	}
	
	public void clickContinue() {
		DRIVER.findElement(By.id("bContinue")).click();
	    
	}
	
	public void verifyScreenNavigation() {
		if(Common.isElementPresent(DRIVER, "paymentMethod")) 
			System.out.println("Login to policy is successful.");
		else
			System.out.println("FAILED: verifyScreenNavigation");
	}
	
}
