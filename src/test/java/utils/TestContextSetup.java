package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver drv;
	public String LandingpageProductName;
	public PageObjectManager pageObjMgr;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjMgr = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
