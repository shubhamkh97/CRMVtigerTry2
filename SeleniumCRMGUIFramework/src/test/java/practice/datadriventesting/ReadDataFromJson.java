package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Step 1: Parse JSon physical file into java Object using JSonParse Class
		JSONParser parser = new JSONParser();
		Object obj= parser.parse(new FileReader("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\JsonFile.json"));
		
		//Step 2: Convert Java Object into JSON Object Using Down Casting
		JSONObject map =(JSONObject)obj;
		
		//Step 3: Get the value from JSON file Using Key
		System.out.println(map.get("url"));
		System.out.println(map.get("Browser"));
		
		
	}

}
