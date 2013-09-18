import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.base.Stopwatch;

public class Main extends Common {
	public WebDriver DRIVER; 
	public String baseUrl = "https://dev-pay.cnico.com";
	public Stopwatch stpWatch = new Stopwatch();
	
	//@Before
	public void setUp() {
		System.out.println("TEST STARTED FOR ONLINE BILL PAY.");
		stpWatch.start();
	}

	
	//@Test
	public void runOnlineBillPay() {
		devLogin(DRIVER, baseUrl);
		PolicySearch.allPolicySearch(DRIVER);
		PaymentInfo.AllPaymentInformation(DRIVER);
		ReviewAndPay.allReviewAndPay(DRIVER);
		Confirmation.allConfirmation(DRIVER);
	}

	//@After
	public void tearDown() {
	    DRIVER.quit();
		stpWatch.stop();
		System.out.println("Total test time = " + stpWatch.elapsed(TimeUnit.SECONDS) + " seconds");
	}

	
	
	
	public void xKillIEs(String processName) {
		final String KILL = "taskkill /IM ";
		try {
			Runtime.getRuntime().exec(KILL + processName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		addDelay(3000);
	}
	

	public void setBrowserdriver(String browserDriver) {
		switch(browserDriver) {
		case "IE": {
			xKillIEs("iexplore.exe");
		    DRIVER = new InternetExplorerDriver();
		    break;
		}
		case "FF": {
			xKillIEs("firefox.exe");
		    DRIVER = new FirefoxDriver();
		    break;
		}
		case "CR": {
			xKillIEs("chrome.exe");
		    DRIVER = new ChromeDriver();
		    break;
		}
		default: break;
		}
	}

	
}
