package Listeners;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitdemo 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	
	protected WebDriver driver;
	@Test
	public void Waitdemo () throws InterruptedException 
	{
	String eTitle = "Google";
	String aTitle = "" ;
	Thread.sleep(1000);
	driver = new ChromeDriver();
	// launch Chrome and redirect it to the Base URL
	driver.get("https://www.google.com/" );
	//Maximizes the browser window
	driver.manage().window().maximize() ;
	//get the actual value of the title
	aTitle = driver.getTitle();
	//compare the actual title with the expected title
	if (aTitle.contentEquals(eTitle))
	{
	System.out.println( "Test Passed") ;
	}
	else {
	System.out.println( "Test Failed" );
		}
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(Duration.ofSeconds(50)) 			
			.pollingEvery(Duration.ofMillis(10)) 			
			.ignoring(ClassCastException.class);
	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>()
	{
	
		public WebElement apply(WebDriver driver ) 
		{
			return driver.findElement(By.xpath("//aa"));
		}
	});
	//click on the selenium link
	clickseleniumlink.click();
	//close~ browser
	driver.close() ;
	}


}
