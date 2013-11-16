package kwi.zakir.PUP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kwi.zakir.Common.CommonLibrary;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class NewQuote  extends CommonLibrary{

	public JSONParser parser = new JSONParser();
	public String jsonFileName;
	public static JSONObject pupJSON, a;
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
		DoSelecti("InsuredTypeID", getJSONvalue("InsuredTypeId"));
		DoClicki("MailingAddressSameAsPrimary");

		DoClicki("ContinueLink");
	}
	
	public void Payment_Method() {
		System.out.println("Entering Payment Method");
		PaymentMethods pupPayType = new PaymentMethods();
		String p=getJSONvalue("paymentTypeId").toString();
		
		switch(p)
		{
		case "1":
			pupPayType.CreditCard();
			break;
		case "2":
			pupPayType.DebitCard();
			break;
		case "3":
			pupPayType.PersonalEcheck();
			break;
		case "4":
			pupPayType.paperCheck();
			break;
		default:
			System.out.println("Invalid payment type selected: " + p);
		}	
		
		DoClicki("ContinueLink");
	}
	
	public void Properties(int dateValue) {
		System.out.println("Entering Property information");
		
		DoKeyi("Property_YearBuilt", getJSONvalue("propYearBuilt"));
		insurance_information(dateValue);
		
		DoClicki("NoLink");
		WaitProperty_Click("ContinueLink");
	}
	
	public void insurance_information(int dateValue) {
		DoSelecti("UnderlyingInsurance_LimitTypeId", getJSONvalue("InsLimitTypeId"));
		DoKeyi("UnderlyingInsurance_EffectiveDate", CustomDate(dateValue-7, false));
		DoKeyi("UnderlyingInsurance_Limit", getJSONvalue("insCLimit"));
		DoSelecti("UnderlyingInsurance_InsuranceCarrierId", getJSONvalue("InsCarrierId"));
	//	DoClicki("UnderlyingInsurance_ExpirationDate");
		DoKeyi("UnderlyingInsurance_PolicyNumber", getJSONvalue("propPolicy"));
				
	}
	
	public void Household_Member() {
		System.out.println("Entering household member");
		
		DoKeyi("HouseholdMember_DOB", getJSONvalue("hhmDOB"));
		
		DoClicki("NoLink");
		DoClicki("ContinueLink");
	}
	
	public void CNI_Auto_Policy(int dateValue) {
		System.out.println("Entering CNI auto policy information");
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
		for (int i=0; i<=14; i++) {
			DRIVER.findElement(By.xpath("//input[@id='Questions_" + i + "__Answer' and @value='FALSE']")).click();
		}
		//CommonLibrary.addDelay(2000);
		DoClicki("ContinueLink");
	}
	
	public void Insurance_Product(int dateValue) {
		System.out.println("Selecting Product line = PUP");
		DoKeyi("EffectiveDate", CustomDate(dateValue, true) + Keys.TAB);
		
		if(dateValue<=0) {
			addDelay(3000);
			DoClicki("Continue");
		}
		else
			DoClicki("ContinueLink");
	}
	
	
	public void Customer_Information() {
		System.out.println("Entering Customer Information");
		DoKeyi("FirstName", getJSONvalue("fName"));
		DoKeyi("MiddleName", getJSONvalue("mName"));
		DoKeyi("LastName", getJSONvalue("lName"));
		
		DoSelecti("PrimaryPhone_PhoneTypeId", getJSONvalue("phnType"));
		DoKeyi("EMail", getJSONvalue("EMail"));
		
		DoKeyi("PrimaryAddress_StreetNumber", getJSONvalue("StreetNumber"));
		DoSelecti("PrimaryAddress_StreetDirectionTypeId", getJSONvalue("StreetDirection"));
		DoKeyi("PrimaryAddress_StreetName", getJSONvalue("StreetName"));
		DoSelecti("PrimaryAddress_StreetTypeId", getJSONvalue("StreetType"));
		DoKeyi("PrimaryAddress_UnitNumber", getJSONvalue("UnitNumber"));
		DoKeyi("PrimaryAddress_ZipCode", getJSONvalue("ZipCode"));
		DoKeyi("PrimaryPhone_PhoneNumber", getJSONvalue("phnNumber"));
		
		DoClicki("ContinueLink");
	}
	
	public void GetQuote() {
		System.out.println("Starting Quote");
		DoClicki("btnGetQuote");
	}

	
	public void SelectAgency() {
		System.out.println("Selecting Agency");
		DoSelectn("AgencyBranch", Integer.parseInt((String) getJSONvalue("AgencyBranchId")));
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

	public void setJSONobj_old(String jsonFileName) {
        JSONArray a;
		try {
			a = (JSONArray) parser.parse(new FileReader("./bin/" + jsonFileName));
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
	
	public void setjsonFileName(String filename) {
		this.jsonFileName = filename;
	}
	
	public void setJSONobj(Object key) {
		
		try {
			a = (JSONObject) parser.parse(new FileReader("./bin/" + this.jsonFileName));
	        pupJSON = (JSONObject) a.get(key);
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
	
	public static Object getJSONvalue(String id) {
		Object jsonData = pupJSON.get(id);
        System.out.println("JSON VALUE: " + jsonData.toString());
        return jsonData;
	}	
	
}
