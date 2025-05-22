package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class HomePageTest extends BaseTest{

	
	@Test
	public void homePageTitleTest() {
		String actualTitle= homePage.getHomePageTitle();
		AssertJUnit.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getProductdata() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test
	public void homePageUrlTest() {
		String actualurl= homePage.getHomePageURL();
		AssertJUnit.assertEquals(actualurl, prop.getProperty("url"));
	}
	
	@Test(dataProvider= "getProductdata")
	public void searchTest(String productName) {
		String acutualSeachHeader=homePage.doSearch("Macbook");
		AssertJUnit.assertEquals(acutualSeachHeader, "Search - Macbook");
		 
	}

}
