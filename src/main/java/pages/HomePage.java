package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@title,\"Account\")]")
	private WebElement myAccount;
	
	@FindBy(css="a[href*=\"account/login\"]")
	private WebElement login;
	
	@FindBy(css="a[href*=\"account/register\"]")
	private WebElement register;
	
	@FindBy(css="input[name=\"search\"]")
	private WebElement searchBox; 
	
	@FindBy(css="i[class*=\"search\"]")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public LoginPage clickOnLogin() {
		login.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		register.click();
		return new RegisterPage(driver);
	}
	
	public void enterIntoSearchBox(String ProductName) {
		searchBox.sendKeys(ProductName);
	}

	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return   new SearchResultPage(driver);
	}
}