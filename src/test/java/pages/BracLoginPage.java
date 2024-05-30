package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BracLoginPage extends BracBasePage {
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	WebElement signInButton;
	

	
	public BracHomePage adminCanLogin (String username, String password) {
		getActions().sendKeys(this.email, username).build().perform();
		getActions().sendKeys(this.password, password).build().perform();
		
		click(this.signInButton);
		return newPage(BracHomePage.class, driver);
		
		
	}
	
	public boolean validatePageHasLoaded () {
		
		
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.email);
			elementList.add(this.password);
			elementList.add(this.signInButton);
			
			return validateElementsAreVisible(elementList);
		
	}

}
