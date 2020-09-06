package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Enums.driverTypes;
import Enums.environmentTypes;

public class WebDriverManager {
	
	private WebDriver driver;
	private driverTypes driverTypes1;
	private environmentTypes environmentTypes1;
	private static final String chrome_driver_property = "webdriver.chrome.driver";
	
	
	public WebDriverManager()
	
	{
		driverTypes1= FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentTypes1=FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}
	
	public WebDriver getDriver() throws Exception
	{
		if(driver==null) driver=createDriver();
		return driver;
		
	}

	private WebDriver createDriver() throws Exception {
		
		switch (environmentTypes1) {	    
        case Local : driver = createLocalDriver();
        	break;
        case Remote : driver = createRemoteDriver();
        	break;
	   }
	   return driver;

	}

	private WebDriver createRemoteDriver() {
		
		throw new RuntimeException("Remote driver is not available");
	}

	private WebDriver createLocalDriver() throws Exception {

		switch (driverTypes1) {	    
        case Firefox : driver = new FirefoxDriver();
	    	break;
        case Chrome : 
        	System.setProperty(chrome_driver_property,FileReaderManager.getInstance().getConfigFileReader().getdriverPath() );
        	driver = new ChromeDriver();
    		break;
        case InternetExplorer : driver = new InternetExplorerDriver();
    		break;
        }
		return driver;
	}
	
	public void closeDriver()
	{
		driver.close();
		driver.quit();
	}
}
