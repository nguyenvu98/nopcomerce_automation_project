package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.ProductDetailPageUI;
import PageUI.RegisterPageUI;
import PageUI.WishlistPageUI;
import commons.BaseTest;
import pageObjects.CartPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductDetailPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WishlistPageObject;


public class User_Compare_Wishlist extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private ProductDetailPageObject productDetailPage;
	private WishlistPageObject wishlistPage;
	private CartPageObject cartPage;
	
	private String registedEmail = validEmail;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		homePage = new HomePageObject(driver);
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.clickToContinueButton();
		
		homePage = new HomePageObject(driver);
		homePage.clickToProductLink();
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
	}
	
	@Test
	public void TC_01_Add_To_Wishlist(){
		productDetailPage.clickToAddWishListButton();
		Assert.assertEquals(productDetailPage.getSuccessfullyMessage(), "The product has been added to your wishlist");
		productDetailPage.clickToCloseButton();
		productDetailPage.clickToWishlistLink();
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		wishlistPage.verifyProductWasAdded();		
	}
	
	@Test
	public void TC_02_Add_To_Cart_From_Wishlist(){
		productDetailPage.clickToWishlistLink();
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		wishlistPage.addToCart();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.verifyShoppingCartIsUpdate();
			
	}
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
