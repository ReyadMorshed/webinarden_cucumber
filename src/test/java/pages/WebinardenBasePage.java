package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.Base;

public abstract class WebinardenBasePage extends Base {
	
   public abstract boolean validatePageHasLoaded();

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
