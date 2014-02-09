package FullQuote;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Fq2 extends PUPCommon{

	public Fq2(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void AgencySelection() {
		System.out.println("Selecting Agency");
		DoSelecti("AgencyBranch", 1);
		DoClicki("ContinueLink");
	}
}
