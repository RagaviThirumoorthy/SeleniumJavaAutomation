package tablegrids;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//No. of Rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		System.out.println("Number of Rows: "+rows.size());
		
		//No. of Columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		System.out.println("Number of Columns: "+columns.size());
		
		//Print data of second row
		List<WebElement> secondData = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		for(WebElement data : secondData) {
			System.out.println(data.getText());
		}
		
		//Mentor code
		WebElement table=driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

	}

}
