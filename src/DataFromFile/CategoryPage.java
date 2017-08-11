package DataFromFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
	private WebDriver driver;
	private String xpath;
	static List<String>buttonsValue=new ArrayList<>();
	List<String>dataFromFile;
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
		public void buttons(String s) {
			this.xpath=s;
		List<WebElement>buttons=driver.findElements(By.xpath(s));
		
		
		for(int i=0;i<buttons.size();i++)
		{
			WebElement localButton = buttons.get(i);
			String idButton=localButton.getAttribute("for");	
			buttonsValue.add(idButton);
			
		}
		//System.out.println(buttonsValue);
			
	}
		public void write(String filePath) throws IOException {
			FileWriter fw= new FileWriter(filePath);
			try {
			
			for(String b: buttonsValue) {
				fw.write(".//*[@id='sort-producer']//label[@for='"+b+"']");
				fw.write(System.getProperty("line.separator"));
			}
			}catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			finally {
			fw.flush();
			fw.close();
			}
		}	
		
		public void read (String filePath) throws IOException{
			
			FileReader fr= new FileReader(filePath);
			dataFromFile = new ArrayList<>();
			Scanner scan = new Scanner(fr);
			WebElement cancel;
			WebElement eachButton;
			
			while(scan.hasNextLine())
			{
				dataFromFile.add(scan.nextLine());
			}
			fr.close();
			for(int i=0; i<dataFromFile.size();i++)
			{
				eachButton = driver.findElement(By.xpath(dataFromFile.get(i)));
			 	eachButton.click();
			 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				cancel =driver.findElement(By.xpath(".//*[@id='filter-menu']/div[1]/div/a"));
				cancel.click();
			}
			//System.out.println(dataFromFile);
			

			
		}
		


}
