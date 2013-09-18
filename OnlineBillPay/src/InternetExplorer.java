

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InternetExplorer extends DataDrivenTest{
	@Before
	public void _Before() {
		setUp();
		setBrowserdriver("IE");
	}

	
	@Test
	public void _Test() {
		runOnlineBillPay();
	}
	
	@After
	public void _After() {
		tearDown();
	}
}
