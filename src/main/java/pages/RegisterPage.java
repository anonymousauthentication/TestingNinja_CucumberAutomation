package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#input-firstname")
	private WebElement firstNameField;
	
	@FindBy(css="input#input-lastname")
	private WebElement lastNameField;
	
	@FindBy(css="input#input-email")
	private WebElement emailField;
	
	@FindBy(css="input#input-telephone")
	private WebElement telephoneField;
	
	@FindBy(css="input#input-password")
	private WebElement passwordField;
	
	@FindBy(css="input#input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(css="input[name=\"agree\"]")
	private WebElement privacyPolicy;
	
	@FindBy(css="input[name=\"submit\"]")
	private WebElement continueButton;
	
	@FindBy(css="label[class=\"radio-inline\"] input[value=\"1\"]")
    private WebElement yesToNewsLetter;
	
	@FindBy(css="div[class*=\"alert-dismissible\"]")
	private WebElement duplicateEmailError;
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enteremail(String email) {
		telephoneField.sendKeys(email);
	}
	
	public void enterTelephoneNo(String telephoneNo) {
		telephoneField.sendKeys(telephoneNo);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		emailField.sendKeys(confirmPassword);
	}
	
	public void privacyPolicyClick() {
		privacyPolicy.click();
	}
	
	public void continueButtonClick() {
		continueButton.click();
	}
	
	public void clickyesToNewsLetter() {
		yesToNewsLetter.click();
	}
	
	public String  getduplicateEmailError() {
		return duplicateEmailError.getText();
	}
	
	
}
