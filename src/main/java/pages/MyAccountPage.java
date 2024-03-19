package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class MyAccountPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	public MyAccountPage(WebDriver driver) {
		 elementUtils =  new ElementUtils(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInformation;
	
	public boolean statusofeditAccountInformation() {
		return	elementUtils.displayStatusOfElement(editAccountInformation, CommonUtils.EXPLICITE_WAIT_TIME);
	}
}
