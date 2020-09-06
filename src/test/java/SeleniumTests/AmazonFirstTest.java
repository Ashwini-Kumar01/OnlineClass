package SeleniumTests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFirstTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 Thread.sleep(5000);
		 driver.navigate().to("https://www.amazon.in/");  //Open URl
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Sign in")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("ap_email")).sendKeys("dnyandakulkarni06@gmail.com");
		 driver.findElement(By.name("password")).sendKeys("ganpati2018");
		 driver.findElement(By.id("continue")).click();
		 driver.findElement(By.id("signInSubmit")).click();
		 driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("mask"); 
		 driver.findElement(By.xpath("//*[@value='Go']")).click();
		 Thread.sleep(2000);
		 String MainWindow = driver.getWindowHandle();
		 System.out.println("Main window is " +MainWindow);
		 driver.findElement(By.partialLinkText("Gadgets")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
		 Iterator<String> itr = windowHandles.iterator();
		 while(itr.hasNext())
		 {
			 String childWindow = itr.next();
		  if (!MainWindow.equalsIgnoreCase(childWindow))
		 {
			 System.out.println("This is child window");
			 
			 driver.switchTo().window(childWindow);
			 driver.findElement(By.id("submit.add-to-cart")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id='hlb-ptc-btn']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.partialLinkText("Deliver to this address")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@class='order-display']/following-sibling::div//span[1]/span/input[@value='Continue']")).click();
		 }	 
	
	}
	}

}


