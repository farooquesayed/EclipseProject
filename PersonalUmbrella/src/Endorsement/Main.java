package Endorsement;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Main {

	public WebDriver DRIVER;
	
//	public static ThreadLocal<WebDriver> driver;
//	driver=new ThreadLocal<WebDriver>()
//	                {
//	                    @Override
//	                    protected WebDriver initialValue()
//	                    {
//	                        return new FirefoxDriver(); //You can use other driver based on your requirement.
//	                    }
//	                };	
//	@BeforeClass
//	public void initialize() {
//		setBrowserdriver("CR");
//	}
	
	@Test
	public void TestA() {
		setBrowserdriver("CR");
		Ed1 tc1 = new Ed1(DRIVER);
		tc1.StartEndorsement();

		Ed2 tc2 = new Ed2(DRIVER);
		tc2.openPolicy();

		Ed3 tc3 = new Ed3(DRIVER);
		tc3.policyView();
	
		Ed4 tc4 = new Ed4(DRIVER);
		tc4.launchQuoteView();
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
