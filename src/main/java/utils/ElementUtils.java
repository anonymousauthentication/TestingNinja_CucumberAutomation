package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, int durationInSecond) {
		WebElement webelement = waitForElement(element, durationInSecond);
		webelement.click();
	}

	public void typeTextIntoElement(WebElement element, long durationInSecond, String textToType) {

		WebElement webelement = waitForElement(element, durationInSecond);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToType);
	}

	public WebElement waitForElement(WebElement element, long durationInSecond) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void selectOptionInDropdown(WebElement element, String dropdownOprion, long durationInSecond) {
		WebElement webelement = waitForElement(element, durationInSecond);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropdownOprion);
	}

	public void acceptAlert(long durationInSecond) {
		Alert alert = waitForAlert(durationInSecond);
		alert.accept();
	}

	public void dismissAlert(long durationInSecond) {
		Alert alert = waitForAlert(durationInSecond);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationInSecond) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSecond) {

		WebElement webElement = waitForVisibility(element, durationInSecond);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisibility(WebElement element, long durationInSecond) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSecond) {
		WebElement webElement = waitForVisibility(element, durationInSecond);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("argument[0].click()", webElement);
	}
	
	public void javaScriptType(WebElement element, long durationInSecond, String stringToType) {
	WebElement webElement = waitForVisibility(element, durationInSecond);
	JavascriptExecutor jse = ((JavascriptExecutor) driver);
	jse.executeScript("argument[0].value='"+stringToType+"'", webElement);
	}
}
