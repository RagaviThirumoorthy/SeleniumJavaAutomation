package SeleniumTraining.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class EdgeBrowser {
	
	@Test
	public void edgeTest() throws MalformedURLException, URISyntaxException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("MicrosoftEdge");
		
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.102:4444").toURL(),caps);
		driver.get("https://www.nadijothidamlife.com/");
		System.out.println(driver.getTitle());
		//driver.quit();
	}

}