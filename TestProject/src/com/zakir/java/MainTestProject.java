package com.zakir.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainTestProject {
     public static void main(String[] args) {

    	Class3 zak = new Class3();
    	zak.setJSONobj("Property");
    	zak.getJSONvalue("Primary");
//    	zak.getJSONvalue("mName");
//    	zak.getJSONvalue("StreetNumber");
     }
}