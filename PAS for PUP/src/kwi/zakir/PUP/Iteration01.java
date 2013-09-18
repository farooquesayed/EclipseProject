package kwi.zakir.PUP;

import javax.swing.JOptionPane;

import kwi.zakir.Common.CommonLibrary;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Iteration01 {
	
	private NewQuote objPage = new NewQuote();
	
	@Test
	@Parameters ({"Browser", "baseURL"})
	public void initialization(@Optional("CR") String Browser, @Optional("http://pasqa/pup") String baseURL) {
		System.out.println("initialization");

		objPage.setBrowserdriver(Browser);
		objPage.devLogin(baseURL);
		
	}

	@Test(dependsOnMethods = { "initialization" })
	@Parameters ({"isAgencySelection"})
	public void StartQuote_WithAgency(@Optional("true") boolean isTrue) {
		System.out.println("StartQuote_WithAgency");
		if(isTrue) {
			objPage.GetQuote();
			objPage.SelectAgency();
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
	@Parameters ({"isInsProd"})
	public void InsuranceProduct(@Optional("true") boolean isTrue) {
		System.out.println("InsuranceProduct");
		if(isTrue) {
			objPage.Insurance_Product();
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
	@Parameters ({"isCNIauto"})
	public void CNI_Auto_Policy(@Optional("true") boolean isTrue) {
		System.out.println("CNI_Auto_Policy");
		if(isTrue) {
			objPage.CNI_Auto_Policy();
		}
	}
	
	@Test(dependsOnMethods = { "CNI_Auto_Policy" })
	@Parameters ({"isHHM"})
	public void HouseholdMember(@Optional("true") boolean isTrue) {
		System.out.println("HouseholdMember");
		if(isTrue) {
			//CommonLibrary.addDelay(3000);
			objPage.Household_Member();
		}
	}

	
	@Test(dependsOnMethods = { "HouseholdMember" })
	@Parameters ({"isProp"})
	public void Properties(@Optional("true") boolean isTrue) {
		System.out.println("Properties");
		if(isTrue) {
			objPage.Properties();
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

	
	
	@AfterTest
	@Parameters ({"Browser"})
	public void cleanup(@Optional("IE") String Browser) {
		CommonLibrary.TearDown(Browser);
		System.out.println("cleanup");
	}
}
