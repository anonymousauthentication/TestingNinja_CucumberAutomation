package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountSuccessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public AccountSuccessPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[id=\"content\"] h1")
	private WebElement accountSuccessfulMessage;
	
	public String getSuccessfulMessage() {
		return elementUtils.getTextFromElement(accountSuccessfulMessage, 30);
	}
}
