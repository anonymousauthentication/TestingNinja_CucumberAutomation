package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@title,\"Account\")]")
	private WebElement myAccount;

	@FindBy(css = "a[href*=\"account/login\"]")
	private WebElement login;

	@FindBy(css = "a[href*=\"account/register\"]")
	private WebElement register;

	@FindBy(css = "input[name=\"search\"]")
	private WebElement searchBox;

	@FindBy(css = "i[class*=\"search\"]")
	private WebElement searchButton;

	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccount, CommonUtils.EXPLICITE_WAIT_TIME);
	}

	public LoginPage clickOnLogin() {
		elementUtils.clickOnElement(login, CommonUtils.EXPLICITE_WAIT_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegister() {
		elementUtils.clickOnElement(register, CommonUtils.EXPLICITE_WAIT_TIME);
		return new RegisterPage(driver);
	}

	public void enterIntoSearchBox(String ProductName) {
		elementUtils.typeTextIntoElement(searchBox, CommonUtils.EXPLICITE_WAIT_TIME, ProductName);
	}

	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICITE_WAIT_TIME);
		return new SearchResultPage(driver);
	}
}