package selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pageobjects.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\selenium\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")==null ? prop.getProperty("browser") : System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome")) {
			ChromeOptions option = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")){ 
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}else if(browserName.contains("edge")) {
			driver = new EdgeDriver();
			System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		}else if(browserName.contains("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.msedge.driver", "./drivers/geckodriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	public List<HashMap<String, String>> getJsonDatatoMap(String filePath) throws IOException {
		//Convert Json data to String
		String stringContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//Jackson Databind dependency added
		//convert string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>>  data = mapper.readValue(stringContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCase,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/reports/" + testCase + ".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir") + "/reports/" + testCase + ".png";
	}
	
	
}
