package stepdefinition;

import io.cucumber.java.en.*;

public class Search {
	@Given("open Application url")
	public void open_application_url() {
		
	}

	@When("User enters valid product name {string}")
	public void user_enters_valid_product_name(String string) {
		
	}

	@When("Click on search button")
	public void click_on_search_button() {
		
	}

	@Then("Valid product should get displayed in search result")
	public void valid_product_should_get_displayed_in_search_result() {
		
	}

	@When("User enters the non-existing product in search box {string}")
	public void user_enters_the_non_existing_product_in_search_box(String string) {
		
	}

	@Then("Proper text information the user about no  product matching should be displayed.")
	public void proper_text_information_the_user_about_no_product_matching_should_be_displayed() {
		
	}

	@When("User dont enter any product in search box")
	public void user_dont_enter_any_product_in_search_box() {
		
	}
}
