package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BracHomePage extends BracBasePage {
	
	@FindBy(xpath ="//p[contains(text(),'Admin')]")
	WebElement adminLink;
	
	public BracAdminPage clickOnAdminAndSwitchTheTab() {
		
      
		click(this.adminLink);
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
//		 Set<String> handles = driver.getWindowHandles();
//		// Switch to the new tab
//	        for (String handle : handles) {
//	            if (!handle.equals(driver.getWindowHandle())) {
//	                driver.switchTo().window(handle);
//	                break;
//	            }
//	        }
	   return newPage(BracAdminPage.class, driver);     
	        
		
	}
	
	public boolean validatePageHasLoaded () {
		
		
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.adminLink);
		
		
		return validateElementsAreVisible(elementList);
	
}

}
