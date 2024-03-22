package screenshot;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();			//If its WebDriver, then you need to cast the driver object with 'TakesScreenshot'
		//ChromeDriver driver  = new ChromeDriver();	//If its chromedriver, can directly use driver.getScreenshotAs(OutputType.FILE)
		//Maximize browser
		driver.manage().window().maximize();
		//Delete cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		
		driver.get("https://www.nadijothidamlife.com/");
		
		//Screenshot of page
		File pageSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File pageDest = new File("./snaps/img1.png");
		FileHandler.copy(pageSrc, pageDest);
		
		//Screenshot of section
		File secSrc = driver.findElement(By.xpath("(//div[@class='LS81yb VICjCf j5pSsc db35Fc'])[2]")).getScreenshotAs(OutputType.FILE);
		File secDest = new File("./snaps/img2.png");
		FileHandler.copy(secSrc, secDest);
		
		//Screenshot of WebElement 
		File eleSrc = driver.findElement(By.id("yDmH0d")).getScreenshotAs(OutputType.FILE);
		File eleDest = new File("./snaps/img3.png");
		FileHandler.copy(eleSrc, eleDest);
	}

}
