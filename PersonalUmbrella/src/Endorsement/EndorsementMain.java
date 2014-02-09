package Endorsement;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EndorsementMain implements Runnable {
public WebDriver DRIVER;
	
	public String bType;
	
	public EndorsementMain(String type) {
		this.bType = type;
		setBrowserdriver(this.bType);
		Ed1 tc1 = new Ed1(DRIVER);
		tc1.StartEndorsement();
	}
	
	public void DriveEndorsement() {
		Thread t1 = new Thread(new EndorsementMain("CR"));
		t1.start();

//		Thread t2 = new Thread(new EndorsementMain("FF"));
//		t2.start();
	}
	
	@Override
	public void run() {
		
		try {
			
//			setBrowserdriver(this.bType);
//			Ed1 tc1 = new Ed1(DRIVER);
//			tc1.StartEndorsement();

			System.out.println("Waiting for test case2 to execute.");
			Thread.sleep(5000);
			Ed2 tc2 = new Ed2(DRIVER);
			tc2.openPolicy();

			System.out.println("Waiting for test case3 to execute.");
			Thread.sleep(5000);
			Ed3 tc3 = new Ed3(DRIVER);
			tc3.policyView();

			System.out.println("Waiting for test case4 to execute.");
			Thread.sleep(5000);
			Ed4 tc4 = new Ed4(DRIVER);
			tc4.launchQuoteView();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void TestB() {
//		Ed2 tc1 = new Ed2(DRIVER);
//		tc1.openPolicy();
//	}
//	
//	@Test
//	public void TestC() {
//		Ed3 tc1 = new Ed3(DRIVER);
//		tc1.policyView();
//	}
//
//	@Test
//	public void TestD() {
//		Ed4 tc1 = new Ed4(DRIVER);
//		tc1.launchQuoteView();
//	}
//	
//	
	
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
