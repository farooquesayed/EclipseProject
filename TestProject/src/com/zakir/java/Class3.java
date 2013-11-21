package com.zakir.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Class3 {
	public static JSONParser parser = new JSONParser();
	public static JSONObject a;
	public static JSONObject pupJSON;
	
	public void setJSONobj(Object key) {
		
		try {
			a = (JSONObject) parser.parse(new FileReader("./test.json"));
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
	
	
	public String getJSONvalue(String id, int index) {
		
		
		String jsonData = "";
		String sGetKey  =  "";
		String[] sSplit = id.split("\\.");
		
		sGetKey  = sSplit[sSplit.length - 1];
		
		
		
		if (index != -1)
		{
			jsonData = pupJSON.get(sSplit[0]).toString();
			
			String[] sData = jsonData.split("\\}\\,\\{");
			printAll("{" + sData[index] + "}",sGetKey);
		}
		else if (id.indexOf(".") != -1)
		{			
			for (int i = 0; i <= sSplit.length - 2; i++)
			{		
				jsonData = pupJSON.get(sSplit[i]).toString();	
			}
			
			sGetKey  = sSplit[sSplit.length - 1];
			printAll(jsonData,sGetKey);
		}
		
		else
		{
			jsonData = pupJSON.get(id).toString();
        	System.out.println(jsonData);
		}
        return "";
        
	}
	public void printAll(String jsonData, String sGetKey) {
		 
		try {
			jsonData = jsonData.replace("[", "");
			jsonData = jsonData.replace("]", "");
			jsonData = jsonData.replace("{{", "{");
			jsonData = jsonData.replace("}}", "}");
			pupJSON = (JSONObject) parser.parse(jsonData);
			jsonData = pupJSON.get(sGetKey).toString();
        	System.out.println(jsonData);
			
		} catch (ParseException e) {
			System.out.println("Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}