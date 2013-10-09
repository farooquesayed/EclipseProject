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

    	Class3 zak = new Class3();
    	zak.setJSONobj();
    	zak.getJSONvalue("fName");
    	zak.getJSONvalue("mName");
    	zak.getJSONvalue("Year");
     }
}