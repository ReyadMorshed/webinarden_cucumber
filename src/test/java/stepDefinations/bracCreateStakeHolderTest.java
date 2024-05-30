package stepDefinations;

import static org.testng.Assert.assertTrue;

import actions.BracAdminActions;
import base.Base;
import io.cucumber.java.en.*;
import pages.BracAdminPage;
import pages.BracHomePage;
import pages.BracInformationPage;
import pages.BracLoginPage;

public class bracCreateStakeHolderTest extends Base {
	
	BracAdminActions adminActions = new BracAdminActions();
	BracLoginPage loginPage = null;
	BracHomePage homePage = null;
	BracAdminPage adminPage = null;
    BracInformationPage informationPage = null;
	@Given("User is in Brac website")
	public void user_is_in_brac_website() {
		
		navigateToApplication(Hook.configProperties.getProperty("URL"));
	    
	}

	@When("User is in Brac login page, validate this page")
	public void user_is_in_brac_login_page_validate_this_page() {
		loginPage = newPage(BracLoginPage.class, driver);
		assertTrue(loginPage.validatePageHasLoaded());
		
	    
	}

	@When("User is in Brac Sign In page, enter username and password for login")
	public void user_is_in_brac_sign_in_page_enter_username_and_password_for_login() throws InterruptedException {
	   
		String usename = Hook.configProperties.getProperty("username");
		String password = Hook.configProperties.getProperty("password");
		homePage = adminActions.userEnterEmailAndPasswordForLogin(loginPage, usename, password);
	}

	@Then("Validate Brac Home page")
	public void validate_brac_home_page() {
		
		assertTrue(homePage.validatePageHasLoaded());
	    
	}

	@Then("Click on admin from the homepage and switch the tab")
	public void click_on_admin_from_the_homepage_and_switch_the_tab() throws InterruptedException {
		
		adminPage = adminActions.adminClickOnAdminAndSwitchTab(homePage);
	   
	}

	@Then("click on stakeholder mangement from left menu from admin page")
	public void click_on_stakeholder_mangement_from_left_menu_from_admin_page() throws InterruptedException {
		
		adminPage.clickOnStakeholderManegement();
	   
	}

	@Then("Select stakeholder information")
	public void select_stakeholder_information() {
		
		informationPage = adminActions.adminCanClickOnStakeHolderInformation(adminPage);
		assertTrue(informationPage.validatePageHasLoaded());
	   
	}

	@Then("create a stakeholder")
	public void create_a_stakeholder() throws InterruptedException {
		String name = Hook.configProperties.getProperty("name");
		adminActions.adminCanCreateStakeHolder(informationPage, name);
	}

	@Then("validate that the stakeholder is successfully created")
	public void validate_that_the_stakeholder_is_successfully_created() {
		String name = Hook.configProperties.getProperty("name");
		adminActions.adminCanSearchStakeholder(informationPage, name);
	}



}
