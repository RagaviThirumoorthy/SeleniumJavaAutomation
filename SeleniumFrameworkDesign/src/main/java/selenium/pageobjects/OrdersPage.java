package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractcomponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	public WebDriver driver;
	
	@FindBy(css = "tr td:nth-Child(3)")
	List<WebElement> products;
	
	By productsBy = By.cssSelector("tr td:nth-Child(3)");

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOrderDisplay(String productName) {

		waitForElementToAppear(productsBy);
		Boolean match =products.stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));
		return match;
	}

}
