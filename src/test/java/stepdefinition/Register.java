package stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

public class Register {
	@Given("User Navigate to Register Account Page")
	public void user_navigate_to_register_account_page() {
	    
	}
	
	@When("user enters below details into the fields")
	public void user_enters_below_details_into_the_fields(DataTable dataTable) {
	 
	}

	@When("Selects privacy policy field")
	public void selects_privacy_policy_field() {
	   
	}

	@When("Clicks on continue button")
	public void clicks_on_continue_button() {
	   
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
	   
	}

	@When("Selects Yes for newsletter")
	public void selects_yes_for_newsletter() {
	   
	}

	@When("User dont enter details into any field")
	public void user_dont_enter_details_into_any_field() {
	    
	}

	@Then("Error validation message should come be displayed for all the mandetory field")
	public void error_validation_message_should_come_be_displayed_for_all_the_mandetory_field() {
	    
	}

	@Then("Error should display for duplicate email address")
	public void error_should_display_for_duplicate_email_address() {
	   
	}
}
