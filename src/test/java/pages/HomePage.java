package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage  extends BasePage{
	
	
	
	/**
	 * HomePage constructor method
	 * @param driver
	 */
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="ul.oxd-main-menu > li:nth-child(1) > a.oxd-main-menu-item")
	WebElement adminTab;
	
	@FindBy(xpath="//*[@alt='client brand banner']")
	WebElement logoImg;
	
	/**
	 * The method clickOnAdminTab is a landing method to move and pass the driver to SystemUserPage
	 * @return SystemUserPage() instance
	 */
	public SystemUserPage clickOnAdminTab() {
		adminTab.click();
		return new SystemUserPage(driver);
	}
	
	/**
	 * Method verifyDashboadLogo to validate if the logo is shows up in Home page 
	 * @return boolean to make sure if logo is present ( true or false)
	 */
	public boolean verifyDashboadLogo() {
		return logoImg.isDisplayed();
	}
	

}
