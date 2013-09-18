
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {

	public void devLogin(WebDriver DRIVER, String baseUrl) {
		try {
			System.out.println("Login in to Dev site: " + baseUrl);
			DRIVER.get(baseUrl);

			DRIVER.findElement(By.id("UserName")).sendKeys("CniUser");
			DRIVER.findElement(By.id("Password")).sendKeys("WaterFall12");
			DRIVER.findElement(By.id("submit")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addDelay(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean chpt_Exists(WebDriver DRIVER, String byID) {
		try {
			DRIVER.findElement(By.id(byID));
			System.out.println("Item Exists: " + byID);
			return true;
		} catch (Exception e) {
			System.out.println(byID + " ITEM DOESN'T EXISTS. DESCRIPTION = " + e.toString());
			return false;
		}
	}
	
	public static boolean isElementPresent(WebDriver DRIVER, String by) {
		try {
			DRIVER.findElement(By.id(by));
			return true;
		} catch (Exception e) {
			System.out.println("Exception caught. DESCRIPTION = " + e.toString());
			return false;
		}
	}
}
