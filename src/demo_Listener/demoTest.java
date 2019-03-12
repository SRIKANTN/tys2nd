package demo_Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(Listener_demo.class)
public class demoTest extends Listener_demo
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	WebDriver driver= new FirefoxDriver();					

	// Test to pass as to verify listeners .		
	@Test		
	public void Login()				
	{		
	    driver.get("https://demo.actitime.com/login.do");					
	    driver.findElement(By.id("username")).sendKeys("admin");							
	    driver.findElement(By.name("pwd")).sendKeys("manager");							
	    driver.findElement(By.xpath("//div[.='Login ']")).click();		
	    driver.close();
	}		

	// Forcefully failed this test as to verify lisextends Listener_demotener.		
	@Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}		

}
