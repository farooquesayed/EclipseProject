package com.zakir.java;

//import org.testng.annotations.Test;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Class3 {
//	@Before
//	public void beforeTest() {
//		System.setProperty("Dev", "dev-online-pay.com");
//		System.out.println("@BeforeTest Class3");
//		
//	}
//	
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://renters.cnico.com/About";
	    driver.get(baseUrl);
	  }


	@Test
	public void fClass3() {
//		System.out.println("Printing from Class3");
//		driver.findElement(By.linkText("www.cnico.com")).click();
//		//addDelay(8000);
//		
//		System.out.println(driver.getWindowHandle().toString());
//		
//		Set<String> windows = driver.getWindowHandles();
//		
//		String[] array = windows.toArray(new String[0]);
//    	System.out.println(windows);
//    	System.out.println(Arrays.toString(array));
//    	
//		
//		
//		driver.switchTo().window("http://www.cnico.com/");
//		driver.findElement(By.id("PAYOnlineButton")).click();
//		
		//System.out.println(a);
	}
	
	
	
	public static void addDelay(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
