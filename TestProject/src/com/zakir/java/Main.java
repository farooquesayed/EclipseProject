package com.zakir.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
     public static void main(String[] args) {

    JSONParser parser = new JSONParser();

        JSONArray a;
		try {
          JSONObject person = (JSONObject) parser.parse(new FileReader("c:\\jsontest.txt"));

          String fName = (String) person.get("fName");
          System.out.println(fName);

          String mName = (String) person.get("mName");
          System.out.println(mName);

          String lName = (String) person.get("lName");
          System.out.println(lName);

        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
     } 

}