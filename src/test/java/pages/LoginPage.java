package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(xpath="//input[@name='username']")
	WebElement userNameTxt;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passTxt;
	
	
	@FindBy(css=".oxd-button--main")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[2]/img[@alt='orangehrm-logo']")
	WebElement logoImg;
	
	/**
	 * constructor method
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}


	/**
	 * Method verifyLogo to validate if the logo is shows up in Home page 
	 * @return boolean to make sure if logo is present ( true or false)
	 */
	public boolean verifyLogo() {
		
		return logoImg.isDisplayed();
		
	}
	
	/**
	 * The method login is a landing method to move and pass the driver to HomePage
	 * @param user
	 * @param pass
	 * @return HomePage() Instance
	 */
	public HomePage login(String user, String pass) {
		userNameTxt.sendKeys(user);
		passTxt.sendKeys(pass);
		loginBtn.click();
		return new HomePage(driver);
	}
}

