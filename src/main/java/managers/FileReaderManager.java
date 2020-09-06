package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JSONDataReader;

public class FileReaderManager {
	
	private static FileReaderManager FileReaderManager1 = new FileReaderManager() ;
	private static ConfigFileReader ConfigFileReader1;
	private static JSONDataReader JSONDataReader1;
	
	private FileReaderManager()
	{
		
	}
	
	public static FileReaderManager getInstance()
	{
		return FileReaderManager1;	
	}
	
	public ConfigFileReader getConfigFileReader()
	{
		return (ConfigFileReader1==null) ? ConfigFileReader1=new ConfigFileReader() : ConfigFileReader1;
		
	}
	
	public JSONDataReader getJSONDataReader()
	{
		return (JSONDataReader1==null) ? JSONDataReader1=new JSONDataReader() : JSONDataReader1;
		
	}

}
