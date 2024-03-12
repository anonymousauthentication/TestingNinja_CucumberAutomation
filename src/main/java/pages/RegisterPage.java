package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-firstname")
	private WebElement firstNameField;

	@FindBy(css = "input#input-lastname")
	private WebElement lastNameField;

	@FindBy(css = "input#input-email")
	private WebElement emailField;

	@FindBy(css = "input#input-telephone")
	private WebElement telephoneField;

	@FindBy(css = "input#input-password")
	private WebElement passwordField;

	@FindBy(css = "input#input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(css = "input[name=\"agree\"]")
	private WebElement privacyPolicy;

	@FindBy(css ="input[type=\"submit\"]")
	private WebElement continueButton;

	@FindBy(css = "label[class=\"radio-inline\"] input[value=\"1\"]")
	private WebElement yesToNewsLetter;

	@FindBy(css = "div[class*=\"alert-dismissible\"]")
	private WebElement duplicateEmailError;

	@FindBy(css = "input[id=\"input-firstname\"]~div")
	private WebElement firstnameWarning;

	@FindBy(css = "div[class*=\"alert-dismissible\"]")
	private WebElement privacyPolicuWarning;

	@FindBy(css = "input[id=\"input-lastname\"]~div")
	private WebElement lastNameWarning;

	@FindBy(css = "input[id=\"input-email\"]~div")
	private WebElement emailWarning;

	@FindBy(css = "input[id=\"input-telephone\"]~div")
	private WebElement telephoneWarning;

	@FindBy(css = "input[id=\"input-password\"]~div")
	private WebElement passwordWarning;

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enteremail(String email) {
		emailField.sendKeys(email);
	}

	public void enterTelephoneNo(String telephoneNo) {
		telephoneField.sendKeys(telephoneNo);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
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

	public String getduplicateEmailError() {
		return duplicateEmailError.getText();
	}

	public Boolean getPrivacyPolicuWarning() {
		return privacyPolicuWarning.isDisplayed();
	}

	public String getFirstnameWarning() {
		return firstnameWarning.getText();
	}

	public String getLastnameWarning() {
		return lastNameWarning.getText();
	}

	public String getEmailWarning() {
		return emailWarning.getText();
	}

	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}

	public String getPasswordWarning() {
		return passwordWarning.getText();
	}

}
