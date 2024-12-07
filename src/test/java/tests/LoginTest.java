package tests;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.JsonDataReader;

public class LoginTest extends BaseTest{
	HomePage home;
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
	
	@Test(priority = 1, enabled= true)
	public void verifyLogoImgTest() {
		
		boolean flag = login.verifyLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=2) 
	public void verifyLoginTest() throws IOException, URISyntaxException {
		
		home = login.login(username, password);
		String actualUrl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

}
