import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AutoITFileHandling {
	
	public void fileAutoIT() throws IOException, InterruptedException {
		
		//Set default download directory
		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		//File upload
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\USER\\Documents\\AutoIT\\fileupload.exe");
		//File convert
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		//file download
		driver.findElement(By.id("pickfiles")).click();
		Runtime.getRuntime().exec("C:\\Users\\USER\\Documents\\AutoIT\\filedownload.exe");
		//Verify file downloaded
		Thread.sleep(5000);
		File file = new File(downloadPath+"/Rose.pdf");
		if(file.exists()) {
			System.out.println("File found");
			Assert.assertTrue(file.exists());
			file.delete();
			System.out.println("file deleted");
		}
		
	}

}
