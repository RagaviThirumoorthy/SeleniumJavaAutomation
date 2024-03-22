package uploadDownloadFunctionalities.uploadDownloadFunctions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class uploadDownload {
	
	
	public void fileUploadDownload() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		String filePath = "C:\\Users\\USER\\Downloads\\download.xlsx";
		String fruit = "Apple";
		String colName= "price";
		int price = 375;
		int rowIndex;
		int colIndex;
		
		//download
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadButton")));
		driver.findElement(By.id("downloadButton")).click();
		
		//edit excel
		EditExcelData editExcel = new EditExcelData();
		editExcel.getIndex(filePath, fruit, price);
		rowIndex = editExcel.getRowIndex(filePath, fruit);
		colIndex = editExcel.getColumnIndex(filePath, colName);
		Assert.assertTrue(editExcel.updateExcel(filePath, rowIndex, colIndex, "400"));
		
		//upload
		WebElement upload = driver.findElement(By.id("fileinput"));
		upload.sendKeys(filePath);
		
		//Wait for success message,Verify whether the excel is updated and wait for message to appear and disappear
		By toast = By.cssSelector("div.Toastify__toast-body div:nth-child(2)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
		String message = driver.findElement(toast).getText();
		System.out.println(message);
		Assert.assertEquals("Updated Excel Data Successfully.",message);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toast));
		
		//verify the data in table
		String priceColumn= driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		List<WebElement> fruitNames = driver.findElements(By.xpath("//div[@role='row']/div[@id='cell-2-undefined']/div"));
		for(WebElement fruitName: fruitNames) {
			if(fruitName.getText().contains(fruit)) {
				WebElement elePrice = fruitName.findElement(By.xpath("parent::div/following-sibling::div[@id='cell-"+priceColumn+"-undefined']/div"));
				System.out.println("Price of "+fruit+" is "+elePrice.getText());
			}
		}
		
		
//		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruit+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
//		System.out.println(actualPrice);
//		Assert.assertEquals(updatedValue, actualPrice);

	}
}
