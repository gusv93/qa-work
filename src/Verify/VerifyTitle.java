package Verify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {

	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://learn-automation.com/");;
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void verifyApptitle()
	{
		//Actual Title
		String myTytle=driver.getTitle();
		
		//String myTytle=driver.getPageSource();
		System.out.println("title is "+myTytle);
		
		String expectedTitle ="Selenium WebDriver tutorial - Selenium WebDriver tutorial Step by Step";
		
		//Assert.assertEquals(myTytle, expectedTitle);
		Assert.assertTrue(myTytle.contains("tutorial"));
		System.out.println("Test complited ");
		
	}
}
