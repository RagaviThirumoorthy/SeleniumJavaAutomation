import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//Emulate network speed
		devTools.send(Network.emulateNetworkConditions(true, 0, 1000, 1000, Optional.of(ConnectionType.CELLULAR4G)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
//			System.out.println(loadingFailed.getBlockedReason());
		});
		Long startTime = System.currentTimeMillis();
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h1[@class='default-ltr-cache-jpuyb8 e9eyrqp8']")).getText());
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		//before emulate speed = 2160
		//after emulate speed = 174224
	}

}
