package com.zakir.java;

import javax.swing.JOptionPane;

import org.testng.annotations.Test;




public class TestTESTNG {
//
//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("@BeforeSuite");
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("@BeforeTest");
//	}

	@Test
	public void f() {
		System.out.println("Printing from @Test");
		JOptionPane.showMessageDialog(null, "Please login and click OK");
	}
	
//	@AfterTest
//	public void afterTest() {
//		System.out.println("@AfterTest");
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("@AfterSuite");
//	}

}
