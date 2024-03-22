package windowhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		Actions actions = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//span[text()='Fashion']")); 
		//Enter words in upper case
		actions.moveToElement(driver.findElement(By.name("q"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//Move to Element and right click
		actions.moveToElement(move).contextClick().build().perform();
		
		
	}

}
