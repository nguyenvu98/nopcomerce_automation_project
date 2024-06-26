package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.LoginPageUI;
import PageUI.RegisterPageUI;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_Login extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
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
		registerPage.sendkeyToFirstNameInput(RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToLastNameInput(RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToEmailInput(RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToPasswordInput(RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToConfirmPassInput(RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.clickToContinueButton();
		homePage.clickToHeaderLinkByName("Log out");	
	}
	
	@Test
	public void TC_01_With_Empty_Data(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Click to Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 03: Verify error message");
		loginPage.verifyEmptyEmailMessage(LoginPageUI.EMAIL_ERROR);
	}
	
	@Test
	public void TC_02_With_Invalid_Email(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Enter invalid Email to Email input");
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, invalidEmail);
		
		log.info("Login - Step 03: Click to Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify error message");
		loginPage.verifyInvalidEmailMessage(LoginPageUI.EMAIL_ERROR);
	}
	
	@Test
	public void TC_03_With_Unregisted_Email(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Enter unregisted Email to Email input");
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, unregistedEmail);
		
		log.info("Login - Step 03: Click to Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 04: Verify error message");
		loginPage.verifyUnregistedEmailMessage(LoginPageUI.EMAIL_ERROR);
	}
	
	@Test
	public void TC_04_With_Registed_Email_And_Pass_Non_Sendkey(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Enter registed Email to Email input");
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		
		log.info("Login - Step 03: Enter non sendkey Pass to Password input");
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, "");
		
		log.info("Login - Step 04: Click to Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 05: Verify error message");
		loginPage.verifyRegistedEmaiNonSendkeyMessage(LoginPageUI.EMAIL_ERROR);
	}
	
	public void TC_05_With_Registed_Email_And_Wrong_Pass(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Enter registed Email to Email input");
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		
		log.info("Login - Step 03: Enter non wrong Pass to Password input");
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, wrongPass);
		
		log.info("Login - Step 04: Click to Login Button");
		loginPage.clickLoginButton();
		
		log.info("Login - Step 05: Verify error message");
		loginPage.verifyRegistedEmaiWrongPassMessage(LoginPageUI.EMAIL_ERROR);
	}
	
	@Test
	public void TC_06_Login_Successfully(){
		log.info("Login - Step 01: Navigate to Login Page");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Login - Step 02: Enter registed Email to Email input");
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		
		log.info("Login - Step 03: Enter valid Pass to Password input");
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, validPassword);
		
		log.info("Login - Step 04: Click to Login Button");
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
		
		log.info("Login - Step 04: Click to Logout Button");
		homePage.clickToHeaderLinkByName("Log out");
	}
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
