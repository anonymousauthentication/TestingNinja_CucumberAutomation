package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {

	WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultPage;

	@Given("open Application url")
	public void open_application_url() {
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product name {string}")
	public void user_enters_valid_product_name(String productName) {
		homePage = new HomePage(driver);
		homePage.enterIntoSearchBox(productName);
		searchResultPage = new SearchResultPage(driver);
	}

	@When("Click on search button")
	public void click_on_search_button() {
		homePage.clickOnSearchButton();
	}

	@Then("Valid product should get displayed in search result")
	public void valid_product_should_get_displayed_in_search_result() {
		Assert.assertTrue(searchResultPage.searchproductPresent());
	}

	@When("User enters the non-existing product in search box {string}")
	public void user_enters_the_non_existing_product_in_search_box(String productName) {
		homePage = new HomePage(driver);
		homePage.enterIntoSearchBox(productName);
	}

	@Then("Proper text information the user about no  product matching should be displayed.")
	public void proper_text_information_the_user_about_no_product_matching_should_be_displayed() {
		searchResultPage = new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.errorForNoSearchProduct()
				.contains("There is no product that matches the search criteria."));
	}

	@When("User dont enter any product in search box")
	public void user_dont_enter_any_product_in_search_box() {
		homePage = new HomePage(driver);
	}
}
