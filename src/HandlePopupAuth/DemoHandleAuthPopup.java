package HandlePopupAuth;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoHandleAuthPopup {
	
	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://krokodil.com.ua/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void HandelAuthWindow()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);      
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
		alert.authenticateUsing(new UserAndPassword("krokodil", "qweqweqwe"));
	}

}
