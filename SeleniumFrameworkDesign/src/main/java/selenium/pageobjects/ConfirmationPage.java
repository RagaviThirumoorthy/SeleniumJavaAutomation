package selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.abstractcomponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="h1.hero-primary")
	WebElement confirmMsg;
	
	By confirmMsgBy = By.cssSelector("h1.hero-primary");
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getconfirmMsg() {
		waitForElementToAppear(confirmMsgBy);
		return confirmMsg.getText();
	}

}
