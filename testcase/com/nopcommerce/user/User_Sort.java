package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.CustomerInfoPageUI;
import PageUI.HomePageUI;
import PageUI.LoginPageUI;
import PageUI.ProductPageUI;
import PageUI.RegisterPageUI;
import PageUI.SearchPageUI;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import pageObjects.SearchPageObject;

public class User_Sort extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ProductPageObject productPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		homePage = new HomePageObject(driver);
		
		homePage.hoverMouseToElement(driver, HomePageUI.TOPMENU_COMPUTER_LINK);
		homePage.clickToElement(driver, HomePageUI.SUBMENU_NOTEBOOK_LINK);
		productPage = PageGeneratorManager.getProductPage(driver);
	}
	
	@Test
	public void TC_01_With_Name_A_To_Z(){
		productPage.selectSortByDropdown(driver,ProductPageUI.SORT_DROPDOWN,"Name: A to Z");
		productPage.verifySortAToZ(driver,ProductPageUI.PRODUCT_NAME);
	}
	
	@Test
	public void TC_02_With_Name_Z_To_A(){
		productPage.selectSortByDropdown(driver,ProductPageUI.SORT_DROPDOWN,"Name: Z to A");
		productPage.verifySortZToA(driver,ProductPageUI.PRODUCT_NAME);
	}
	
	@Test
	public void TC_03_With_Name_Low_To_High(){
		productPage.selectSortByDropdown(driver,ProductPageUI.SORT_DROPDOWN,"Price: Low to High");
		productPage.verifySortLowToHigh(driver,ProductPageUI.PRODUCT_PRICE);
	}
	
	@Test
	public void TC_04_With_Name_High_To_Low(){
		productPage.selectSortByDropdown(driver,ProductPageUI.SORT_DROPDOWN,"Price: High to Low");
		productPage.verifySortHighToLow(driver,ProductPageUI.PRODUCT_PRICE);
	}	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
