package stepdefinition;

import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Login {

	WebDriver driver;

	@Given("User have navigate to login page")
	public void user_have_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[contains(@title,\"My Account\")]")).click();
		driver.findElement(By.linkText("Login")).click();
	}

	@When("User has enter valid email address {string}")
	public void user_has_enter_valid_email_address(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@When("User has enter valid passsword {string}")
	public void user_has_enter_valid_passsword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	@Then("User should get successfully login")
	public void user_should_get_successfully_login() {
		boolean b = driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		Assert.assertTrue(b);
	}

	@When("User have enter invalid email")
	public void user_have_enter_invalid_email() {
		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	}

	@When("User have enter invalid password {string}")
	public void user_have_enter_invalid_password(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User has enter invalid passsword {string}")
	public void user_has_enter_invalid_passsword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@When("User dont enter any thing in input field")
	public void user_dont_enter_any_thing_in_input_field() {
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
	}
	
	public String getEmailWithTimeStamp() {
		Date date = new Date();
	    return	"manoharkantjoshi@"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
