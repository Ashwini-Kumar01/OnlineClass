package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	@FindBy(id="ap_email") private WebElement UserName;
	@FindBy(id="continue") private WebElement ContinueButton;
	@FindBy(name="password") private WebElement UserPassword;
	@FindBy(id="signInSubmit") private WebElement SignSumit;
	

	WebDriver driver;
	
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
		UserName.sendKeys("dnyandakulkarni06@gmail.com");
		ContinueButton.click();
		UserPassword.sendKeys("ganpati2018");
		SignSumit.click();		
	}
	
	

}
