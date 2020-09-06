package dataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import managers.FileReaderManager;

public class JSONDataReader {
	
	 private static String customerFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath();
	
	 public static JSONArray  readJSON() throws IOException, org.json.simple.parser.ParseException
		{
		 	JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(customerFilePath);
			//Read JSON
			Object obj=parser.parse(reader);
			
			JSONArray userlist =  (JSONArray) obj;
			return userlist;
		}
}
