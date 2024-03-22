package eteUIautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormSubmission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Filling out form
		driver.findElement(By.name("name")).sendKeys("Ragavi");
		driver.findElement(By.name("email")).sendKeys("ragavi2711@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ragavi*27");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dd = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(dd);
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("27/01/2000");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		//Printing text
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}

}
