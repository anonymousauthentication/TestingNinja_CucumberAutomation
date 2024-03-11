package stepdefinition;

import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	LoginPage loginPage;

	@Given("User have navigate to login page")
	public void user_have_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}

	@When("User has enter valid email address {string}")
	public void user_has_enter_valid_email_address(String email) {
	    loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
	}

	@When("User has enter valid passsword {string}")
	public void user_has_enter_valid_passsword(String password) {
		loginPage.enterPassword(password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPage.clickSubmitButton();
	}

	@Then("User should get successfully login")
	public void user_should_get_successfully_login() {
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.statusofeditAccountInformation());
	}

	@When("User have enter invalid email")
	public void user_have_enter_invalid_email() {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress((CommonUtils.getEmailWithTimeStamp()));
	}

	@When("User have enter invalid password {string}")
	public void user_have_enter_invalid_password(String password) {
		loginPage.enterPassword(password);
	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
		Assert.assertTrue(loginPage.loginWarningMesssage()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User has enter invalid passsword {string}")
	public void user_has_enter_invalid_passsword(String password) {
		loginPage.enterPassword(password);
	}

	@When("User dont enter any thing in input field")
	public void user_dont_enter_any_thing_in_input_field() {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");
		loginPage.enterPassword("");
	}
	
	
}
