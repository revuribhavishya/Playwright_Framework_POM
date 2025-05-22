package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright pw;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;

	public Page initializeBrowser(Properties prop) {
		
		String browserName =prop.getProperty("browser").trim();
		
		System.out.println("browser name is " + browserName);
		
		pw = Playwright.create();
		
		switch(browserName.toLowerCase()) {
		case "chromium":
			browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
			break;
		case "firefox":
			browser=pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
			break;
		case "safari":
			browser= pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
			break;
		case "chrome":
			browser= pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)); 
			break;
			
		default:
			System.out.println("plz pass the right browser name");
			break;
			
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		
		return page;
		
	}
	
// used to initialize properties from config file
	public Properties init_prop() throws IOException {
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
