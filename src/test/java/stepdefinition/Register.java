package stepdefinition;

import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	CommonUtils commonutils;

	@Given("User Navigate to Register Account Page")
	public void user_navigate_to_register_account_page() {
		DriverFactory driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickOnRegister();
	}

	@When("user enters below details into the fields")
	public void user_enters_below_details_into_the_fields(DataTable dataTable) {
	    commonutils = new CommonUtils();
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteremail(commonutils.getEmailWithTimeStamp());
		registerPage.enterTelephoneNo((dataMap.get("telephone")));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword((dataMap.get("confirmPassowrd")));
	}

	@When("user enters below details into the fields with duplicate email")
	public void user_enters_below_details_into_the_fields_with_duplicate_email(DataTable dataTable){
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteremail(dataMap.get("email"));
		registerPage.enterTelephoneNo((dataMap.get("telephone")));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword((dataMap.get("confirmPassowrd")));
	}

	@When("Selects privacy policy field")
	public void selects_privacy_policy_field() {
		registerPage.privacyPolicyClick();
	}

	@When("Clicks on continue button")
	public void clicks_on_continue_button() {
		registerPage.continueButtonClick();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		AccountSuccessPage accountSuccessPage= new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.getSuccessfulMessage(),
				"Your Account Has Been Created!");
	}

	@When("Selects Yes for newsletter")
	public void selects_yes_for_newsletter() {
		registerPage.clickyesToNewsLetter();
	}

	@When("User dont enter details into any field")
	public void user_dont_enter_details_into_any_field() {
      
	}

	@Then("Error validation message should come be displayed for all the mandetory field")
	public void error_validation_message_should_come_be_displayed_for_all_the_mandetory_field() {
		Assert.assertTrue(registerPage.getPrivacyPolicuWarning());
		Assert.assertEquals(registerPage.getFirstnameWarning(),"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLastnameWarning(),"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getEmailWarning(),"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(registerPage.getPasswordWarning(),"Password must be between 4 and 20 characters!");
	}

	@Then("Error should display for duplicate email address")
	public void error_should_display_for_duplicate_email_address() {
		Assert.assertTrue(registerPage.getduplicateEmailError().contains("Warning: E-Mail Address is already registered!"));
	}

}
