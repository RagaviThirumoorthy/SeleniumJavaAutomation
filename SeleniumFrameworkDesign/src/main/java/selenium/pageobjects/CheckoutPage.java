package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver  driver;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".list-group-item span")
	List<WebElement> options;
	
	@FindBy(css="a.btnn.action__submit")
	WebElement submit;
	
	By resultsBy = By.cssSelector(".ta-results");
	By submitBy = By.cssSelector("a.btnn.action__submit");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String countryName) {
		country.sendKeys(countryName);
		waitForElementToAppear(resultsBy);
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		options.stream().filter(option->option.getText().equals("India")).findFirst().ifPresent(WebElement::click);
	}
	
	public ConfirmationPage submit() {
		waitForElementToAppear(submitBy);
		submit.click();
		return new ConfirmationPage(driver);
	}

}
