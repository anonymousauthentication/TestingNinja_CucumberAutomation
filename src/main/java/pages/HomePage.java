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
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnRegister() {
		register.click();
	}
	
	public void enterIntoSearchBox(String ProductName) {
		searchBox.sendKeys(ProductName);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}
}