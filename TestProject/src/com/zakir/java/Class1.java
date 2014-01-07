package com.zakir.java;


public class Class1 
{

	public int counter=0;
	
//	public Class1() {
//		
//	}
	
	private  Class1(String name) {
		this.counter = name.length();
	}
			
	
	public Class1() {
		// TODO Auto-generated constructor stub
	}


	public void printCounter() {
		System.out.println(this.counter);
	}
	
}


