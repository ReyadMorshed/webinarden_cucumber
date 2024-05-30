package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Base {

    protected static WebDriver driver;
    public static Actions actions;
    
    

    protected static Actions getActions() {
        return actions = new Actions(driver);
    }

    protected static void click(WebElement element) {
        element.click();
    }

    protected static void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected String getTextOfElement(WebElement element){
        return element.getText();
    }

    protected static void navigateToApplication(String url) {
        driver.navigate().to(url);
    }

    protected static boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    protected static void selectFromDropdownByVisibleText(WebElement element, String categoryName){
        Select select = new Select(element);
        select.selectByVisibleText(categoryName);
    }

    protected static void selectFromDropdownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected static int getSizeOfListOfWebElements(List<WebElement> elementList) {
        return elementList.size();
    }

    protected static int getRandomValue(int minimum, int maximum) {
        int randomValue = (int) (Math.random() * (maximum - minimum + 1) + minimum);
        return randomValue;
    }

    public static <T> T newPage(Class<T> testClass, WebDriver driver) {
        return PageFactory.initElements(driver, testClass);
    }
    
    

    public static String getExtentReportConfigPath(String filePath){
        if(filePath != null){
            return filePath;
        }
        else{
            throw new RuntimeException("Extent report config path is not available");
        }
    }
    
    public static void scrollDownToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}