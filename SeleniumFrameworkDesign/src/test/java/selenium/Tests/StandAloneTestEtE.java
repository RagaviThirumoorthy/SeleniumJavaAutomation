package selenium.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestEtE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
				
		//Login
		driver.findElement(By.id("userEmail")).sendKeys("ragavi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("KaviKrrish*29");
		driver.findElement(By.id("login")).click();

//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".card"));
//		//System.out.println(driver.findElement(By.cssSelector("div h5 b")).getText()); 
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div h5 b"))); 
//		WebElement prod = products.stream().filter(s->s.findElement(By.cssSelector("div h5 b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		System.out.println(prod.getText());
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 
		//Select the product and add it to cart
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div h5 b")));
		List<WebElement> products = driver.findElements(By.cssSelector("div h5 b"));
		WebElement prod = products.stream().filter(s->s.getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prod.getText());
		driver.findElement(with(By.cssSelector(".card-body button:last-of-type")).below(prod)).click();
		
		//Verify whether the product is added in cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner.ng-star-inserted")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cartSection h3")));
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		//Proceed to checkout
		System.out.println(driver.findElement(By.xpath("//span[text()='Total']/following-sibling::span")).getText());
		driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
		
		//Fill up details and place the order
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> options = driver.findElements(By.cssSelector(".list-group-item span"));
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		options.stream().filter(option->option.getText().equals("India")).findFirst().ifPresent(WebElement::click);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btnn.action__submit")));
		driver.findElement(By.cssSelector("a.btnn.action__submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.hero-primary")));
		System.out.println(driver.findElement(By.cssSelector("h1.hero-primary")).getText());
		
	}

}
