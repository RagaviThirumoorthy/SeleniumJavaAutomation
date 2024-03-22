package selenium.pageobjects;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractcomponents.AbstractComponent;

public class ProductsCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	// List<WebElement> products = driver.findElements(By.cssSelector("div h5 b"));
	@FindBy(css = "div h5 b")
	List<WebElement> products;

	By productsBy = By.cssSelector("div h5 b");
	By addTocartBy = By.cssSelector(".card-body button:last-of-type");
	By toastBy = By.id("toast-container");
	By spinnerBy = By.cssSelector("ngx-spinner.ng-star-inserted");
	
	public ProductsCatalogue(WebDriver driver) {
		//initialization code	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProducts() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getMatchedProduct(String productName) {
		WebElement prod = getProducts().stream().filter(s->s.getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prod.getText());
		return prod;
	}
	
	public CartPage addToCart(String productName) {
		WebElement prod = getMatchedProduct(productName);
		driver.findElement(with(addTocartBy).below(prod)).click();
		waitForElementToAppear(toastBy);
		waitForElementToDisappear(spinnerBy);
		return new CartPage(driver);
	}

}
