package stepdefinition;

import io.cucumber.java.en.*;
import java.util.Date;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;

public class Register {
	WebDriver driver;

	@Given("User Navigate to Register Account Page")
	public void user_navigate_to_register_account_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();
	}

	@When("user enters below details into the fields")
	public void user_enters_below_details_into_the_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.cssSelector("input#input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(getEmailWithTimeStamp());
		driver.findElement(By.cssSelector("input[name=\"telephone\"]")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.cssSelector("input[id=\"input-password\"]")).sendKeys(dataMap.get("password"));
		driver.findElement(By.cssSelector("input[id=\"input-confirm\"]")).sendKeys(dataMap.get("confirmPassowrd"));
	}

	@When("user enters below details into the fields with duplicate email")
	public void user_enters_below_details_into_the_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.cssSelector("input#input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(dataMap.get("email"));
		driver.findElement(By.cssSelector("input[name=\"telephone\"]")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.cssSelector("input[id=\"input-password\"]")).sendKeys(dataMap.get("password"));
		driver.findElement(By.cssSelector("input[id=\"input-confirm\"]")).sendKeys(dataMap.get("confirmPassowrd"));
	}

	@When("Selects privacy policy field")
	public void selects_privacy_policy_field() {
		driver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
	}

	@When("Clicks on continue button")
	public void clicks_on_continue_button() {
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id=\"content\"] h1")).getText(),
				"Your Account Has Been Created!");
	}

	@When("Selects Yes for newsletter")
	public void selects_yes_for_newsletter() {
		driver.findElement(By.cssSelector("label[class=\"radio-inline\"] input[value=\"1\"]")).click();
	}

	@When("User dont enter details into any field")
	public void user_dont_enter_details_into_any_field() {
     
	}

	@Then("Error validation message should come be displayed for all the mandetory field")
	public void error_validation_message_should_come_be_displayed_for_all_the_mandetory_field() {
		Assert.assertTrue(driver.findElement(By.cssSelector("div[class*=\"alert-dismissible\"]")).isDisplayed());
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText(),
				"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText(),
				"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText(),
				"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText(),
				"Password must be between 4 and 20 characters!");
	}

	@Then("Error should display for duplicate email address")
	public void error_should_display_for_duplicate_email_address() {
		Assert.assertTrue(driver.findElement(By.cssSelector("div[class*=\"alert-dismissible\"]")).getText()
				.contains("Warning: E-Mail Address is already registered!"));	
	}

	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "manoharkantjoshi" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}
}
