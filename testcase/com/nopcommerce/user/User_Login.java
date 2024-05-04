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
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.clickToContinueButton();
	}
	
	public void TC_01_With_Empty_Data(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(driver, LoginPageUI.EMAIL_ERROR), "Please enter your email");
	}
	
	
	public void TC_02_With_Invalid_Email(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, invalidEmail);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(driver, LoginPageUI.EMAIL_ERROR), "Wrong email");
	}
	
	
	public void TC_03_With_Unregisted_Email(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, unregistedEmail);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(driver, LoginPageUI.UNREGISTED_EMAIL_ERROR), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	public void TC_04_With_Registed_Email_And_Pass_Non_Sendkey(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, "");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(driver, LoginPageUI.UNREGISTED_EMAIL_ERROR), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	public void TC_05_With_Registed_Email_And_Wrong_Pass(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, wrongPass);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(driver, LoginPageUI.UNREGISTED_EMAIL_ERROR), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void TC_06_Login_Successfully(){
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.sendkeyToElement(driver, LoginPageUI.EMAIL_INPUT, registedEmail);
		loginPage.sendkeyToElement(driver, LoginPageUI.PASSWORD_INPUT, validPassword);
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
		homePage.clickToHeaderLinkByName("Log out");
	}
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
