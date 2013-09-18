package org.zakir;
import java.util.concurrent.TimeUnit;

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
			DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
