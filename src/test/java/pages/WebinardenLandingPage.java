package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebinardenLandingPage extends WebinardenBasePage {
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement sigUpButton;
	
	@FindBy (xpath = "//a[contains(text(),'WebinarDen')]")
	private WebElement logo;
	
	
	public WebinarDenSignUpPage clickOnSignInButton () throws InterruptedException {
		Thread.sleep(1000);
		click(sigUpButton);
		return newPage(WebinarDenSignUpPage.class, driver);
	}
	
	public boolean validatePageHasLoaded () {
		
		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.sigUpButton);
			return validateElementsAreVisible(elementList);
		}
		
		catch(Exception e){
			
			click(logo);
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.sigUpButton);
			return validateElementsAreVisible(elementList);
		}
	}

}
