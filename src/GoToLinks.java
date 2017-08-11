
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoToLinks {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void MainTest() {
		WebElement searchfield = driver.findElement(By.id("lst-ib"));
		searchfield.sendKeys("test");
		searchfield.submit();

		/*
		 * List<WebElement> resultLinks =
		 * driver.findElements(By.xpath(".//*[@id='rso']//h3/a")); for (WebElement
		 * element : resultLinks) {
		 * 
		 * new WebDriverWait(driver, 10)
		 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * ".//*[@id='rso']//h3/a")));
		 * 
		 * element.click();
		 * 
		 * driver.navigate().back(); }
		 */

		List<WebElement> resultLinks = driver.findElements(By.xpath(".//*[@id='rso']//h3/a")); //получаем список вэб элементов
		for (int i = 0; i <= resultLinks.size(); i++) {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			List<WebElement> resultLinks2 = driver.findElements(By.xpath(".//*[@id='rso']//h3/a")); //после возврата на страницу со списком ссылок 
																									//нужно опять переопределить лист ссылок 
																									//по этому повторно получаем список вэб элементов
			resultLinks2.get(i).click(); //кликаем на индекс каждой ссылки в листе
			driver.navigate().back();
		}

	}
}
