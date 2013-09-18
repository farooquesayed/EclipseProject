package org.zakir;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _FireFox extends Main{
	@Before
	public void _Before() {
		setUp();
		setBrowserdriver("FF");
	}

	
	@Test
	public void _Test(String baseUrl) {
		runOnlineBillPay(baseUrl);
	}
	
	@After
	public void _After() {
		tearDown();
	}
}
