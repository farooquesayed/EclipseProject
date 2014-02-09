package Endorsement;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Ed1 extends PUPCommon {

	public WebDriver DRIVER;

	public Ed1(WebDriver myDriver) {
		super(myDriver);
	}
	

	public void StartEndorsement() {
		devLogin("http://pasqa/");
	}

}
