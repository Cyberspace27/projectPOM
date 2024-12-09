package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemUserPage;
import utils.JsonDataReader;

/**
	 * @author ariel
	 *
	 */
	public class HomeTest extends BaseTest{

	HomePage home;
	SystemUserPage sysUser;
	String username ;
    String password ;
    String expectedUrl;
	
	@BeforeMethod
    public void loginTestSetup() {
		// Retrieve test data
	     username = JsonDataReader.getValue("login", "username");
	     password = JsonDataReader.getValue("login", "password");
	     expectedUrl = JsonDataReader.getValue("urls","dashboard_url");
    }
	
	@Test(priority=1)
	public void adminTabTest() {
		home = login.login(username, password);
		//Assert.assertTrue(home.verifyDashboadLogo());	
	}
	
	@Test(priority=2)
	public void verifySystemUserPageTest() {

		login = new LoginPage(getDriver());
		home = login.login(username, password);
		sysUser = home.clickOnAdminTab();
		String actualUrl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

		

}
