package stepDefinations;

import static org.testng.Assert.assertTrue;

import actions.WebinardenCustomerActions;
import base.Base;
import io.cucumber.java.en.*;
import pages.WebinarDenHomePage;
import pages.WebinarDenWebinarsPage;

public class WebinarDenFilterTest extends Base {
	
	WebinardenCustomerActions customerActions = new WebinardenCustomerActions();
	WebinarDenHomePage homepage = null;
	WebinarDenWebinarsPage webinarsPage= null;
	
	
	@Then("Click on webinarden menu from the top")
	public void click_on_webinarden_menu_from_the_top() {
	   homepage= newPage(WebinarDenHomePage.class, driver);
	   webinarsPage = customerActions.userCanGoToWebinarsPage(homepage);
	   
	}

	@Then("Validate the webinarden page")
	public void validate_the_webinarden_page() {
		
		assertTrue(webinarsPage.validatePageHasLoaded());
	    
	}

	@Then("Click on webinar type dropdown and select featured")
	public void click_on_webinar_type_dropdown_and_select_featured() {
	    customerActions.userCanSelectWebinarType(webinarsPage);
	}

}
