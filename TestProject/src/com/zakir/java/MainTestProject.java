package com.zakir.java;

import java.math.BigInteger;



public class MainTestProject {
	 public static void main(String[] args) 
	   {
		 
		 	Class3 zak = new Class3();

//			 //Test 2
//		 	zak.setJSONobj("Customer Information");
//		 	zak.getJSONvalue("mName",-1);
//		 //Output : V1
//
//		 	
			//Test 0
//		 	zak.setJSONobj("FullQuote");
//		 	System.out.println(zak.getJSONvalue("fName", -1));
		 //Output : 2010
		 

		 	//Test -1
		 	zak.setJSONobj("Household Member");
		 	System.out.println(zak.getJSONvalue("hhmlist.id", 1));
			//System.out.println(zak.getJSONvalue("hhmlist.hhmDOB", 1));
			 //Output : 2010
			 
			 
		 
		//Test 1
		 	zak.setJSONobj("Property");
		 	zak.getJSONvalue("Secondary.propYearBuilt",1); 
		 //Output : 1987
		 
		 
//		 //Test 3
//		 	zak.setJSONobj("CNI Auto Policy");
//		 	zak.getJSONvalue("insSplitLimit3",-1);
//		 //Output : 100
		 
		 
		 
	   }
}