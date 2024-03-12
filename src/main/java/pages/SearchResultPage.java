package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement searchProduct;

	@FindBy(css = "h2~p")
	private WebElement errorForNoProduct;

	public Boolean searchproductPresent() {
		return searchProduct.isDisplayed();
	}

	public String errorForNoSearchProduct() {
		return errorForNoProduct.getText();
	}
}
