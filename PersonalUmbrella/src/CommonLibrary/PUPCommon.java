package CommonLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PUPCommon {
	
	public WebDriver DRIVER;
	
	
//	public PUPCommon() {
//		super();
//	}
//	
	
	public PUPCommon(WebDriver myDriver) {
		DRIVER = myDriver;
	}
	
	public void DoClicki(String objID) {
		DRIVER.findElement(By.id(objID)).click();
	}
	
	public void DoClicki(String objID, boolean isXPATH) {
		DRIVER.findElement(By.xpath(objID)).click();
	}
	
	public void DoSelecti(String objID, int i) {
		new Select(DRIVER.findElement(By.id(objID))).selectByIndex(i);
	}

	public void DoKeyi(String objID, Object val) {
		//DRIVER.findElement(By.id(objID)).clear();
		DRIVER.findElement(By.id(objID)).sendKeys(val.toString());
	}
	public void devLogin(String baseUrl) {

		System.out.println("Login in to Dev site: " + baseUrl);
		DRIVER.get(baseUrl);

	}

	public void DoSelecti(String objID, Object obj) {
		if(obj.toString().isEmpty() == false) 
			new Select(DRIVER.findElement(By.id(objID))).selectByIndex(Integer.parseInt(obj.toString()));
	}

	
}
