package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
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
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public MyAccountPage clickSubmitButton() {
		submitButton.click();
		return new MyAccountPage(driver); 
	}
	
	public String loginWarningMesssage() {
		return loginWarningMesssage.getText();
	}
}
