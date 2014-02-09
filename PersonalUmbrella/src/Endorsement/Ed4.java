package Endorsement;

import org.openqa.selenium.WebDriver;

import CommonLibrary.PUPCommon;

public class Ed4 extends PUPCommon{

	public Ed4(WebDriver myDriver) {
		super(myDriver);
		// TODO Auto-generated constructor stub
	}

	public void launchQuoteView() {
		DoClicki("quoteTree_content_link");
	}
}
