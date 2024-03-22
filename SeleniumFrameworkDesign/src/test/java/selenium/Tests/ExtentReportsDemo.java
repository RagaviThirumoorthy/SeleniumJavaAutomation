package selenium.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ExtentReportsDemo {
	
	ExtentReports extent ;
	
	@BeforeTest
	public void extentReport() {
		
		//Create report html file
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/index.html");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//Attaching the extent report to reporter
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ragavi");
	}
	
	@Test
	public void browserTest() {
		extent.createTest("Browser Test");
		ChromeDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
