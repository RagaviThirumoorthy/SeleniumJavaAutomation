package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Handle auto suggestive dropdown
		String country = "United States (USA)";
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
		for(WebElement option: options) {
			if(option.getText().equalsIgnoreCase(country)) {
				option.click();
				break;
			}
		}
		
		//Print the value selected
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		
		//mentor code
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}

}
