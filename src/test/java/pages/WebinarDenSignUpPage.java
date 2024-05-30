package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebinarDenSignUpPage extends WebinardenBasePage{
	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement signInButton;
	
	public WebinarDenSignInPage clickOnSignInButton () {
		
		click(signInButton);
		return newPage(WebinarDenSignInPage.class, driver);
	}
	
public boolean validatePageHasLoaded () {
		
		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.signInButton);
			return validateElementsAreVisible(elementList);
		}
		
		catch(Exception e){
			
			click(signInButton);
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.signInButton);
			return validateElementsAreVisible(elementList);
		}
	}

}
