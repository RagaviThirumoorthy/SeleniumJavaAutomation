package javascriptexecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		//window scroll
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		//webelement scroll
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Get all amount values from the table and sum it
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		for(int i=0;i<values.size();i++) {
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Total price is :"+sum);
		
		//Compare two total amounts
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
	}

}
