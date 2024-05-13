package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.AddressesPageUI;
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
		homePage.clickToFooterLinkByName("Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
	}
	
//	@Test
	public void TC_01_With_Empty_Data(){
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		Assert.assertEquals(searchPage.getEmptyErrorMessage(), "Search term minimum length is 3 characters");
	}
	
//	@Test
	public void TC_02_With_Data_Not_Exist(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "2050");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		Assert.assertEquals(searchPage.getNoResultErrorMessage(), "No products were found that matched your criteria.");
	}
	
//	@Test
	public void TC_03_With_Relative_Product_Name(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "lenovo");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		searchPage.verifyfResultOfRelativeName();
	}
	
//	@Test
	public void TC_04_With_Absolute_Product_Name(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "ThinkPad X1 Carbon");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		searchPage.verifyfResultOfAbsoluteName();
	}
	
//	@Test
	public void TC_05_With_Parent_Categories(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "Apple Macbook Pro");
		searchPage.clickToElement(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		searchPage.selectDropdownCategories(driver, SearchPageUI.CATEGORY_DROPDOWN, "Computers");
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		Assert.assertEquals(searchPage.getNoResultErrorMessage(), "No products were found that matched your criteria.");
	}
	

	@Test
	public void TC_06_With_Sub_Categories(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "Apple Macbook Pro");
		searchPage.clickToElement(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		searchPage.selectDropdownCategories(driver, SearchPageUI.CATEGORY_DROPDOWN, "Computers");
		searchPage.clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		searchPage.verifyfResultOfSubCategory();
	}
	
	@Test
	public void TC_07_With_Incorrect_Manufacturer(){
		searchPage.sendkeyToElement(driver, SearchPageUI.SEARCH_INPUT, "Apple Macbook Pro");
		searchPage.clickToElement(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		searchPage.selectDropdownCategories(driver, SearchPageUI.CATEGORY_DROPDOWN, "Computers");
		searchPage.selectDropdownManufacturer(driver, SearchPageUI.CATEGORY_DROPDOWN, "HP");
		searchPage.clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		searchPage.clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		Assert.assertEquals(searchPage.getNoResultErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
