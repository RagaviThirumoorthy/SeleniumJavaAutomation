package synchronization;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		loginPage(driver,w);
		addItemstoCart(driver,w);
	}
	
	public static void loginPage(WebDriver driver, WebDriverWait w) {
		
		String username = driver.findElement(By.xpath("(//p/b/i)[1]")).getText();
		String password = driver.findElement(By.xpath("(//p/b/i)[2]")).getText();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}
	
	public static void addItemstoCart(WebDriver driver, WebDriverWait w){
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.btn.btn-info")));
		List<WebElement> products = driver.findElements(By.cssSelector("button.btn.btn-info"));
		for(WebElement product:products) {
			product.click();
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='text-right']/h3/strong")));
		System.out.println("Total price is: "+driver.findElement(By.xpath("//td[@class='text-right']/h3/strong")).getText());
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		driver.findElement(By.id("country")).sendKeys("Ind");
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggestions']/ul/li/a")));
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));
		for(WebElement country: countries) {
			if(country.getText().contains("India")) {
				w.until(ExpectedConditions.visibilityOf(country));
				country.click();
				break;
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='checkbox2']")));
		driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
	}

}
