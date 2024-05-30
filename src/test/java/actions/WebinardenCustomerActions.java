package actions;

import pages.*;

public class WebinardenCustomerActions {
	
	public WebinarDenSignUpPage userClickOnSignUpButton (WebinardenLandingPage landingpage) throws InterruptedException {
		return landingpage.clickOnSignInButton();
	}
	
	public WebinarDenSignInPage userClickOnSignButton (WebinarDenSignUpPage signUpPage) throws InterruptedException {
		return signUpPage.clickOnSignInButton();
		
	}
	
	public WebinarDenHomePage userEnterEmailAndPasswordForLogin(WebinarDenSignInPage signInPage, String email, String password) throws InterruptedException{
		return signInPage.enterEmailAndPasswordForLogin(email, password);
	}
	
	public WebinarDenWebinarsPage userCanGoToWebinarsPage (WebinarDenHomePage homepage) {
		return homepage.clickOnWebinarsLink();
	}
	
	public void userCanSelectWebinarType (WebinarDenWebinarsPage webinarsPage) {
		webinarsPage.selectWebinarTypeFilter();
	}

}
