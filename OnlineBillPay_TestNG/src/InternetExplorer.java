import org.testng.annotations.Test;

public class InternetExplorer extends Main{
	private final String browserName = "IE";
	
	@Test
	public void fInternetExplorer() {
		setUp(browserName);
		setBrowserdriver(browserName);
		runOnlineBillPay();
		tearDown(browserName);
	}

}