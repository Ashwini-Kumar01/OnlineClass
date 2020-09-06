package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	
	
	@FindBy(linkText="Sign in") private WebElement signInButton;
	//@FindBy(id="signInSubmit") public WebElement signInButton;
	@FindBy(xpath="//*[@id='twotabsearchtextbox']") private WebElement searchBox;
	@FindBy(xpath="//*[@value='Go']") private WebElement searchButton;
	@FindBy(xpath="//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]//h2") private WebElement searchedItem;
	
	public static WebDriver driver;
	
	
	public static WebDriver returndrivertoother()
	{
		return driver;
	
	}
	
	public homePage(WebDriver driver)
	{
		homePage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void launchURL(String url) throws InterruptedException
	{	
		homePage.returndrivertoother();
		driver.navigate().to(url);  //Open URl
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	}
	
	public void clicksignIN() 
	{	
		homePage.returndrivertoother();
		//homePage.driver.findElement(By.id("signInSubmit")).click();
		signInButton.click();
		
	
	}
	
	public void searchItems(String item)
	{
		homePage.returndrivertoother();
		searchBox.sendKeys(item); 
		searchButton.click();		 		
	}
	
	public String windowHandle()
	{
		 String MainWindow = driver.getWindowHandle();
		 System.out.println("Main window is " +MainWindow);
		 searchedItem.click();
		 Set<String> windowHandles = driver.getWindowHandles();
		 Iterator<String> itr = windowHandles.iterator();
		 String childWindow =null;
		 while(itr.hasNext())
		 {
			 childWindow = itr.next();
		  if (!MainWindow.equalsIgnoreCase(childWindow))
		 {	
			  
			  System.out.println("this is child window" +childWindow);
			  
		 }
		  
		 }
		 
		 System.out.println("this is child window" +childWindow);
		 return childWindow;
	}

}
