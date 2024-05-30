package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebinarDenHomePage extends WebinardenBasePage {
	@FindBy(xpath = "//button[@id='submenu-extend-btn']")
	WebElement submenu;

	@FindBy(css = "a[href='/webinars']")
	WebElement webinarsButton;
	
	public WebinarDenWebinarsPage clickOnWebinarsLink() {
		getActions().click(this.webinarsButton).build().perform();
		return newPage(WebinarDenWebinarsPage.class, driver);
	}
	
	@Override
	public boolean validatePageHasLoaded() {
		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.submenu);
			
			return validateElementsAreVisible(elementList);
		}

		catch (Exception e) {

			click(submenu);
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.submenu);
			return validateElementsAreVisible(elementList);
		}
	}

}
