package stepDefinations;

import static org.testng.Assert.assertTrue;

import actions.WebinardenCustomerActions;
import base.Base;
import io.cucumber.java.en.*;
import pages.*;

public class WebinarDenLoginTest extends Base {

	WebinardenCustomerActions customerActions = new WebinardenCustomerActions();
	WebinardenLandingPage landingPage = null;
	WebinarDenSignUpPage signUpPage = null;
	WebinarDenSignInPage signInPage = null;
	WebinarDenHomePage homePage = null;

	@Given("User is in WebinarDen website")
	public void user_is_in_webinar_den_website() {
		navigateToApplication(Hook.configProperties.getProperty("URL"));

	}

	@When("User is in WebinarDen Landing page, validate this page")
	public void user_is_in_webinar_den_landing_page_validate_this_page() {
		landingPage = newPage(WebinardenLandingPage.class, driver);
		assertTrue(landingPage.validatePageHasLoaded());
	}

	@Then("click on sign up button")
	public void click_on_sign_up_button() throws InterruptedException {

		signUpPage = customerActions.userClickOnSignUpButton(landingPage);
		assertTrue(signUpPage.validatePageHasLoaded());

	}

	@Then("click on Sign In")
	public void click_on_sign_in() throws InterruptedException {
		signInPage = customerActions.userClickOnSignButton(signUpPage);

	}

	@Then("Validate WebinarDen Sign In page")
	public void validate_webinar_den_sign_in_page() {
		assertTrue(signInPage.validatePageHasLoaded());
	}

	@When("User is in WebinarDen Sign In page, enter <username> and <password> for login")
	public void user_is_in_webinar_den_sign_in_page_enter_username_and_password_for_login(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		String usename = Hook.configProperties.getProperty("username");
		String password = Hook.configProperties.getProperty("password");
		homePage = customerActions.userEnterEmailAndPasswordForLogin(signInPage, usename, password);

	}

	@Then("Validate WebinarDen Home page")
	public void validate_webinar_den_home_page() {
		assertTrue(homePage.validatePageHasLoaded());

	}

}
