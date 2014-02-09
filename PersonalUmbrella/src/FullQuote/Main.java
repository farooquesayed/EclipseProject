package FullQuote;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Endorsement.EndorsementMain;

public class Main implements Runnable {

	public WebDriver DRIVER;
	public String Btype;
	
	public Main(String type) {
		this.Btype = type;
	}
	
	public static void DriveFullQuote() {
		Thread t1 = new Thread(new Main("FF"));
		t1.start();

		Thread t2 = new Thread(new Main("CR"));
		t2.start();
	}
	
	
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

//	@Test
//	public void TestA2() {
//		Fq1 tc1 = new Fq1(getDRIVER());
//		tc1.StartFullQuote();
//	}
	
//	@Test
//	public void TestB() {
//		Fq2 tc1 = new Fq2(getDRIVER());
//		tc1.AgencySelection();
//	}
//	
//	@Test
//	public void TestC() {
//		Fq3 tc1 = new Fq3(DRIVER);
//		tc1.Customer_Information();
//	}
//
//	@Test
//	public void TestD() {
//		Fq4 tc1 = new Fq4(DRIVER);
//		tc1.Insurance_Product(7);
//	}
//	
//	public WebDriver getDRIVER() {
//		return DRIVER;
//	}
//
//	public void setDRIVER(WebDriver dRIVER) {
//		DRIVER = dRIVER;
//	}

	public void setBrowserdriver(String browserDriver) {

		switch (browserDriver) {
		case "IE": {
			File file = new File("S:/Zakir/jre7/bin/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DRIVER = new InternetExplorerDriver();
			break;
		}
		case "FF": {
			DRIVER = new FirefoxDriver();
			break;
		}
		case "CR": {
			File file = new File("S:/Zakir/jre7/bin/chromedriver.exe");
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
