package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchResultPage {
	WebDriver driver;
    private ElementUtils elementUtils;
	public SearchResultPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement searchProduct;

	@FindBy(css = "h2~p")
	private WebElement errorForNoProduct;

	public Boolean searchproductPresent() {
 	   return elementUtils.displayStatusOfElement(searchProduct, 0);
	}

	public String errorForNoSearchProduct() {
		return elementUtils.getTextFromElement(errorForNoProduct, 0);
	}
}
