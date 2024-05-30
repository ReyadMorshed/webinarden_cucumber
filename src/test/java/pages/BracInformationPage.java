package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class BracInformationPage extends BracBasePage {
	
@FindBy (xpath = "//mat-icon[contains(text(),'add')]")
WebElement stakeHolderAddButton;

@FindBy (xpath = "//mat-select-trigger[contains(text(),'Select a Country')]")
WebElement selectCountry;

@FindBy (xpath = "//*[@role='option']/span[contains(text(),' Uganda ')]")
WebElement countryUganda;

@FindBy (xpath = "/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav/div/app-survey-response/div/mat-stepper/div/div[2]/div[1]/div[1]/app-working-area-selection/div/app-dropdown-tree/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]")
WebElement workingArea;

@FindBy (xpath = "//mat-icon[contains(text(),'chevron_right')]")
WebElement ugandaHeadOffice;

@FindBy (xpath = "//span//mat-icon[contains(text(),'chevron_right')][1]")
WebElement igangaMenu;

@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/app-stl-tree/div/div/mat-tree/mat-tree-node[3]/button/span[1]/mat-icon")
WebElement kamuli;

@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/app-stl-tree/div/div/mat-tree/mat-tree-node[4]/button/span[1]/mat-icon") 
WebElement musita;

@FindBy (xpath = "(//span[contains(text(),' Misoli(Village) ')])[1]")
WebElement misoliVill;

@FindBy (xpath = "//span[contains(text(),'Next')]")
WebElement nextButton;

@FindBy (xpath = "/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav/div/app-survey-response/div/mat-stepper/div/div[2]/div[2]/div[1]/app-form-loader/div/div/app-text-form-field[1]/div/mat-form-field/div/div[1]/div/input")
WebElement name;

@FindBy (xpath = "/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav/div/app-survey-response/div/mat-stepper/div/div[2]/div[2]/div[1]/app-form-loader/div/div/app-dropdown-form-field[1]/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]")
WebElement gender;

@FindBy (xpath = "//mat-option//span[contains(text(),'Male')]")
WebElement maleGender;

@FindBy (xpath = "/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav/div/app-survey-response/div/mat-stepper/div/div[2]/div[2]/div[1]/app-form-loader/div/div/app-linked-dropdown-form-field[1]/div/mat-form-field/div/div[1]/div[1]/mat-select/div/div[2]")
WebElement stakeHolderType;

@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/mat-option[1]/span/div")
WebElement label;

@FindBy(xpath = "//span[contains(text(),'Save')]") 
WebElement saveButton;

@FindBy(xpath = "//table[@role='table']")
WebElement table;

@FindBy(xpath ="//tbody/tr/td[2]")
private List<WebElement>names;
	
public void createAnStakeHolder (String name) throws InterruptedException {
	click(this.stakeHolderAddButton);
	click(this.selectCountry);
	Thread.sleep(2000);
	actions.moveToElement(countryUganda);
	click(this.countryUganda);
	click(this.workingArea);
	click(this.ugandaHeadOffice);
	click(this.igangaMenu);
	click(this.kamuli);
	click(this.musita);
	click(this.misoliVill);
	click(this.nextButton);
	getActions().sendKeys(this.name, name).build().perform();
	click(this.gender);
	click(this.maleGender);
	click(this.stakeHolderType);
	click(this.label);
	click(this.saveButton);
}


public void searchStakeholder(String name) {
//	List<WebElement> rows = table.findElements(By.tagName("tr"));
//	
    // Iterate through each row
    
        
        // Iterate through each cell
        for (WebElement cell : names) {
            // Check if the cell contains the search string
            if (cell.getText().contains(name)) {
                // If found, print the row and cell content
                System.out.println("Search string found in the following cell: " + cell.getText());
                // You can add additional actions here, like clicking a link or performing some other action
            }
            
            else {
            	System.out.println("Not Found");
            }
        }
    
}

public boolean validatePageHasLoaded () {
		
		
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.stakeHolderAddButton);
		
		
		return validateElementsAreVisible(elementList);
	
}

}


