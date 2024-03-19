package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
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
		elementUtils.typeTextIntoElement(emailField, CommonUtils.EXPLICITE_WAIT_TIME, email);
	}
	
	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, CommonUtils.EXPLICITE_WAIT_TIME, password);
	}
	
	public MyAccountPage clickSubmitButton() {
		elementUtils.clickOnElement(submitButton, CommonUtils.EXPLICITE_WAIT_TIME);
		return new MyAccountPage(driver); 
	}
	
	public String loginWarningMesssage() {
     return elementUtils.getTextFromElement(loginWarningMesssage, CommonUtils.EXPLICITE_WAIT_TIME);

	}
}
