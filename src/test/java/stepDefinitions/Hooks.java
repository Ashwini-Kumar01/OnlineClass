package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;

public class Hooks {
	
	public WebDriver driver;
	WebDriverManager WebDriverManager1;
	
	
	public Hooks() throws Exception
	{
		WebDriverManager1 =new WebDriverManager();
		driver=WebDriverManager1.getDriver();
	}
	
	/*
	 * @Before public void BeforeSteps() { driver.get("https://www.google.com/"); }
	 */
	
	@After
	public void AfterSteps()
	{
		WebDriverManager1.closeDriver();
	}

}
