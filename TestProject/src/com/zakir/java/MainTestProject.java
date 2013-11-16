package com.zakir.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainTestProject {
	 public static void main(String[] args) 
	   {
		 
		 	Class3 zak = new Class3();
			//Test -1
		 	zak.setJSONobj("Household Member");
		 	zak.oldgetJSONvalue("hhmDOB",0);
			 //Output : 2010
			 
			 
		//Test 0
		 	zak.setJSONobj("Property");
		 	zak.oldgetJSONvalue("Rental.propYearBuilt",-1);
		 //Output : 2010
		 
		 
		//Test 1
		 	zak.setJSONobj("Property");
		 	zak.oldgetJSONvalue("Secondary.propYearBuilt",1); 
		 //Output : 1987
		 
		 //Test 2
		 	zak.setJSONobj("Customer Information");
		 	zak.oldgetJSONvalue("mName",-1);
		 //Output : V1
		 
		 //Test 3
		 	zak.setJSONobj("CNI Auto Policy");
		 	zak.oldgetJSONvalue("insSplitLimit3",-1);
		 //Output : 100
		 
		 
		 
	   }
}