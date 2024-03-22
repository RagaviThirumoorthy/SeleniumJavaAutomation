import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class CDPCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver  = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//Device metrics parameters 
		HashMap<String,Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", 430);
		deviceMetrics.put("height", 932);
		deviceMetrics.put("deviceScaleFactor",100);
		deviceMetrics.put("mobile", true);
		
		//Execute CDP command then get access to chrome dev tools
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[data-toggle='collapse']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
	}

}
