package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebinarDenWebinarsPage extends WebinardenBasePage {

	@FindBy(xpath = "//select[@id='webinar-type']")
	WebElement webinarTypeFilter;
	
	@FindBy(css = "a[href='/webinars']")
	WebElement webinarsButton;
	
	String type = "Featured";
	public void selectWebinarTypeFilter () {
		selectFromDropdownByVisibleText(this.webinarTypeFilter,type);
	}
	
	
	@Override
	public boolean validatePageHasLoaded() {
		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.webinarTypeFilter);
			
			return validateElementsAreVisible(elementList);
		}

		catch (Exception e) {

			click(webinarsButton);
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.webinarTypeFilter);
			return validateElementsAreVisible(elementList);
		}
	}

}
