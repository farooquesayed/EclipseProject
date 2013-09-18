package kwi.zakir.HO;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import kwi.zakir.Common.*;

public class AZ_HomeOwner {

	   public final String zip_code = "85042"; 
	   public final String cityName = "Phoenix"; 
	   public final String stateName = "AZ";

	   public AllStates_HO objPage = new AllStates_HO();;
	   
		@Test
		@Parameters ({"Browser", "baseURL"})
		public void initialization(@Optional("IE") String Browser, @Optional("http://quincy/agency/index.cfm?request=ValidateIAISAgent&username=zakirs") String baseURL) {
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
		@Parameters ({"isGeneral_PrimaryResidence_Information"})
		public void General_PrimaryResidence_Information(@Optional("true") boolean isTrue) {
			System.out.println("General_PrimaryResidence_Information");
			if(isTrue) {
				objPage.loc_info(this.zip_code, 1);
				objPage.occu_type();
			}
			
		}
		
		@Test(dependsOnMethods = { "General_PrimaryResidence_Information" })
		@Parameters ({"isInsured_Information"})
		public void Insured_Information(@Optional("true") boolean isTrue) {
			System.out.println("Insured_Information");
			if(isTrue) {
				objPage.insured_basic();
				objPage.insured_prop();
			}
			
		}
		
		@Test(dependsOnMethods = { "Insured_Information" })
		@Parameters ({"isproperty_Information"})
		public void property_Information(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.prop_dwelling();
				objPage.prop_ques();
			}
				System.out.println("property_Information");
			
		}
		
		@Test(dependsOnMethods = { "property_Information" })
		@Parameters ({"isCoverage_Information"})
		public void Coverage_Information(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.cove_basic();
				objPage.cove_ques();
			}
			System.out.println("Coverage_Information");
			
		}
		
		@Test(dependsOnMethods = { "Coverage_Information" })
		@Parameters ({"isCoverageAndRates"})
		public void CoverageAndRates(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.cove_rates();
			}
			System.out.println("CoverageAndRates");
			
		}
		
		@Test(dependsOnMethods = { "CoverageAndRates" })
		@Parameters ({"isAdditional_Eligibility_Questions"})
		public void Additional_Eligibility_Questions(@Optional("true") boolean isTrue)  {
			if(isTrue) {
				objPage.No_Questions();
			}
			System.out.println("Additional_Eligibility_Questions");
			
		}
		
		@Test(dependsOnMethods = { "Additional_Eligibility_Questions" })
		@Parameters ({"isRevalidation_Insured_Information"})
		public void Revalidation_Insured_Information(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.reval_mailing(this.zip_code);
			}
			System.out.println("Revalidation_Insured_Information");
			
		}
		
		@Test(dependsOnMethods = { "Revalidation_Insured_Information" })
		@Parameters ({"isAdd_Mortgage"})
		public void Add_Mortgage(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.No_Mortg();
			}
			System.out.println("Add_Mortgage");
			
		}	
		
		@Test(dependsOnMethods = { "Add_Mortgage" })
		@Parameters ({"isAdditionalInsured"})
		public void AdditionalInsured(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.add_insure();
			}
			System.out.println("AdditionalInsured");
			
		}		
		
		@Test(dependsOnMethods = { "AdditionalInsured" })
		@Parameters ({"isQuoteSummary"})
		public void QuoteSummary(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.quote_summ();
			}
			
			System.out.println("QuoteSummary");
			
		}
		@Test(dependsOnMethods = { "QuoteSummary" })
		@Parameters ({"isIssuePolicy"})
		public void IssuePolicy(@Optional("true") boolean isTrue) {
			if(isTrue) {
				objPage.iss_pol();
			}
			
			System.out.println("IssuePolicy");
			
		}   

		
		@AfterTest
		@Parameters ({"Browser"})
		public void cleanup(@Optional("IE") String Browser) {
			CommonLibrary.TearDown(Browser);
			System.out.println("cleanup");
		}
}

