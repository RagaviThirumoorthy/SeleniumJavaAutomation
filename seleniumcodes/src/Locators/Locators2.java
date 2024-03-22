package Locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Ragavi";
		
		//chrome driver
		/*
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		//edge driver
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Login using right credentials with hardcoded password
		/*
		 * driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 * driver.findElement(By.id("inputUsername")).sendKeys(name);
		 * driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		 */
				
		//Login using right credentials with dynamic extracted password
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		
		//Validating the greeting message with Assert
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		
		//Logout using text based Xpath
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] pwdArray1 = passwordText.split("'");
		//pwdArray1[0] = "Please use temporary password "
		//pwdArray1[1] = "rahulshettyacademy' to Login."
		String[] pwdArray2 = pwdArray1[1].split("'");
		//pwdArray2[0] = "rahulshettyacademy"
		//pwdArray2[1] = " to Login."
		String password  = pwdArray2[0];
		System.out.println(password);
		
		return password;
		
	}

}
