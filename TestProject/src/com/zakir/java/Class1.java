package com.zakir.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Class1 implements java.io.Serializable
{
	WebDriver myDriver; // = new FirefoxDriver();

	boolean  browserLaunched = false;
	String executionState = "Initialized";
	
	public Class1() {
		browserLaunched = true;
		executionState += "setBrowserExecuted";
	}

	public void closeBrowser() {
		myDriver.close();
	}
	
	
}


