package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.CartPageUI;
import PageUI.HomePageUI;
import PageUI.LoginPageUI;
import PageUI.NotebookPageUI;
import PageUI.ProductDetailPageUI;
import PageUI.RegisterPageUI;
import commons.BaseTest;
import pageObjects.CartPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.DesktopPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NotebookPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductDetailPageObject;
import pageObjects.ProductPageObject;
import pageObjects.RegisterPageObject;

public class User_Order extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private ProductPageObject productPage;
	private ProductDetailPageObject productDetailPage;
	private DesktopPageObject desktopPage;
	private CartPageObject cartPage;
	private NotebookPageObject notebookPage;
	private CheckoutPageObject checkoutPage;
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
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}
	
//	@Test
	public void TC_01_Add_Product_To_Cart(){
		homePage.hoverMouseToElement(driver, HomePageUI.TOPMENU_COMPUTER_LINK);
		homePage.clickToElement(driver, HomePageUI.SUBMENU_DESKTOP_LINK);
		
		desktopPage = PageGeneratorManager.getDesktopPage(driver);
		desktopPage.clickBuildYourComputerLink();
		
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		productDetailPage.selectRAMByDropdown(driver,ProductDetailPageUI.RAM_DROPDOWN,"2 GB");
		productDetailPage.selectHDDRadioButton();
		productDetailPage.clickAddToCartButton();
		
		Assert.assertEquals(productDetailPage.getSuccessfullyMessage(),"The product has been added to your shopping cart");		
		productDetailPage.clickToCloseButton();
		productDetailPage.clickTopbarShippingCart();
		
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.verifyProductWasAddedToCart();		
	}
	
//	@Test
	public void TC_02_Edit_Product_In_Cart(){
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.editItemInCart();
		
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		productDetailPage.selectProcessorByDropdown(driver,ProductDetailPageUI.PROCESSOR_DROPDOWN,"2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectRAMByDropdown(driver,ProductDetailPageUI.RAM_DROPDOWN, "2 GB");
		productDetailPage.selectHDDRadioButton();
		productDetailPage.selectOSRadioButton();
		productDetailPage.selectSoftwareCheckbox();
		productDetailPage.changeQuantity();
		productDetailPage.clickUpdateCartButton();
		Assert.assertEquals(productDetailPage.getSuccessfullyMessage(),"The product has been added to your shopping cart");		
		productDetailPage.clickToCloseButton();
		productDetailPage.clickTopbarShippingCart();

		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.verifyProductWasUpdateToCart();
	}
	
//	@Test
	public void TC_03_Remove_From_Cart(){
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.clickToRemoveButton();
		Assert.assertEquals(productDetailPage.getMessageEmpty(),"Your Shopping Cart is empty!");		
	}
	
	@Test
	public void TC_04_Checkout(){
		homePage.hoverMouseToElement(driver, HomePageUI.TOPMENU_COMPUTER_LINK);
		homePage.clickToElement(driver, HomePageUI.SUBMENU_NOTEBOOK_LINK);
		
		notebookPage = PageGeneratorManager.getNotebookPage(driver);
		notebookPage.clickToProductLink(driver, NotebookPageUI.PRODUCT_LINK,"Apple MacBook Pro 13-inch");
		
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		productDetailPage.clickAddToCartButton();
		
		productDetailPage.isElementUndisplayed(driver, ProductDetailPageUI.LOADING_BLOCK);
		
		productDetailPage.clickToCloseButton();
		productDetailPage.clickTopbarShippingCart();
		
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.isElementUndisplayed(driver,CartPageUI.LOADING_BLOCK);
		cartPage.clickToAcceptCheckbox();
		cartPage.clickCheckoutButton();
		
		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);
		
	}
	
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
