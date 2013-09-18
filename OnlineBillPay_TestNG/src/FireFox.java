import org.testng.annotations.Test;

public class FireFox extends Main{
	private final String browserName = "FF";

	@Test
	public void fFireFox() {
		setUp(browserName);
		setBrowserdriver(browserName);
		runOnlineBillPay();
		tearDown(browserName);
	}
	

}