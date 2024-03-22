import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;

public class BlockNetworkRequests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			
		devTools.send(Network.setBlockedURLs(List.of("*.jpg","*.css")));
		
		Long startTime = System.currentTimeMillis();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ethnic wear",Keys.ENTER);
		Long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
		
		//Before blocking = 19921
		//After blocking = 9464
	}

}