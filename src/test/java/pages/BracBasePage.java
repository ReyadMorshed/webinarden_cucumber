package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.Base;

public class BracBasePage extends Base{
	
	
	protected boolean validateElementsAreVisible(List<WebElement> elementList){
        while (elementList.size() > 0){
            if (isDisplayed(elementList.get(0))){
                elementList.remove(0);
                validateElementsAreVisible(elementList);
            }
        }
        return true;
    }

}
