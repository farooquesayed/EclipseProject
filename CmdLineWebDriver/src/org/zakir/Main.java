package org.zakir;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main extends Common {
	public WebDriver DRIVER; 
	public String baseUrl = "https://qa-pay.cnico.com";
	
	public void setUp() {
		System.out.println("TEST STARTED FOR ONLINE BILL PAY.");
	}

	
	public void runOnlineBillPay(String baseUrl) {
		devLogin(DRIVER, baseUrl);
		PolicySearch.allPolicySearch(DRIVER);
		PaymentInfo.AllPaymentInformation(DRIVER);
		ReviewAndPay.allReviewAndPay(DRIVER);
		Confirmation.allConfirmation(DRIVER);
	}

	public void tearDown() {
	    DRIVER.quit();
	}

	
	public void setBrowserdriver(String browserDriver) {
		switch(browserDriver) {
		case "IE": {
			DRIVER = new InternetExplorerDriver();
		    break;
		}
		case "FF": {
			DRIVER = new FirefoxDriver();
		    break;
		}
		case "CR": {
			DRIVER = new ChromeDriver();
		    break;
		}
		default: break;
		}
	}

	
}
