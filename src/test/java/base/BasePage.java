package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	

	protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    /**
     * 
     * This method is to perform an action to click on any web button
     * @author ariel
     * @param elemenToBeclicked = element to be clicked
     * 
     * */
    public void clickAction( WebElement elemenToBeclicked){
    	
    	elemenToBeclicked.click();
    	
    }
    
    /**
     * 
     * This method is to perform an action to send text in to a input txt elemen
     * @author ariel
     * @element = web element where the value is going to be added
     * @param text = text value to be added in the txt element
     * 
     * */
    public void sendText( WebElement element, String text){
    	
    	element.sendKeys(text);
    	
    }

}
