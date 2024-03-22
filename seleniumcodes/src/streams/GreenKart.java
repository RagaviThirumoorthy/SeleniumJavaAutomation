package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// 1. Click on veg/fruit name column header
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		// 2. Capture all web elements in first column to a List
		List<WebElement> veg = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		// 3. Get the text from web elements to another list
		List<String> vegName = veg.stream().map(s -> s.getText()).collect(Collectors.toList());

		// 4. Sort the list from step 3
		List<String> sortedvegName = vegName.stream().sorted().collect(Collectors.toList());

		// 5. Compare the original and sorted list
		Assert.assertTrue(vegName.equals(sortedvegName));

		// 6. Get the price of all the veggies
		List<String> vegPrice = veg.stream().map(s -> getVegPrice(s)).collect(Collectors.toList());
		vegPrice.forEach(s -> System.out.println("Price of all veggies: "+s));

		// 7. Get the price of 'Beans'
		List<String> beansPrice = veg.stream().filter(s -> s.getText().contains("Beans")).map(s -> getVegPrice(s))
				.collect(Collectors.toList());
		beansPrice.forEach(s -> System.out.println("Price of Beans: " +s));

		// 8. Get the price of 'Rice' from the last page
		List<String> ricePrice;
		do {
			veg = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			ricePrice = veg.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVegPrice(s))
					.collect(Collectors.toList());
			ricePrice.forEach(s -> System.out.println("Price of Rice: " + s));
			if (ricePrice.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (ricePrice.size() < 1);
		
		// 9. Search the word 'Rice'
		driver.findElement(By.id("search-field")).sendKeys("Banana");
		List<WebElement> results = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> filteredResults = results.stream().filter(s->s.getText().contains("Banana")).collect(Collectors.toList());
		Assert.assertEquals(results.size(),filteredResults.size());
		
	}

	private static String getVegPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;

	}

}
