package ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ajaxdemo 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	private String URL = "file:///home/tyss/Documents/srikanth/tys2nd/html/ajax.html";
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		//create chrome instance
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	
	@Test
	public void test_AjaxExample() throws InterruptedException {

		By container = By.cssSelector(".container");
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(container));
		
		//Get the text before performing an ajax call
		WebElement noTextElement = driver.findElement(By.className("radiobutton"));
		String textBefore = noTextElement.getText().trim();
		
		//Click on the radio button
		driver.findElement(By.id("yes")).click();
		Thread.sleep(2000);
		//Click on Check Button
		driver.findElement(By.id("buttoncheck")).click();
		Thread.sleep(2000);
		/*Get the text after ajax call*/
		WebElement TextElement = driver.findElement(By.className("radiobutton"));
		wait.until(ExpectedConditions.visibilityOf(TextElement));
		String textAfter = TextElement.getText().trim();
		Thread.sleep(2000);
		/*Verify both texts before ajax call and after ajax call text.*/
		Assert.assertNotEquals(textBefore, textAfter);
		System.out.println("Ajax Call Performed");
		Thread.sleep(2000);
		String expectedText = "Radio button is checked and it's value is Yes";
		
		/*Verify expected text with text updated after ajax call*/
		Assert.assertEquals(textAfter, expectedText);
		Thread.sleep(5000);
		driver.close();
	}

}
