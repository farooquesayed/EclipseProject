import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.google.common.base.Stopwatch;
import org.testng.annotations.*;


public class Main extends Common {
	public WebDriver DRIVER; 
	public String baseUrl = "https://dev-pay.cnico.com";
	public Stopwatch stpWatch = new Stopwatch();

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}


		public void setUp(String bName) {
			System.out.println("TEST STARTED FOR ONLINE BILL PAY: " + bName);
			stpWatch.start();
		}


		public void runOnlineBillPay() {
			DRIVER.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			devLogin(DRIVER, baseUrl);
			PolicySearch.allPolicySearch(DRIVER);
			PaymentInfo.AllPaymentInformation(DRIVER);
			ReviewAndPay.allReviewAndPay(DRIVER);
			Confirmation.allConfirmation(DRIVER);
		}

		public void tearDown(String bName) {
		    DRIVER.quit();
			stpWatch.stop();
			System.out.println(bName + " total test time = " + stpWatch.elapsed(TimeUnit.SECONDS) + " seconds");
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
				File file = new File("lib/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			    DRIVER = new InternetExplorerDriver();
			    break;
			}
			case "FF": {
				//xKillIEs("firefox.exe");
			    DRIVER = new FirefoxDriver();
			    break;
			}
			case "CR": {
				File file = new File("lib/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			    DRIVER = new ChromeDriver();
			    break;
			}
			default: break;
			}
		}

}
