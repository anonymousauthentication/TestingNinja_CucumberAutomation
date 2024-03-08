package stepdefinition;

import io.cucumber.java.en.*;

public class Login {

	@Given("User have navigate to login page")
	public void user_have_navigate_to_login_page() {
	   
	}

	@When("User has enter valid email address {string}")
	public void user_has_enter_valid_email_address(String string) {
	    
	}

	@When("User has enter valid passsword {string}")
	public void user_has_enter_valid_passsword(String string) {
	    
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
	    
	}

	@Then("User should get successfully login")
	public void user_should_get_successfully_login() {
	   
	}


	@When("User have enter invalid email {string}")
	public void user_have_enter_invalid_email(String string) {
	  
	}

	@When("User have enter invalid password {string}")
	public void user_have_enter_invalid_password(String string) {
	    
	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
	    
	}

	@When("User has enter invalid passsword {string}")
	public void user_has_enter_invalid_passsword(String string) {
	   
	}

	@When("User dont enter any thing in input field")
	public void user_dont_enter_any_thing_in_input_field() {
	   
	}
}
