package selenium.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import selenium.TestComponents.BaseTest;
import selenium.pageobjects.CartPage;
import selenium.pageobjects.ProductsCatalogue;

public class ErrorValidations extends BaseTest {
	
	String productName = "IPHONE 13 PRO";
	
	@Test(groups= {"Error"})
	public void loginErrorValidation() {
		
		loginPage.loginApplication("ragavi@gmail.com","KaviKrrish*");
		String errorMsg = loginPage.getErrorMsg();
		Assert.assertEquals("Incorrect email", errorMsg);
	}
	
	@Test(retryAnalyzer = selenium.TestComponents.Retry.class,groups= {"Error"})
	public void prodErrorValidation() {
		
		ProductsCatalogue catalogue = loginPage.loginApplication("ragavi@gmail.com","KaviKrrish*29");
		CartPage cartPage = catalogue.addToCart(productName);
		cartPage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("IPHONE 14 PRO");
		Assert.assertTrue(match);
	}

}
