package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(css="input[type=\"submit\"]")
	private WebElement submitButton;
	
	@FindBy(css="div[class*=\"dismissible\"]")
	private WebElement loginWarningMesssage;
	
	public void enterEmailAddress(String email) {
		elementUtils.typeTextIntoElement(emailField, 30, email);
	}
	
	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, 30, password);
	}
	
	public MyAccountPage clickSubmitButton() {
		elementUtils.clickOnElement(submitButton, 30);
		return new MyAccountPage(driver); 
	}
	
	public String loginWarningMesssage() {
     return elementUtils.getTextFromElement(loginWarningMesssage, 30);

	}
}
