package com.zakir.java;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main implements Class2 {

	public static WebDriver DRIVER; 
	
	
	public static void main(String[] args) {
		
		Class2 zakTest = new Main();
		zakTest.printZakirfromClass2();
		
		
		 
		 
	}


	@Override
	public void printZakirfromClass2() {
		System.out.println("Priting from override class");
		
	}


	@Override
	public void zakir(int zak, String zak1) {
		// TODO Auto-generated method stub
		
	}


	

}
