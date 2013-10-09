package com.zakir.java;

//import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public JSONObject pupJSON;
	
	public void setJSONobj() {
        JSONArray a;
		try {
			a = (JSONArray) parser.parse(new FileReader("./PAS_PUP.json"));
	        pupJSON = (JSONObject) a.get(0);
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
	
	
	public String getJSONvalue(String id) {
		String jsonData = pupJSON.get(id).toString();
        System.out.println(jsonData);
        return jsonData;
	}


}
