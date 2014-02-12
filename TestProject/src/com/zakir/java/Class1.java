package com.zakir.java;

import java.io.File;

import org.junit.Test;


public class Class1 
{

	public int counter=0;
	
//	public Class1() {
//		
//	}
	
	@Test
	public void testFolderLocation() {
		//File f = new File(IEDriverServerLocation);
		
		System.out.println(System.getProperty("user.dir"));
	}
		
	
	public Class1() {
		// TODO Auto-generated constructor stub
	}


	public void printCounter() {
		System.out.println(this.counter);
	}
	
}


