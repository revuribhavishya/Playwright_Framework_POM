package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	// this is given priority 1 bcoz we are navigated to login lage, and in next cases, we don;t have to write teh code to switch to login page
	@Test(priority=1)
	public void loginPageNavigationTest() {
// the object of loginpage is craeted in Homepage .. // It's a bad approach to create obj in this page
		loginpage = homePage.navigateToLoginPage();  
		String actTitle=loginpage.getLoginPageTitle();
		System.out.print("page actual title" + actTitle);
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void forgotpwlinkExistTest() {
		Assert.assertTrue(loginpage.isForgotpwLinkExist());
		
	}
	
	@Test(priority=3)
	public void appLoginTest() {
		Assert.assertTrue(loginpage.login(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		
	}
}
