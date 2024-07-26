package com.comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility 
{
	String fileLocation;
	public JsonUtility(String fileLocation)
{
	this.fileLocation=fileLocation;
}

	public String getDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser parser = new JSONParser();
		Object obj= parser.parse(new FileReader(fileLocation));
		JSONObject map =(JSONObject)obj;
		String data= (String) map.get(key);
		return data;
			
	}
}
