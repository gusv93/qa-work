package ElemIsNotClickExep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.ClickElement;

public class YahooMailCheckBox {
	
	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");;
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void SolveExep()
	{
		/*если просто кликаем вылетает exception
		driver.findElement(By.id("persistent")).click();*/
		
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("persistent"))).click().build().perform();*/
		
		//вынес метод сверху в отдельную библиотеку
		ClickElement.clickById(driver, "persistent");
	}

}
