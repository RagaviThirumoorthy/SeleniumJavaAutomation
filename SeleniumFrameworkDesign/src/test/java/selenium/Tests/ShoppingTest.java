package selenium.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.TestComponents.BaseTest;
import selenium.abstractcomponents.AbstractComponent;
import selenium.pageobjects.CartPage;
import selenium.pageobjects.CheckoutPage;
import selenium.pageobjects.ConfirmationPage;
import selenium.pageobjects.LoginPage;
import selenium.pageobjects.OrdersPage;
import selenium.pageobjects.ProductsCatalogue;

public class ShoppingTest extends BaseTest{

	String productName = "IPHONE 13 PRO";
	String countryName = "India";
	
	@Test(dataProvider = "getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException {

		//Access LoginPage class
		ProductsCatalogue catalogue = loginPage.loginApplication(input.get("email"),input.get("password"));
				 
		//Select the product and add it to cart
		CartPage cartPage = catalogue.addToCart(input.get("productName"));
		
		//Verify whether the product is added in cart
		cartPage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		
		//Proceed to checkout
		CheckoutPage checkoutPage = cartPage.checkOut();
		
		//Fill up details in checkout page and place the order
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmPage = checkoutPage.submit();
		
		//Confirming the order placed
		System.out.println(confirmPage.getconfirmMsg());
		Assert.assertTrue(confirmPage.getconfirmMsg().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = "submitOrder")
	public void orderHistoryTest() {
		
		ProductsCatalogue catalogue = loginPage.loginApplication("ragavi@gmail.com","KaviKrrish*29");
		OrdersPage ordersPage = catalogue.goToOrdersPage();
		Boolean match = ordersPage.verifyOrderDisplay(productName);
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
 	}
	
	
	
			
	
	
	
	
//	@DataProvider
//	public Object[][] getData() {
	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email", "ragavi@gmail.com");
//	map1.put("password", "KaviKrrish*29");
//	map1.put("productName", "IPHONE 13 PRO");
//	
//	HashMap<String, String> map2 = new HashMap<String, String>();
//	map2.put("email", "kavya2712@gmail.com");
//	map2.put("password", "Kavya*27");
//	map2.put("productName", "ZARA COAT 3");
//		return new Object[][]{{"ragavi@gmail.com","KaviKrrish*29","IPHONE 13 PRO"},{"kavya2712@gmail.com","Kavya*27","ZARA COAT 3"}};
//	}

}
