package com.zakir.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Class3 implements Class1 {
	public void printFROMclass3() {
		System.out.println("Printing from Class 3");
	}

	@Override
	public void interfaceMethod() {
		printFROMclass3();
		
	}


}