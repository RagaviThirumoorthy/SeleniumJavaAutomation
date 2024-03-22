package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launching Chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.nadijothidamlife.com/home");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.quit();
		
		//Launching Firefox browser
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver geckodriver = new FirefoxDriver();
		
		geckodriver.get("https://www.nadijothidamlife.com/home");
		System.out.println(geckodriver.getTitle());
		System.out.println(geckodriver.getCurrentUrl());
		geckodriver.quit();
		
		//Launching Edge browser
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		WebDriver edgedriver = new EdgeDriver();
		
		edgedriver.get("https://www.nadijothidamlife.com/home");
		System.out.println(edgedriver.getTitle());
		System.out.println(edgedriver.getCurrentUrl());
		edgedriver.quit();
		
		
	}

}
