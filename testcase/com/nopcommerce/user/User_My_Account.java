package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.AddressesPageUI;
import PageUI.CustomerInfoPageUI;
import PageUI.HomePageUI;
import PageUI.LoginPageUI;
import PageUI.ProductPageUI;
import PageUI.RegisterPageUI;
import commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import pageObjects.RegisterPageObject;

public class User_My_Account extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressesPageObject addressesPage;
	private ProductPageObject productPage;
	
	private	String invalidEmail = "abc";
	private	String wrongPass = "12345678910jqka";
	private String unregistedEmail = "abc@abc.com";
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
		
		homePage.clickToHeaderLinkByName("My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
	}
	
	@Test
	public void TC_01_Customer_Info(){
		myAccountPage.clickToBlockNavigationLinkByName("Customer info");
		customerInfoPage = new CustomerInfoPageObject(driver);
		customerInfoPage.clickRadioButton(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, "male");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_INPUT, "Nguyen Vu");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.LASTNAME_INPUT, "Vo");
		customerInfoPage.selectDropdownDay(driver,CustomerInfoPageUI.DAY_INPUT,"18");
		customerInfoPage.selectDropdownMonth(driver,CustomerInfoPageUI.MONTH_INPUT,"October");
		customerInfoPage.selectDropdownYear(driver,CustomerInfoPageUI.YEAR_INPUT,"1998");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.COMPANYNAME_INPUT, "Automation FC");
		customerInfoPage.clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
		customerInfoPage.verifySuccessMessage();
	}
	
	@Test
	public void TC_02_Addresses(){
		myAccountPage.clickToBlockNavigationLinkByName("Addresses");
		addressesPage = new AddressesPageObject(driver);
		addressesPage.clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
		addressesPage.sendkeyToElement(driver, AddressesPageUI.FIRSTNAME_INPUT, "Vo Nguyen");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.LASTNAME_INPUT, "Vu");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.EMAIL_INPUT, "vune@yahoo.com");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.COMPANI_INPUT, "Vo Nguyen");
		addressesPage.selectDropdownCountry(driver, AddressesPageUI.COUNTRY_DROPDOWN, "Viet Nam");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.CITY_INPUT, "Da Nang");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.ADDRESS_1_INPUT, "Ly Thai To");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.ZIPCODE_INPUT, "043");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.PHONENUMBER_INPUT, "0987654321");
		addressesPage.clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
		addressesPage.verifySuccessMessage();
	}
	
	@Test
	public void TC_03_My_Product_Review() {
		myAccountPage.clickToHomePage();
		homePage = new HomePageObject(driver);
		homePage.hoverMouseToElement(driver, HomePageUI.TOPMENU_COMPUTER_LINK);
		homePage.clickToElement(driver, HomePageUI.SUBMENU_NOTEBOOK_LINK);
		productPage = PageGeneratorManager.getProductPage(driver);
		productPage.clickToElement(driver, ProductPageUI.PRODUCT_LINK);
		productPage.clickToAddReviewLink(driver, ProductPageUI.REVIEW_LINK);
		productPage.sendkeyToElement(driver, ProductPageUI.REVIEW_TITLE_INPUT, "First review");
		productPage.sendkeyToElement(driver, ProductPageUI.REVIEW_TEXT_INPUT, "So bad");
		productPage.clickToElement(driver, ProductPageUI.REVIEW_SUBMIT_BUTTON);
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
