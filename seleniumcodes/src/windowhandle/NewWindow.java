package windowhandle;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> it = windowhandles.iterator();
        String parentId = it.next();
        String childId = it.next();
        
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        
        System.out.println(driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText());
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        
        driver.switchTo().window(parentId);
        
        WebElement name =  driver.findElement(By.name("name"));
        name.sendKeys(courseName);
        
        //Taking screenshot of webelement
        File src = name.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/img4.png");
        FileHandler.copy(src, dest);
        
        //Getting height and width of an element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        
	}

}
