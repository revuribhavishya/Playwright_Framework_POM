package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected HomePage homePage;
	protected LoginPage loginpage;
	protected Properties prop;
	

	@BeforeTest
	public void setup() throws IOException {
		pf = new PlaywrightFactory();
		prop=pf.init_prop();
		page =pf.initializeBrowser(prop);
		homePage = new HomePage(page);
		 
	}
	
	
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}

	
}
