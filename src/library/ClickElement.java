package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickElement {

	public static void clickById(WebDriver ldriver,String lid)
	{
		Actions act = new Actions(ldriver);
		act.moveToElement(ldriver.findElement(By.id(lid))).click().build().perform();
	}
}
