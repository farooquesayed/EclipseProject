import org.testng.annotations.Test;

public class Chrome extends Main{
	
	private final String browserName = "CR";
	
	@Test
	public void fChrome() {
		System.out.println("Starting Chrome browser test.");
	}

	@Test(dependsOnMethods = { "fChrome" })
	public void _Setup() {
		setUp(browserName);
	}

	@Test(dependsOnMethods = { "_Setup" })
	public void _setBrowserdriver() {
		setBrowserdriver(browserName);
	}

	@Test(dependsOnMethods = { "_setBrowserdriver" })
	public void _runOnlineBillPay() {
		runOnlineBillPay();
	}

	@Test(dependsOnMethods = { "_runOnlineBillPay" })
	public void _tearDown() {
		tearDown(browserName);
	}
}
