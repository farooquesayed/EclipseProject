package com.zakir.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChrDriver {

	WebDriver chDriver = new ChromeDriver();
	
	public WebDriver getChDriver() {
		return chDriver;
	}
}
