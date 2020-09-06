package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.checkOUTPage;
import pageObjects.homePage;
import pageObjects.loginpage;

public class PageObjectManager {
	
	public WebDriver driver;
	loginpage loginpage1;
	homePage homePage1;
	checkOUTPage checkOUTPage1;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public loginpage getloginpageobj()
	{
		return (loginpage1==null)? loginpage1=new loginpage(driver):loginpage1;
	}
	
	public homePage gethomePageobj()
	{
		return (homePage1==null)? homePage1=new homePage(driver):homePage1;
	}
	
	public checkOUTPage getcheckOUTPageobj()
	{
		return (checkOUTPage1==null)? checkOUTPage1=new checkOUTPage(driver):checkOUTPage1;
	}
	
}
