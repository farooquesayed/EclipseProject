package FullQuote;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Fq1 extends PUPCommon {

	public Fq1(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void StartFullQuote() {
		devLogin("http://pasqa/");
		DoClicki("actionNewQuote");
	}

	

	
}
