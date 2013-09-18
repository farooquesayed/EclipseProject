package kwi.zakir.PUP;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import kwi.zakir.Common.CommonLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewQuote  extends CommonLibrary{

	private WebDriver DRIVER; 

	public void Non_CNI_Vehicle() {
		System.out.println("Entering Non CNI Vehicle");
		
		DoClicki("ContinueLink");
	}
	
	public void Watercraft() {
		System.out.println("Entering Watercraft");
		
		DoClicki("ContinueLink");
	}
	
	public void Recreational_Vehicle() {
		System.out.println("Entering recreational Vehicle");
		
		DoClicki("ContinueLink");
	}
	
	public void Coverage_Premium() {
		System.out.println("Entering Coverage Premium");
		DoClicki("qpbb2_SelectPolicy");
		DoClicki("ContinueLink");
	}
	
	public void Name_Insured_Trustee() {
		System.out.println("Entering Name Insured & Trustee");
		DoSelecti("InsuredTypeID", 1);
		DoClicki("MailingAddressSameAsPrimary");

		DoClicki("ContinueLink");
	}
	
	public void Payment_Method() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", 1);
		DoSelecti("CardTypeId", 1);
		DoKeyi("CardNumber", "4111111111111111");
		DoKeyi("SecurityCode", "111");
		DoSelecti("Month", 2);
		DoSelecti("Year", 2);

		DoClicki("ContinueLink");
	}
	
	public void Properties() {
		System.out.println("Entering Property information");
		
		DoKeyi("Property_YearBuilt", "2010");
		insurance_information();
		
		DoClicki("NoLink");
		WaitProperty_Click("ContinueLink");
	}
	
	public void insurance_information() {
		DoSelecti("UnderlyingInsurance_LimitTypeId", 1);
		DoKeyi("UnderlyingInsurance_EffectiveDate", CustomDate(-7, false));
		DoSelecti("UnderlyingInsurance_InsuranceCarrierId", 3);
	//	DoClicki("UnderlyingInsurance_ExpirationDate");
		DoKeyi("UnderlyingInsurance_Limit", "555");
		DoKeyi("UnderlyingInsurance_PolicyNumber", "POL1234567");
				
	}
	
	public void Household_Member() {
		System.out.println("Entering household member");
		
		DoKeyi("HouseholdMember_DOB", "02/02/1970");
		
		DoClicki("NoLink");
		DoClicki("ContinueLink");
	}
	
	public void CNI_Auto_Policy() {
		System.out.println("Entering CNI auto policy information");
		DoClicki("NumberOfVehicles");
		DoKeyi("NumberOfVehicles", "1");
		
		DoKeyi("Limit_octet_1", "250");
		DoKeyi("Limit_octet_2", "500");
		DoKeyi("Limit_octet_3", "100");
		DoKeyi("PersonalAutoPolicyNumber", "PPA1234679");
		DoKeyi("EffectiveDate", CustomDate(-7, false));
		
		WaitProperty_Click("ContinueLink");
	}

	
	public void enter_no_GAQ() {
		System.out.println("Answering NO to all questions.");
		for (int i=0; i<=14; i++) {
			DRIVER.findElement(By.xpath("//input[@id='Questions_" + i + "__Answer' and @value='FALSE']")).click();
		}
		//CommonLibrary.addDelay(2000);
		DoClicki("ContinueLink");
	}
	
	public void Insurance_Product() {
		System.out.println("Selecting Product line = PUP");
		DoClicki("ContinueLink");
	}
	
	
	public void Customer_Information() {
		System.out.println("Entering Customer Information");
		DoKeyi("FirstName", "WebDriver");
		DoKeyi("MiddleName", "S");
		DoKeyi("LastName", "Automation");
		
		DoSelecti("PrimaryPhone_PhoneTypeId", 1);
		DoKeyi("EMail", "zakirsayed@cnico.com");
		
		DoKeyi("PrimaryAddress_StreetNumber", "12200");
		DoSelecti("PrimaryAddress_StreetDirectionTypeId", 1);
		DoKeyi("PrimaryAddress_StreetName", "Sylvan");
		DoSelecti("PrimaryAddress_StreetTypeId", 1);
		DoKeyi("PrimaryAddress_UnitNumber", "555");
		DoKeyi("PrimaryAddress_ZipCode", "91205");
		DoKeyi("PrimaryPhone_PhoneNumber", "8187600880");
		
		DoClicki("ContinueLink");
	}
	
	public void GetQuote() {
		System.out.println("Starting Quote");
		DoClicki("btnGetQuote");
	}

	
	public void SelectAgency() {
		System.out.println("Selecting Agency");
		DoSelectn("AgencyBranch", 6);
		DoClicki("ContinueLink");
	}
	
	public void devLogin(String baseUrl) {

		System.out.println("Login in to Dev site: " + baseUrl);
		DRIVER.get(baseUrl);
		
	}
	
	
	public void setBrowserdriver(String browserDriver) {
		
		switch(browserDriver) {
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
