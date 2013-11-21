package com.zakir.java;



public class MainTestProject {
	 public static void main(String[] args) 
	   {
		 
		 	Class3 zak = new Class3();

			 //Test 2
		 	zak.setJSONobj("Customer Information");
		 	zak.getJSONvalue("mName",-1);
		 //Output : V1

		 	
			//Test 0
		 	zak.setJSONobj("Property");
		 	zak.getJSONvalue("Rental.propYearBuilt",-1);
		 //Output : 2010
		 

		 	//Test -1
		 	zak.setJSONobj("Household Member");
		 	zak.getJSONvalue("hhmDOB",0);
			 //Output : 2010
			 
			 
		 
		//Test 1
		 	zak.setJSONobj("Property");
		 	zak.getJSONvalue("Secondary.propYearBuilt",1); 
		 //Output : 1987
		 
		 
		 //Test 3
		 	zak.setJSONobj("CNI Auto Policy");
		 	zak.getJSONvalue("insSplitLimit3",-1);
		 //Output : 100
		 
		 
		 
	   }
}