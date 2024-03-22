import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class WindowAuthPopup {
	
	public void handleWindowPopup() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
	}
	
}
