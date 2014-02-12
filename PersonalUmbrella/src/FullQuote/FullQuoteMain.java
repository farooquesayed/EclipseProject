package FullQuote;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import CommonLibrary.CommonFunctions;


public class FullQuoteMain implements Runnable {

	public WebDriver DRIVER;
	public String Btype;  //Browser Type
	
	public FullQuoteMain(String type) {
		this.Btype = type;
	}
	
//	public static void DriveFullQuote() {
//		Thread t1 = new Thread(new FullQuoteMain("FF"));
//		t1.start();
//
//		Thread t2 = new Thread(new FullQuoteMain("CR"));
//		t2.start();
//	}
	
	
	@Override
	public void run() {
		try
		{
			setBrowserdriver(this.Btype);
			Fq1 tc1 = new Fq1(DRIVER);
			tc1.StartFullQuote();
	
			System.out.println("FULLQUOTE: Waiting for test case1 to execute.");
			Thread.sleep(3000);
			Fq2 tc2 = new Fq2(DRIVER);
			tc2.AgencySelection();
	
			System.out.println("FULLQUOTE: Waiting for test case2 to execute.");
			Thread.sleep(3000);
			Fq3 tc3 = new Fq3(DRIVER);
			tc3.Customer_Information();
	
			System.out.println("FULLQUOTE: Waiting for test case3 to execute.");
			Thread.sleep(3000);
			Fq4 tc4 = new Fq4(DRIVER);
			tc4.Insurance_Product(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setBrowserdriver(String browserDriver) {

		switch (browserDriver) {
		case "IE": {
			File file = new File("../Libraries/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DRIVER = new InternetExplorerDriver();
			break;
		}
		case "FF": {
			DRIVER = new FirefoxDriver();
			break;
		}
		case "CR": {
			File file = new File("../Libraries/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			DRIVER = new ChromeDriver();
			break;
		}
		default:
			break;
		}

		DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
