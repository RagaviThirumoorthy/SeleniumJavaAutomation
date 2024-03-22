package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//span[text()='Total']/following-sibling::span")
	WebElement totalPrice;
	
	@FindBy(css=".totalRow .btn-primary")
	WebElement checkoutBtn;
	
	By cartProductsBy = By.cssSelector(".cartSection h3");
	
	public CartPage(WebDriver driver) {
		super(driver);	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productName) {
		
		waitForElementToAppear(cartProductsBy);
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage checkOut() {
		System.out.println(totalPrice.getText());
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}

}
