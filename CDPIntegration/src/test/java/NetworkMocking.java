import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v120.network.model.Request;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Optional<List<RequestPattern>> patterns =  Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request->
		{
			Request req = request.getRequest();
			if(req.getUrl().contains("shetty")) {
				String mockedURL = req.getUrl().replace("=shetty", "=BadGuy");
				
				System.out.println(mockedURL);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockedURL),
						Optional.of(req.getMethod()),Optional.empty(),Optional.empty(),Optional.empty()));
			}else {
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(req.getUrl()),
						Optional.of(req.getMethod()),Optional.empty(),Optional.empty(),Optional.empty()));
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
