package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOUTPage {
	WebDriver driver;
	homePage home1;
	
	@FindBy(id="submit.add-to-cart") private WebElement submitAddtoCart;
	@FindBy(xpath="//*[@id='hlb-ptc-btn']") private WebElement continueButton;
	@FindBy(partialLinkText="Deliver to this address") private WebElement addressdeliver;
	@FindBy(xpath="//*[@class='order-display']/following-sibling::div//span[1]/span/input[@value='Continue']") private WebElement orderdisplay;
	
	public checkOUTPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doCheckOut()
	{
		home1=new homePage(driver);
		String childWindow = home1.windowHandle();
		driver.switchTo().window(childWindow);
	}
	
	public void checkouttocart() throws InterruptedException
	{
		submitAddtoCart.click();
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(3000);
		addressdeliver.click();
		Thread.sleep(2000);
		orderdisplay.click();
	
	}	 

}
