import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class BookingTest {

	public WebDriver DRIVER;
	
	public static void main(String args[]) {
		BookingTest test1 = new BookingTest();
		test1.open_gmailaccount();
		//test1.open_IRCTC();
		//test1.planMyTravel();
		//test1.selectTrain();
		
	}
	
	public void selectTrain() {
		
		DRIVER.findElement(By.xpath("//*[@id=\"a31\"]/input")).click();
		DRIVER.findElement(By.id("submitButton1")).click();
		
	}
	
	
	@Test
	public void selectCalendarDate() {
		
//		setBrowserdriver("CR");
//		DRIVER.get("file:///Users/admin/Downloads/IRCTC/%20%20%20IRCTC%20%20%20%20-%20Plan%20My%20Travel.html");
		DRIVER.findElement(By.id("JDatee")).click();
		DRIVER.findElement(By.xpath("//*[@id=\"CalendarControl\"]/table[1]/tbody/tr[7]/td[3]/a")).click();
		
		
	}
	public void open_gmailaccount()
	{
			setBrowserdriver("CR");
			DRIVER.get("https://accounts.google.com/SignUp?continue=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3Dcaptcha%2Bform%26oq%3Dcaptcha%2Bform%26sourceid%3Dchrome%26espv%3D2%26es_sm%3D91%26ie%3DUTF-8&hl=en");
			Actions action = new Actions(DRIVER);
			action.doubleClick(DRIVER.findElement(By.id("recaptcha_response_field")));
			action.perform();
			

			
	}
	public void open_IRCTC() {
		setBrowserdriver("CR");
		DRIVER.get("http://irctc.co.in");
		
		DRIVER.findElement(By.name("userName")).sendKeys("nasirhere");
		DRIVER.findElement(By.name("password")).sendKeys("123456");
		DRIVER.findElement(By.id("button")).click();
		
	}
	
	public void planMyTravel() {
		DRIVER.findElement(By.id("stationFrom")).sendKeys("CSTM");
		DRIVER.findElement(By.id("stationTo")).sendKeys("Pune");
		selectCalendarDate();
		//DRIVER.findElement(By.id("JDatee")).sendKeys("28/3/2014");
		Select quota = new Select(DRIVER.findElement(By.name("quota")));
		//quota.selectByVisibleText("Takqal");
		DRIVER.findElement(By.name("Submit")).click();	
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
			File file = new File("../Libraries/chromedriver");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			DRIVER = new ChromeDriver();
			break;
		}
		default:
			break;
		}

		//DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
}
