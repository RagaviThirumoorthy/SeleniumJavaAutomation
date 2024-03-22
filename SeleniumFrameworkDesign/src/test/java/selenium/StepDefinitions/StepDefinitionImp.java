package selenium.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.TestComponents.BaseTest;
import selenium.pageobjects.CartPage;
import selenium.pageobjects.CheckoutPage;
import selenium.pageobjects.ConfirmationPage;
import selenium.pageobjects.LoginPage;
import selenium.pageobjects.ProductsCatalogue;

public class StepDefinitionImp extends BaseTest{
	
	public LoginPage loginPage;
	public ProductsCatalogue catalogue;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public ConfirmationPage confirmPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_Page() throws IOException{
		loginPage = launchApplication();
	}
	
	@Given("^login application with (.+) and (.+)$")
	public void Login_application_username_password(String email,String password) {
		catalogue = loginPage.loginApplication(email,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_toCart(String productName) {
		cartPage = catalogue.addToCart(productName);
	}
	
	@When("^Checkout the product (.+) and submit the order$")
	public void checkout_product_submit_order(String productName) {
		cartPage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		//Proceed to checkout
		checkoutPage = cartPage.checkOut();
		
		//Fill up details in checkout page and place the order
		checkoutPage.selectCountry("India");
		confirmPage = checkoutPage.submit();
	}
	
	@Then("{string} message is displayed")
	public void confirmation_message_displayed(String string) {
		Assert.assertTrue(confirmPage.getconfirmMsg().equalsIgnoreCase(string));
		driver.quit();
	}
	
	@Then("Error {string} is displayed")
	public void error_message_is_displayed(String msg) {
		String errorMsg = loginPage.getErrorMsg();
		Assert.assertEquals(msg, errorMsg);
		driver.quit();
	}
}
