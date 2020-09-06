package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.checkOUTPage;
import pageObjects.homePage;
import pageObjects.loginpage;

public class steps {
	
	public WebDriver driver;
	loginpage loginpage1;
	homePage homepage1;
	checkOUTPage checkOUTPage1;
	PageObjectManager PageObjectManager1;
	//ConfigFileReader ConfigFileReader1;
	WebDriverManager WebDriverManager1;
	
	@Given("^user is on Amazon Home Page$")
	public void user_is_on_Amazon_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//ConfigFileReader1=new ConfigFileReader();
		WebDriverManager1 =new WebDriverManager();
		driver=WebDriverManager1.getDriver();
		
		 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getimplicitlyWait(), TimeUnit.SECONDS);
		 PageObjectManager1 = new PageObjectManager(driver);
		 homepage1=PageObjectManager1.gethomePageobj(); 
		 homepage1.launchURL(FileReaderManager.getInstance().getConfigFileReader().geturl());
		 homepage1.clicksignIN();
		 Thread.sleep(2000);
		 loginpage1 = PageObjectManager1.getloginpageobj();
		 loginpage1.login();    
	}

	
	 @When("^user searches for \"([^\"]*)\"$")
	 public void user_searches_for(String arg1) throws Throwable {
		
		 homepage1.searchItems(arg1);
		 Thread.sleep(2000);
	 }
	


	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
			checkOUTPage1=PageObjectManager1.getcheckOUTPageobj();
			checkOUTPage1.doCheckOut();
			checkOUTPage1.checkouttocart();
	
	}
	
	@Given("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
	}



	@Given("^User Navigate to facebook LogIn Page$")
	public void user_Navigate_to_facebook_LogIn_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		
		WebDriverManager1 = new WebDriverManager();
		driver =WebDriverManager1.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getimplicitlyWait(), TimeUnit.SECONDS);
		 
		 PageObjectManager1 = new PageObjectManager(driver);
		 homepage1=PageObjectManager1.gethomePageobj(); 
		 homepage1.launchURL(FileReaderManager.getInstance().getConfigFileReader().geturl());
		   
   
	}
	
	@When("^User enters details \"([^\"]*)\" and \"([^\"]*)\" on facebookPage$")
	public void user_enters_details_and_on_facebookPage(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		JSONArray userlist = FileReaderManager.getInstance().getJSONDataReader().readJSON();
		
		for(int i=0;i<userlist.size();i++)
		{
			
			JSONObject users = (JSONObject) userlist.get(i);
			JSONObject user = (JSONObject) users.get("Users");
  
			String username1=(String) user.get("Username");
			driver.findElement(By.id("email")).sendKeys(username1);
			
			System.out.println(username1);
			  
			String pass = (String) user.get("Password");
			driver.findElement(By.id("pass")).sendKeys(pass);
			  
			System.out.println(pass);
			  
		}
		
		driver.findElement(By.id("u_0_b")).click();
	    
	   
	}

	@Then("^homepage is displayed Login Successfully for facebook$")
	public void homepage_is_displayed_Login_Successfully_for_facebook() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 
		driver= WebDriver.class.newInstance();
		
		SearchContext driver = new FirefoxDriver();
	}

	    
}

	

