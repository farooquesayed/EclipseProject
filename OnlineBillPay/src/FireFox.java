

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FireFox extends Main{
	@Before
	public void _Before() {
		setUp();
		setBrowserdriver("FF");
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
