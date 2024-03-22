package windowhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
		/*
		 * driver.switchTo().frame("frame-top");
		 * driver.switchTo().frame("frame-middle");
		 */
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		
		driver.quit();
	}

}
