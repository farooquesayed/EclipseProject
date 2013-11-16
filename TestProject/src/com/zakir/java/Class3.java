package com.zakir.java;

//import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Class3 {

	public JSONParser parser = new JSONParser();
	public JSONObject a, pupJSON;
	
	public void setJSONobj(Object key) {
		
		try {
			a = (JSONObject) parser.parse(new FileReader("C:\\test.json"));
	        pupJSON = (JSONObject) a.get(key);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	
	public String oldgetJSONvalue(String id) {
		String jsonData = pupJSON.get(id).toString();
        System.out.println(jsonData);
        return jsonData;
	}
	
	public String jetJSONvalue(String id) {
	      JSONObject jObject = pupJSON;
	        Iterator<?> keys = jObject.keySet();

	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	            if( jObject.get(key) instanceof JSONObject ){

	            }
	        }		
	}


}
