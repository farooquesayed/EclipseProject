package kwi.zakir.Common;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class AllStates_HO extends CommonLibrary{
	public WebDriver DRIVER; 
	
	public void iss_pol() {
		System.out.println("POLICY NUMBER: " + DRIVER.findElement(By.id("policy_number")).getText());
	}
	
	public void quote_summ() {
		DoClickn("SaveAndContinue");
	}
	
	public void add_insure() {
		DoClickn("SaveAndContinue");
	}
	
	public void No_Mortg() {
		DoClickn("NoMortgage");
	}
	
	public void reval_mailing(String Zip) {
		DoKeyn("Maddress", "1234 Main Blvd");
		DoKeyn("Mcity", "Phonenix");
		DoSelectn("Mstate", 4);
		DoKeyn("Mzip", Zip);
		
		DoClickn("SaveAndContinue");
		
	}
	
	public void No_Questions() {
		
		DRIVER.findElement(By.xpath("//input[@name='IsOtherPurpose' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsFarmingOrCommercial' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsWithinBrushArea' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsWithinFloodOrWaveArea' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsWithin1BlockOfCommercialorIndustrial' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsRoomingOrBoarding' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsPHWoodBurning' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsDifficultRoadAccess' and @value='0']")).click();
		DRIVER.findElement(By.xpath("//input[@name='IsUnconventionalOrDesign' and @value='0']")).click();
		
		DoClickn("SaveAndContinue");
	}
	
	
	
	public void sel_radio(String atr1, String atr2) {
		DRIVER.findElement(By.xpath("//input[@name=\"" + atr1 + "\" or @value=\"" + atr2 + "\"]")).click();
	}
	
	public void cove_rates() {
		DoClickn("IssuePolicy");
	}
	
	public void cove_basic() {
		DoKeyn("CoverageA", minDwellingLImit());
		
	}
	
	public void cove_ques() {
		DoClickn("GetAQuote");
	}
	
	
	public String minDwellingLImit()
	{
	    String w1 = DRIVER.findElement(By.id("minMaxMsg")).getText();
		int dwLimit = Integer.parseInt(Extract_Amount(w1).replace(",", ""));
	    return Integer.toString((int) (dwLimit*1.05)) ;  ///return additional 5% to the range.
	}

	
	public void prop_dwelling() {
		DoKeyn("YearBuilt", "1983");
		DoSelectn("DwellingTypeID", 1);
		DoKeyn("SquareFootage", "2711");
		DoSelectn("FireHydrantID", 1);
		DoSelectn("FireStationID", 1);
		DoSelectn("ConstructionID", 1);
		DoKeyn("ClaimCount", "0");
		DoSelectn("AlarmCreditId", 1);
		
	}
	
	public void prop_ques() {
		DoClickn("NewlyPurchased");
		DoClickn("SaveAndContinue");
	}
	
	
	public void insured_basic() {
		DoKeyn("Fname", "Zakir");
		DoKeyn("Lname", "TC");
		DoKeyn("Hphone", "323-760-0880");
		DoKeyn("Wphone", "8182336160");
		DoKeyn("Email", "zakirsayed@cnico.com");
	}
	
	public void insured_prop() {
		DoKeyn("PStreetNumber", "1234");
		DoKeyn("PStreetName", "Main");
		DoSelectn("PStreetType", 2);
		DoClickn("SaveAndContinue");
	}
	
	public void loc_info(String Zip, int State) {
		DoSelectn("PState", State);
		DoKeyn("Pzip", Zip);
		DoSelectn("PolType", 1);
	}
	
	public void occu_type() {
		DoSelectn("OccupancyID", 1);
		DoClickn("SaveAndContinue");
	}
	
	
	public void GetQuote() {
		System.out.println("Starting Quote");
		DoClickn("get_quote");
	}
	
	public void SelectAgency() {
		System.out.println("Selecting Agency");
		DoSelectn("Agency", 1);
		DoClickn("Continue");
	}
	
	public void devLogin(String baseUrl) {

		System.out.println("Login in to Dev site: " + baseUrl);
		DRIVER.get(baseUrl);

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

		CommonLibrary.init_Driver(DRIVER);
		DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
