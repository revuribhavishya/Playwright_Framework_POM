package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	private String emailId="input#input-email";
	
	private String password="input#input-password";
	
	private String loginBtn="input[value='Login']";  // For CSS u dont mention @value='Login', u use @ only in xpath
	
//	private String forgotPassword="//div[@class='fprm-group']//a[normalize-space()='Forgotten Password']";
	
	private String forgotPassword = "div.fprm-group a:has-text(\"Forgotten Password\")";
	
	//private String logoutLink ="//a[@class='list-group-item'][normalize-space()='Logout']";
	private String logoutLink = "a.list-group-item:has-text('Logout')";

	
	
	public LoginPage(Page page) {
		this.page= page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotpwLinkExist() {
		return page.isVisible(forgotPassword);
	}
	
	public boolean login(String appUsername, String appPw) {
		System.out.println("app  cred" + appUsername + ":" + appPw);
		page.fill(emailId, appUsername);
		page.fill(password, appPw);
		page.click(loginBtn);
		if(page.isVisible(logoutLink)) {
			System.out.println("user is logged in succesffully ");
			return true;
		}
		
		return false;
	}
	

}
