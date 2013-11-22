package Scenarios;

import kwi.zakir.Common.CommonLibrary;
import kwi.zakir.Common.PUPCommon;

public class CustomerInformation extends CommonLibrary{
	
	private PUPCommon cmmPUP = new PUPCommon();
	
	public void Customer_Information() {
		System.out.println("Entering Customer Information");
		DoKeyi("FirstName", cmmPUP.getJSONvalue("fName"));
		DoKeyi("MiddleName", cmmPUP.getJSONvalue("mName"));
		DoKeyi("LastName", cmmPUP.getJSONvalue("lName"));

		DoSelecti("PrimaryPhone_PhoneTypeId", cmmPUP.getJSONvalue("phnType"));
		DoKeyi("EMail", cmmPUP.getJSONvalue("EMail"));

		DoKeyi("PrimaryAddress_StreetNumber", cmmPUP.getJSONvalue("StreetNumber"));
		DoSelecti("PrimaryAddress_StreetDirectionTypeId", cmmPUP.getJSONvalue("StreetDirection"));
		DoKeyi("PrimaryAddress_StreetName", cmmPUP.getJSONvalue("StreetName"));
		DoSelecti("PrimaryAddress_StreetTypeId", cmmPUP.getJSONvalue("StreetType"));
		DoKeyi("PrimaryAddress_UnitNumber", cmmPUP.getJSONvalue("UnitNumber"));
		DoKeyi("PrimaryAddress_ZipCode", cmmPUP.getJSONvalue("ZipCode"));
		DoKeyi("PrimaryPhone_PhoneNumber", cmmPUP.getJSONvalue("phnNumber"));

		DoClicki("ContinueLink");
	}

}
