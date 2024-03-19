package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
    private ElementUtils elementUtils;
	public RegisterPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
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
		elementUtils.typeTextIntoElement(firstNameField, 0, firstName);
	}

	public void enterLastName(String lastName) {
		elementUtils.typeTextIntoElement(lastNameField, 0, lastName);
	}

	public void enteremail(String email) {
		elementUtils.typeTextIntoElement(emailField, 0, email);
	}

	public void enterTelephoneNo(String telephoneNo) {
		elementUtils.typeTextIntoElement(telephoneField, 0, telephoneNo);
	}

	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, 0, password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		elementUtils.typeTextIntoElement(confirmPasswordField, 0, confirmPassword);
	}

	public void privacyPolicyClick() {
		elementUtils.clickOnElement(privacyPolicy, 0);
	}

	public void continueButtonClick() {
		elementUtils.clickOnElement(continueButton, 0);
	}

	public void clickyesToNewsLetter() {
		elementUtils.clickOnElement(yesToNewsLetter, 0);
	}

	public String getduplicateEmailError() {
		return elementUtils.getTextFromElement(duplicateEmailError, 0);
	}

	public Boolean getPrivacyPolicuWarning() {
		return elementUtils.displayStatusOfElement(privacyPolicuWarning, 0);
	}

	public String getFirstnameWarning() {
		return elementUtils.getTextFromElement(firstnameWarning, 0);
	}

	public String getLastnameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, 0);
	}

	public String getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarning, 0);
	}

	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, 0);
	}

	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, 0);
	}

}
