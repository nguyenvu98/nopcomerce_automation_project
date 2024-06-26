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
		log.info("Customer Info - Step 01: Navigate to Customer info page");
		myAccountPage.clickToBlockNavigationLinkByName("Customer info");
		customerInfoPage = new CustomerInfoPageObject(driver);
		
		log.info("Customer Info - Step 02: Click to Gender Radio Button");
		customerInfoPage.clickRadioButton(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, "male");
		
		log.info("Customer Info - Step 03: Enter to Firstname Input");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_INPUT, "Nguyen Vu");
		
		log.info("Customer Info - Step 04: Enter to Lastname Input");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.LASTNAME_INPUT, "Vo");
		
		log.info("Customer Info - Step 05: Select Day Dropdown");
		customerInfoPage.selectDropdownDay(driver,CustomerInfoPageUI.DAY_INPUT,"18");
		
		log.info("Customer Info - Step 06: Select Month Dropdown");
		customerInfoPage.selectDropdownMonth(driver,CustomerInfoPageUI.MONTH_INPUT,"October");
		
		log.info("Customer Info - Step 07: Select Year Dropdown");
		customerInfoPage.selectDropdownYear(driver,CustomerInfoPageUI.YEAR_INPUT,"1998");
		
		log.info("Customer Info - Step 08: Enter to Company Name Input");
		customerInfoPage.sendkeyToElement(driver, CustomerInfoPageUI.COMPANYNAME_INPUT, "Automation FC");
		
		log.info("Customer Info - Step 09: Click to Save Button");
		customerInfoPage.clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
		
		log.info("Customer Info - Step 10: Verify successfully message");
		verifyTrue(customerInfoPage.verifySuccessMessage( "The customer info has been updated successfully."));
	}
	
	@Test
	public void TC_02_Addresses(){
		log.info("Addresses - Step 01: Navigate to Addresses page");
		myAccountPage.clickToBlockNavigationLinkByName("Addresses");
		addressesPage = new AddressesPageObject(driver);
		
		log.info("Addresses - Step 02: Click to Add new Button");
		addressesPage.clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
		
		log.info("Addresses - Step 03: Enter to Firstname Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.FIRSTNAME_INPUT, "Vo Nguyen");
		
		log.info("Addresses - Step 04: Enter to Lastname Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.LASTNAME_INPUT, "Vu");
		
		log.info("Addresses - Step 05: Enter to Email Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.EMAIL_INPUT, "vune@yahoo.com");
		
		log.info("Addresses - Step 06: Enter to Company Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.COMPANI_INPUT, "Vo Nguyen");
		
		log.info("Addresses - Step 07: Select to Country Dropdown");
		addressesPage.selectDropdownCountry(driver, AddressesPageUI.COUNTRY_DROPDOWN, "Viet Nam");
		
		log.info("Addresses - Step 08: Enter to City Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.CITY_INPUT, "Da Nang");

		log.info("Addresses - Step 09: Enter to Address Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.ADDRESS_1_INPUT, "Ly Thai To");
		
		log.info("Addresses - Step 10: Enter to Zip Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.ZIPCODE_INPUT, "043");
		
		log.info("Addresses - Step 11: Enter to Phone numberty Input");
		addressesPage.sendkeyToElement(driver, AddressesPageUI.PHONENUMBER_INPUT, "0987654321");
		
		log.info("Addresses - Step 12: Click to Save Button");
		addressesPage.clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
		
		log.info("Addresses - Step 13: Verify successfully message");
		verifyTrue(addressesPage.verifySuccessMessage("The new address has been added successfully.")); 
	}
	
	@Test
	public void TC_03_My_Product_Review() {
		log.info("Product Review - Step 01: Navigate to Home page");
		myAccountPage.clickToHomePage();
		homePage = new HomePageObject(driver);
		
		log.info("Product Review - Step 02: Hover and click to Notebook Link");
		homePage.hoverMouseToElement(driver, HomePageUI.TOPMENU_COMPUTER_LINK);
		homePage.clickToElement(driver, HomePageUI.SUBMENU_NOTEBOOK_LINK);
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("Product Review - Step 03: Click to Product Link");
		productPage.clickToElement(driver, ProductPageUI.PRODUCT_LINK);
		
		log.info("Product Review - Step 04: Click to Add review Link");
		productPage.clickToAddReviewLink(driver, ProductPageUI.REVIEW_LINK);
		
		log.info("Product Review - Step 05: Enter to Review title Input");
		productPage.sendkeyToElement(driver, ProductPageUI.REVIEW_TITLE_INPUT, "First review");
		
		log.info("Product Review - Step 06: Enter to Review text Input");
		productPage.sendkeyToElement(driver, ProductPageUI.REVIEW_TEXT_INPUT, "So bad");
		
		log.info("Product Review - Step 07: Click to Submit Button");
		productPage.clickToElement(driver, ProductPageUI.REVIEW_SUBMIT_BUTTON);
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
