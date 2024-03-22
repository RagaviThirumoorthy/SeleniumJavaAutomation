package webdriverScope;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Select any checkbox
		driver.findElement(By.id("checkBoxOption2")).click();	//driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		
		//2. Grab the label of the selected checkbox
		String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();  //driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(label);
		
		//3. Select the 'grabbed label' as option in the dropdown
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText(label);
		/*
		 * List<WebElement> options = dd.getOptions(); 
		 * for(WebElement option : options)
		 * { if(option.getText().contains(label)) { option.click(); break; } }
		 */
		
		//4. Enter the 'grabbed label' in Name Input and click Alert
		driver.findElement(By.id("name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		
		//5. Verify whether the label is present in alert message or not
		System.out.println(driver.switchTo().alert().getText());
		String alertMsg = driver.switchTo().alert().getText();
		if(alertMsg.contains(label)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		/*
		 * String splittedText = alertMsg.split(",")[0].split(" ")[1];
		 * if(splittedText.contains(label)){ System.out.println("PASS"); }else {
		 * System.out.println("FAIL"); }
		 */
		driver.switchTo().alert().accept();		
	}

}
