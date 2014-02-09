package Endorsement;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Ed3 extends PUPCommon{
	public Ed3(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void policyView() {
		DoClicki("//*[@id='ContactTable']/tbody/tr[1]/td[4]", true);
		DoClicki("//*[@id='QuoteTable']/tbody/tr/td[8]/a", true);
	}

}
