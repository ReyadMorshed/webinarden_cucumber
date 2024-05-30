package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebinarDenSignInPage extends WebinardenBasePage {

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement signInButton;
	
	@FindBy(xpath = "//input[@id='sign-in-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='sign-in-email']")
	WebElement email;
	

	public WebinarDenHomePage enterEmailAndPasswordForLogin(String email, String password) {
		getActions().sendKeys(this.email, email).build().perform();
		getActions().sendKeys(this.password, password).build().perform();
		
		click(this.signInButton);
		return newPage(WebinarDenHomePage.class, driver);
	}
	
	public boolean validatePageHasLoaded() {

		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.signInButton);
			elementList.add(this.email);
			elementList.add(this.password);
			return validateElementsAreVisible(elementList);
		}

		catch (Exception e) {

			click(signInButton);
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.signInButton);
			return validateElementsAreVisible(elementList);
		}

	}
}
