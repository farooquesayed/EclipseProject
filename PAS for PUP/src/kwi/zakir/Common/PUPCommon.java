package kwi.zakir.Common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PUPCommon {
	public JSONParser parser = new JSONParser();
	private String jsonFileName;
	private static JSONObject pupJSON, a;


	public void setjsonFileName(String filename) {
		this.jsonFileName = filename;
	}

	public void setJSONobj(Object key) {

		try {
			a = (JSONObject) parser.parse(new FileReader("./bin/"
					+ this.jsonFileName));
			PUPCommon.pupJSON = (JSONObject) a.get(key);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO EXCEPTION OCCURRED." + e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("PARSE EXCEPTION OCCURRED." + e.getMessage());
			e.printStackTrace();
		}
		;
	}

	public Object getJSONvalue(String id) {
		return getJSONvalue(id, -1);
	}

	public Object getJSONvalue(String id, int index) {

		Object jsonData = "";
		String sGetKey = "";
		String[] sSplit = id.split("\\.");

		sGetKey = sSplit[sSplit.length - 1];

		if (index != -1) {
			jsonData = pupJSON.get(sSplit[0]).toString();
			String rawData = jsonData.toString();
			String[] sData = rawData.split("\\}\\,\\{");
			return parseValue("{" + sData[index] + "}", sGetKey);
		} else if (id.indexOf(".") != -1) {
			for (int i = 0; i <= sSplit.length - 2; i++) {
				jsonData = pupJSON.get(sSplit[i]).toString();
			}

			sGetKey = sSplit[sSplit.length - 1];
			return parseValue(jsonData, sGetKey);
		}

		else {
			jsonData = pupJSON.get(id);
			System.out.println("JSON VALUE: " + jsonData.toString());
			return jsonData;
		}

	}

	public Object parseValue(Object jsonData, String sGetKey) {

		try {
			String rawData = jsonData.toString();
			rawData = rawData.replace("[", "");
			rawData = rawData.replace("]", "");
			rawData = rawData.replace("{{", "{");
			rawData = rawData.replace("}}", "}");
			pupJSON = (JSONObject) parser.parse(rawData);
			jsonData = pupJSON.get(sGetKey);
			System.out.println("JSON VALUE: " + jsonData.toString());
			return jsonData;

		} catch (ParseException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;

	}

}
