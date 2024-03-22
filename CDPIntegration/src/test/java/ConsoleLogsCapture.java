import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		//listeners - OnTestFailure
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		Logs logs =  driver.manage().logs();
		LogEntries entry = logs.get(LogType.BROWSER);
		List<LogEntry> entries= entry.getAll();
		for(LogEntry logentry : entries) {
			System.out.println(logentry.getMessage());
		}
		
	}

}
