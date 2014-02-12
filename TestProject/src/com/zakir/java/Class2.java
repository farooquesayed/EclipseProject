package com.zakir.java;

import java.io.File;
import java.net.URI;

//import org.junit.Before;
//import org.junit.Test;

public class Class2  {
	
	public static int counter = 2;
	
	public static void main(String[] args) {
		
		File currentDir = new File("../Libraries/IEDriverServer.exe");
		if(currentDir.exists()) {
			System.out.println("File readable");
		}
		System.out.println(currentDir.getAbsolutePath());
	}
		


}
