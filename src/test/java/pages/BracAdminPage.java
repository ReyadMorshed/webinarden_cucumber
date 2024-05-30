package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BracAdminActions;

public class BracAdminPage extends BracBasePage{
	
	@FindBy(xpath = "//div//span[contains(text(),'Stakeholder Management')]")
	WebElement stakeHolderMangement;	
	

	
	@FindBy(xpath = "//span[contains(text(),'Stakeholder Information')]")
	WebElement stakeHolderinformation;
	

	public BracInformationPage clickOnStakeHolderInformation() {
		
		
		click(this.stakeHolderinformation);
		return newPage(BracInformationPage.class, driver);


	}
	
	public void clickOnStakeholderManegement() throws InterruptedException {
		
		scrollDownToElement(driver, stakeHolderMangement);
		actions.moveToElement(stakeHolderMangement).build().perform();;
	    click(this.stakeHolderMangement);
		
		


	}
	
	public boolean validatePageHasLoaded () {
		
		
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.stakeHolderMangement);
		
		
		return validateElementsAreVisible(elementList);
	
}
			

}
