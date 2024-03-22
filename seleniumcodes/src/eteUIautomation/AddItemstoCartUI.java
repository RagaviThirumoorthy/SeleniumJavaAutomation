package eteUIautomation;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemstoCartUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = {"Cucumber","Capsicum","Raspberry","Walnuts"};
		int count=0;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//for adding a single item in the cart
		/*
		 * for(int i=0;i<products.size();i++) {
		 * 
		 * if(products.get(i).getText().contains(name)) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * ); } }
		 */
		List<String> nameList = Arrays.asList(names);
		
		//for adding multiple items in the cart
		for(int i=0;i<products.size();i++) {
			
			
			String[] text = products.get(i).getText().split("-");
			String finalText = text[0].trim();
			
			if(nameList.contains(finalText)) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(count==names.length)
				{
					break;
				}
			}
			
				
		}
		
		

	}

}
