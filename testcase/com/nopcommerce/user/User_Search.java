package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.CustomerInfoPageUI;
import PageUI.LoginPageUI;
import PageUI.RegisterPageUI;
import PageUI.SearchPageUI;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.SearchPageObject;

public class User_Search extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private SearchPageObject searchPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_03_With_Relative_Product_Name(){
		homePage.clickToFooterLinkByName("Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "lenovo");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		searchPage.verifyfResultOfRelativeName();
	}
	
	@Test
	public void TC_04_With_Absolute_Product_Name(){
		homePage.clickToFooterLinkByName("Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "ThinkPad X1 Carbon");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		searchPage.verifyfResultOfAbsoluteName();
	}
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
