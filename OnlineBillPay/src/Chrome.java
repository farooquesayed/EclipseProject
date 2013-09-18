


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Chrome extends DataDrivenTest{
	@Before
	public void _Before() {
		setUp();
		setBrowserdriver("CR");
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
