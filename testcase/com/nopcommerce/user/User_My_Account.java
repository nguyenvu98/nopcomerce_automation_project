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
import commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_My_Account extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressesPageObject addressesPage;
	private ChangePasswordPageObject changePasswordPage;
	private MyProductReviewPageObject myProductReviewPage;
	
	
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
		
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, validPassword);
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_01_Customer_Info(){
		homePage.clickToHeaderLinkByName("My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
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
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
