package com.zakir.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Class3 {
	public static void main(String args[]) {
		Class1 wdDeserialize = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("/WebDriver.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			wdDeserialize = (Class1) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }
		catch(ClassNotFoundException c) {
			System.out.println("WebDriver class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized WebDriver...");
	    System.out.println("browserLaunched: " + wdDeserialize.browserLaunched);
	    System.out.println("executionState: " + wdDeserialize.executionState);
	    System.out.println("executionState: " + wdDeserialize.myDriver.toString());
		
	}
}