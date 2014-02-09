package FullQuote;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import CommonLibrary.CommonFunctions;
import CommonLibrary.PUPCommon;

public class Fq4 extends PUPCommon{
	
	public Fq4(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void Insurance_Product(int dateValue) {
		System.out.println("Selecting Product line = PUP");
		DoKeyi("EffectiveDate", CommonFunctions.CustomDate(dateValue, true) + Keys.TAB);

		if (dateValue <= 0) {
			CommonFunctions.addDelay(3000);
			DoClicki("Continue");
		} else
			DoClicki("ContinueLink");
	}

}
