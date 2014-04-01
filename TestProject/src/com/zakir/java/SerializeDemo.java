package com.zakir.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	   public static void main(String [] args)
	   {
	      Employee e = new Employee();
	      e.name = "Zakir Sayed";
	      e.address = "14230 Victory bl";
	      e.SSN = 78617861;
	      e.number = 123;

	      try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/employee.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   }
}
