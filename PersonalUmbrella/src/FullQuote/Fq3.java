package FullQuote;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Fq3 extends PUPCommon{
	public Fq3(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void Customer_Information() {
		System.out.println("Entering Customer Information");
		DoKeyi("MiddleName", "M");
		DoKeyi("FirstName", "fName");
		DoKeyi("LastName", "lName");

		DoSelecti("PrimaryPhone_PhoneTypeId", 1);
		DoKeyi("EMail", "EMail@email.com");

		DoKeyi("PrimaryAddress_StreetNumber", "123");
		DoSelecti("PrimaryAddress_StreetDirectionTypeId", 1);
		DoKeyi("PrimaryAddress_StreetName", "StreetName");
		DoSelecti("PrimaryAddress_StreetTypeId", 2);
		DoKeyi("PrimaryAddress_UnitNumber", "1234");
		DoKeyi("PrimaryAddress_ZipCode", "91205");
		DoKeyi("PrimaryPhone_PhoneNumber", "3234726464");

		DoClicki("ContinueLink");
	}
}
