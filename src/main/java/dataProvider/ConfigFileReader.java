package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import Enums.driverTypes;
import Enums.environmentTypes;

public class ConfigFileReader {
	
	private Properties prop;
	private final String propertiesfilePath="Configs\\Configuation.properties";
	
	public ConfigFileReader()
	{
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(propertiesfilePath));
			prop = new Properties();
			
			try {
				prop.load(reader);
				reader.close();
			}
			catch(Exception e){
				String msg= e.getMessage();
				System.out.println(msg);
				e.printStackTrace();	
			}
		}
		catch(Exception e) {
			
			String msg= e.getMessage();
			System.out.println(msg);
			e.printStackTrace();
		}
	}
	
	public String getdriverPath() throws Exception
	{
		String driverPath=prop.getProperty("driverPath");
		if(driverPath!=null) return driverPath;
		else throw new Exception ("driverPath is not retrieved");	
	}
	
	public long getimplicitlyWait() throws Exception
	{
		String implicitlyWait=prop.getProperty("implicitlyWait");
		if(implicitlyWait!=null) return Long.parseLong(implicitlyWait);
		else throw new Exception ("implicitlyWait is not retrieved");	
	}
	
	public String geturl() throws Exception
	{
		String url=prop.getProperty("url");
		if(url!=null) return url;
		else throw new Exception ("url is not retrieved");	
	}
	
		public driverTypes getBrowser() {
		String browserName = prop.getProperty("browser");
		if(browserName == null || browserName.equals("Chrome")) return driverTypes.Chrome;
		else if(browserName.equalsIgnoreCase("firefox")) return driverTypes.Firefox;
		else if(browserName.equals("iexplorer")) return driverTypes.InternetExplorer;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
		
		public environmentTypes getEnvironment() {
			String environmentName = prop.getProperty("environment");
			if(environmentName == null || environmentName.equalsIgnoreCase("local")) return environmentTypes.Local;
			else if(environmentName.equals("remote")) return environmentTypes.Remote;
			else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		}
		
		public String getTestDataResourcePath(){
			 String testDataResourcePath = prop.getProperty("testDataResourcePath");
			 if(testDataResourcePath!= null) return testDataResourcePath;
			 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
		 }
		
}
