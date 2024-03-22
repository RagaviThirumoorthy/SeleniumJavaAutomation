import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class LoginTestCase {
	
	public void loginTest() throws IOException {
		
		dataDriven dD = new dataDriven();
		ArrayList<String> arrayList = dD.getData("Purchase");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
				
		//Login
		driver.findElement(By.id("userEmail")).sendKeys(arrayList.get(1));
		driver.findElement(By.id("userPassword")).sendKeys(arrayList.get(2));
		driver.findElement(By.id("login")).click();
		
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.get(2));
		System.out.println(arrayList.get(3));
		System.out.println(arrayList.get(4));
		
	}

}
