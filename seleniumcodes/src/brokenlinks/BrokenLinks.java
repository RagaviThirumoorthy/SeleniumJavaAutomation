package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Get all links from web elements
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		String url1 = footer.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String url2 = footer.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		//2. Get Response code from all links
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert s = new SoftAssert();
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			s.assertTrue(respCode<400, "The element "+link.getText()+" broken with "+respCode);  //If it sees less than 400, then it'll store the failure but not immediately stop your execution. It'll still continue after completing all your script.
			
			/*
			 * if(respCode>400) {
			 * System.out.println("The element "+link.getText()+" broken with "+respCode); }
			 */
		}
		s.assertAll(); //if it have stored any failures then ultimately this line will fail that script. If it do not store any failures then assertAll() will pass your script.
		
		//2. Get Response code from all links
		/*
		 * HttpsURLConnection conn = (HttpsURLConnection)new URL(url2).openConnection();
		 * conn.setRequestMethod("HEAD"); conn.connect(); int respCode =
		 * conn.getResponseCode(); System.out.println(respCode);
		 */
	}

}
