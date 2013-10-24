package kwi.zakir.PUP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import kwi.zakir.Common.CommonLibrary;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewQuote  extends CommonLibrary{

	public JSONParser parser = new JSONParser();
	public static JSONObject pupJSON;
	private WebDriver DRIVER; 
	
	public void Non_CNI_Vehicle() {
		System.out.println("Entering Non CNI Vehicle");
		waitPage("AddVehicle");
		WaitProperty_Click("ContinueLink");
	}
	
	public void Watercraft() {
		System.out.println("Entering Watercraft");
		waitPage("AddWatercraft");
		WaitProperty_Click("ContinueLink");
	}
	
	public void Recreational_Vehicle() {
		System.out.println("Entering recreational Vehicle");
		waitPage("AddRecVehicle");
		WaitProperty_Click("ContinueLink");
	}
	
	public void Coverage_Premium() {
		System.out.println("Entering Coverage Premium");
		waitPage("CPPrint");
		
		DoClicki("qpbb2_SelectPolicy");
		WaitProperty_Click("ContinueLink");
	}
	
	public void Name_Insured_Trustee() {
		System.out.println("Entering Name Insured & Trustee");
		waitPage("InsuredTypeID");
		
		DoSelecti("InsuredTypeID", Integer.parseInt(getJSONvalue("InsuredTypeId")));
		DoClicki("MailingAddressSameAsPrimary");

		DoClicki("ContinueLink");
	}
	
	public void Payment_Method() {
		System.out.println("Entering Payment Method");
		waitPage("PaymentTypeId");
		
		DoSelecti("PaymentTypeId", Integer.parseInt(getJSONvalue("paymentTypeId")));
		DoSelecti("CardTypeId", Integer.parseInt(getJSONvalue("cardTypeId")));
		DoKeyi("CardNumber", getJSONvalue("CardNumber"));
		DoKeyi("SecurityCode", getJSONvalue("SecurityCode"));
		DoSelecti("Month", Integer.parseInt(getJSONvalue("Month")));
		DoSelecti("Year", Integer.parseInt(getJSONvalue("Year")));

		DoClicki("ContinueLink");
	}
	
	public void Properties(int dateValue) {
		System.out.println("Entering Property information");
		waitPage("Property_YearBuilt");
		DoKeyi("Property_YearBuilt", getJSONvalue("propYearBuilt"));
		insurance_information(dateValue);
		DoClicki("NoLink");
		
		waitPage("AddProperty");
		WaitProperty_Click("ContinueLink");
	}
	
	public void insurance_information(int dateValue) {
		DoSelecti("UnderlyingInsurance_LimitTypeId", Integer.parseInt(getJSONvalue("InsLimitTypeId")));
		DoKeyi("UnderlyingInsurance_EffectiveDate", CustomDate(dateValue-7, false));
		DoKeyi("UnderlyingInsurance_Limit", getJSONvalue("insCLimit"));
		DoSelecti("UnderlyingInsurance_InsuranceCarrierId", Integer.parseInt(getJSONvalue("InsCarrierId")));
	//	DoClicki("UnderlyingInsurance_ExpirationDate");
		DoKeyi("UnderlyingInsurance_PolicyNumber", getJSONvalue("propPolicy"));
				
	}
	
	public void Household_Member() {
		System.out.println("Entering household member");
		waitPage("HouseholdMember_DOB");
		DoKeyi("HouseholdMember_DOB", getJSONvalue("hhmDOB"));
		DoClicki("NoLink");

		waitPage("AddHouseholdMember");
		DoClicki("ContinueLink");
	}
	
	public void CNI_Auto_Policy(int dateValue) {
		System.out.println("Entering CNI auto policy information");
		waitPage("NumberOfVehicles");
		DoClicki("NumberOfVehicles");
		DoKeyi("NumberOfVehicles", getJSONvalue("NoOfCNIVeh"));
		
		DoKeyi("Limit_octet_1", getJSONvalue("insSplitLimit1"));
		DoKeyi("Limit_octet_2", getJSONvalue("insSplitLimit2"));
		DoKeyi("Limit_octet_3", getJSONvalue("insSplitLimit3"));
		DoKeyi("PersonalAutoPolicyNumber", getJSONvalue("PAPolicyNumber"));
		DoKeyi("EffectiveDate", CustomDate(dateValue-7, false));
		
		WaitProperty_Click("ContinueLink");
	}

	
	public void enter_no_GAQ() {
		System.out.println("Answering NO to all questions.");
		waitPage("QuestionHeader");
		for (int i=0; i<=14; i++) {
			DRIVER.findElement(By.xpath("//input[@id='Questions_" + i + "__Answer' and @value='FALSE']")).click();
		}
		//CommonLibrary.addDelay(2000);
		DoClicki("ContinueLink");
	}
	
	public void Insurance_Product(int dateValue) {
		System.out.println("Selecting Product line = PUP");
		waitPage("EffectiveDate");
		DoKeyi("EffectiveDate", CustomDate(dateValue, false) + Keys.TAB);
		
		if(dateValue<=0) {
			addDelay(3000);
			DoClicki("Continue");
		}
		else
			DoClicki("ContinueLink");
	}
	
	
	public void Customer_Information() {
		System.out.println("Entering Customer Information");
		waitPage("FirstName");
		DoKeyi("LastName", getJSONvalue("lName"));
		DoKeyi("MiddleName", getJSONvalue("mName"));
		DoKeyi("FirstName", getJSONvalue("fName"));
		
		DoSelecti("PrimaryPhone_PhoneTypeId", Integer.parseInt(getJSONvalue("phnType")));
		DoKeyi("EMail", getJSONvalue("EMail"));
		
		DoKeyi("PrimaryAddress_StreetNumber", getJSONvalue("StreetNumber"));
		DoSelecti("PrimaryAddress_StreetDirectionTypeId", Integer.parseInt(getJSONvalue("StreetDirection")));
		DoKeyi("PrimaryAddress_StreetName", getJSONvalue("StreetName"));
		DoSelecti("PrimaryAddress_StreetTypeId", Integer.parseInt(getJSONvalue("StreetType")));
		DoKeyi("PrimaryAddress_UnitNumber", getJSONvalue("UnitNumber"));
		DoKeyi("PrimaryAddress_ZipCode", getJSONvalue("ZipCode"));
		DoKeyi("PrimaryPhone_PhoneNumber", getJSONvalue("phnNumber"));
		
		DoClicki("ContinueLink");
	}
	
	public void GetQuote() {
		System.out.println("Starting Quote");
		waitPage("btnGetQuote");
		DoClicki("btnGetQuote");
	}

	
	public void SelectAgency() {
		System.out.println("Selecting Agency");
		waitPage("AgencyBranch");
		DoSelectn("AgencyBranch", Integer.parseInt(getJSONvalue("AgencyBranchId")));
		DoClicki("ContinueLink");
	}
	
	public void devLogin(String baseUrl) {

		System.out.println("Login in to Dev site: " + baseUrl);
		DRIVER.get(baseUrl);
		
	}
	
    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {
          public WebElement apply(WebDriver driver) {
            WebElement element = driver.findElement(by);
            return element.isDisplayed() ? element : null;
          }
        };
      }
      
      public void waitPage(String objID) {
    	  System.out.println("Waiting for ID: " + objID);
    	  Wait<WebDriver> wait = new WebDriverWait(DRIVER, 20);
    	  wait.until(visibilityOfElementLocated(By.id(objID)));
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
		//DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setJSONobj() {
        JSONArray a;
		try {
			a = (JSONArray) parser.parse(new FileReader("./bin/PAS_PUP.json"));
	        pupJSON = (JSONObject) a.get(0);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	
	public static String getJSONvalue(String id) {
		String jsonData = pupJSON.get(id).toString();
        System.out.println(jsonData);
        return jsonData;
	}	
	
}
