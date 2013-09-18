package org.zakir;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _Chrome extends Main{
	@Before
	public void _Before() {
		System.setProperty("Dev", "https://qa-pay.cnico.com");
		setUp();
		setBrowserdriver("CR");
	}

	@Test
	public void _Test() {
		runOnlineBillPay(System.getProperty("Dev"));
	}
	
	@After
	public void _After() {
		tearDown();
	}
	
}
