package Endorsement;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Ed2 extends PUPCommon{

	public Ed2(WebDriver myDriver) {
		super(myDriver);
	}

	public void openPolicy() {
		DoKeyi("searchPAS", "QPU3005300");
		DoClicki("searchPASImg");
	}
}
