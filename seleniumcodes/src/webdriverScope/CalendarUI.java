package webdriverScope;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "27";
		String month = "1";
		String year = "2027";
		String[] expectedList = {month,date,year};
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				
		//Open calendar
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		//Setting date in calendar
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
		months.get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		//Comparing the results
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<actualList.size();i++) {
			System.out.println(actualList.get(i).getAttribute("value")); 
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
	}

}
