package kwi.zakir.PUP;


import kwi.zakir.Common.CommonLibrary;
import kwi.zakir.Common.PUPCommon;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main_SmokeTest {
	
	private NewQuote objPage = new NewQuote();
	private PUPCommon cmmPUP = new PUPCommon();
	
	@BeforeTest
	public void initialization() {
		System.out.println("initialization");
		cmmPUP.setjsonFileName("PAS_PUP_SmokeTest.json");
		cmmPUP.setJSONobj("FullQuote");
	}
	
	@Test
	@Parameters ({"Browser", "baseURL"})
	public void Login(@Optional("CR") String Browser, @Optional("http://pasqa/pup") String baseURL) {
		System.out.println("Login");
		CommonLibrary.TearDown(Browser);
		objPage.setBrowserdriver(Browser);
		objPage.devLogin(baseURL);		
	}

	@Test(dependsOnMethods = { "Login" })
	@Parameters ({"isAgencySelection"})
	public void StartQuote_WithAgency(@Optional("true") boolean isTrue) {
		System.out.println("StartQuote_WithAgency");
		if(isTrue) {
			objPage.GetQuote();
			objPage.AgencySelection();
		}
		
	}
	
	@Test(dependsOnMethods = { "StartQuote_WithAgency" })
	@Parameters ({"isCustInfo"})
	public void CustomerInformation(@Optional("true") boolean isTrue) {
		System.out.println("CustomerInformation");
		if(isTrue) {
			objPage.Customer_Information();
			
		}
		
	}

	@Test(dependsOnMethods = { "CustomerInformation" })
	@Parameters ({"isInsProd", "EffDate"})
	public void InsuranceProduct(@Optional("true") boolean isTrue, @Optional("-363") int dateValue) {
		System.out.println("InsuranceProduct");
		if(isTrue) {
			objPage.Insurance_Product(dateValue);
		}
	}
	
	@Test(dependsOnMethods = { "InsuranceProduct" })
	@Parameters ({"isGAQ"})
	public void GeneralAcceptabilityQuestions(@Optional("true") boolean isTrue) {
		System.out.println("GeneralAcceptabilityQuestions");
		if(isTrue) {
			objPage.enter_no_GAQ();
		}
	}
	
	@Test(dependsOnMethods = { "GeneralAcceptabilityQuestions" })
	@Parameters ({"isCNIauto", "EffDate"})
	public void CNI_Auto_Policy(@Optional("true") boolean isTrue, @Optional("-363") int dateValue) {
		System.out.println("CNI_Auto_Policy");
		if(isTrue) {
			objPage.CNI_Auto_Policy(dateValue);
		}
	}
	
	@Test(dependsOnMethods = { "CNI_Auto_Policy" })
	@Parameters ({"isHHM"})
	public void HouseholdMember(@Optional("true") boolean isTrue) {
		System.out.println("HouseholdMember");
		if(isTrue) {
			objPage.Household_Member();
		}
	}

	
	@Test(dependsOnMethods = { "HouseholdMember" })
	@Parameters ({"isProp", "EffDate"})
	public void Properties(@Optional("true") boolean isTrue, @Optional("-363") int dateValue) {
		System.out.println("Properties");
		if(isTrue) {
			objPage.Properties(dateValue);
		}
	}
	
	@Test(dependsOnMethods = { "Properties" })
	@Parameters ({"isNonCNI"})
	public void NonCNIVehicle(@Optional("true") boolean isTrue) {
		System.out.println("NonCNIVehicle");
		if(isTrue) {
			objPage.Non_CNI_Vehicle();
		}
	}
	
	@Test(dependsOnMethods = { "NonCNIVehicle" })
	@Parameters ({"isWatercraft"})
	public void Watercraft(@Optional("true") boolean isTrue) {
		System.out.println("Watercraft");
		if(isTrue) {
			objPage.Watercraft();
		}
	}
	
	@Test(dependsOnMethods = { "Watercraft" })
	@Parameters ({"isRecVeh"})
	public void RecreationalVehicle(@Optional("true") boolean isTrue) {
		System.out.println("RecreationalVehicle");
		if(isTrue) {
			objPage.Recreational_Vehicle();
		}
	}
	
	@Test(dependsOnMethods = { "RecreationalVehicle" })
	@Parameters ({"isCovPrem"})
	public void CoveragePremium(@Optional("true") boolean isTrue) {
		System.out.println("CoveragePremium");
		if(isTrue) {
			objPage.Coverage_Premium();
		}
	}
	@Test(dependsOnMethods = { "CoveragePremium" })
	@Parameters ({"isNameInsured"})
	public void NameInsured(@Optional("true") boolean isTrue) {
		System.out.println("NameInsured");
		if(isTrue) {
			objPage.Name_Insured_Trustee();
		}
	}
	
	@Test(dependsOnMethods = { "NameInsured" })
	@Parameters ({"isPaymentMethod"})
	public void PaymentMethod(@Optional("true") boolean isTrue) {
		System.out.println("PaymentMethod");
		if(isTrue) {
			objPage.Payment_Method();
		}
	}
	
	@Test(dependsOnMethods = { "PaymentMethod" })
	public void SendEmail() {
		System.out.println("Sending Email.");
		CommonLibrary.SendEmail("zakirsayed@cnico.com", "Quote created: " + 
					objPage.getQuoteNumber() , "");
	}

	@AfterTest
	@Parameters ({"Browser"})
	public void cleanup(@Optional("IE") String Browser) {
		CommonLibrary.TearDown(Browser);
		System.out.println("cleanup");
	}
}
