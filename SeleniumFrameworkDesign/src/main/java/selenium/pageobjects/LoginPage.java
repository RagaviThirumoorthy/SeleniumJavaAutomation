package selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent{

	WebDriver driver;
	
	//PageFactory Web Elements
	@FindBy(id="userEmail")
	WebElement email;
		
	@FindBy(id="userPassword")
	WebElement password;
		
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement errorToast;
	
	By errorBy = By.cssSelector(".ng-trigger-flyInOut");
	
	// Constructor
	public LoginPage(WebDriver driver) {
		//initialization code	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Page Methods
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductsCatalogue loginApplication(String emailId,String pass) {
		email.clear();
		password.clear();
		email.sendKeys(emailId);
		password.sendKeys(pass);
		login.click();
		return new ProductsCatalogue(driver);
	}
	
	public String getErrorMsg() {
		waitForElementToAppear(errorBy);
		return errorToast.getText();
	}
	
}
