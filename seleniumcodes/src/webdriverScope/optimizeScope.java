package webdriverScope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class optimizeScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Count of links on the entire page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count of links in footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));				//Limiting webdriver scope to footer
		System.out.println(footer.findElements(By.tagName("a")).size());		//WebElement footer acting as driver
		
		//3. Count of links in first column of footer section
		WebElement column = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		//4. Click on each link in the coloumn and check if the pages are opening
		for(int i=1;i<column.findElements(By.tagName("a")).size();i++) {
			
			String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(ctrlClick);
			Thread.sleep(1000);
		}
		
		//5. Navigate to each tab and get title of the tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
