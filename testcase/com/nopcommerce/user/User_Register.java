package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.RegisterPageUI;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	public static String invalidEmail,validFirstName,validLastName,validEmail,validPassword,
	validConfirmPassword,alreadyExistEmail,passLessThan6Chars,invalidConfirmPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		homePage= new HomePageObject(driver);
		invalidEmail = "abc";
		validFirstName = "abc";
		validLastName = "abc";
		validEmail = "abc"+ randomNumber() +"@abc.com";
		validPassword = "123456";
		validConfirmPassword = "123456";
		alreadyExistEmail = validEmail;
		passLessThan6Chars="1";
		invalidConfirmPassword ="1234567";
	}

	@Test
	public void TC_01_With_Empty_Data(){		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.clickRegisterButton();
		registerPage.verifyFirstNameErrorMessage(RegisterPageUI.FIRSTNAME_ERROR);
		registerPage.verifyLastNameErrorMessage(RegisterPageUI.LASTNAME_ERROR);
		registerPage.verifyEmailErrorMessage(RegisterPageUI.EMAIL_ERROR);
		registerPage.verifyConfirmPasswordErrorMessage(RegisterPageUI.COMFIRM_PASSWORD_ERROR);
	}	

	@Test
	public void TC_02_With_Invalid_Email(){
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToEmailInput(driver, RegisterPageUI.EMAIL_INPUT,"abc");
		registerPage.clickRegisterButton();
		registerPage.verifyWrongEmailMessage(RegisterPageUI.EMAIL_ERROR);
	}
	
	@Test
	public void TC_03_Success(){
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToFirstNameInput(RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToLastNameInput(RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToEmailInput(RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToPasswordInput(RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToConfirmPassInput(RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.verifyRegisterSuccessMessage(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_04_Email_Already_Exist() {
		homePage.clickToHeaderLinkByName("Log out");
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToFirstNameInput(RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToLastNameInput(RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToEmailInput(RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToPasswordInput(RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToConfirmPassInput(RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.verifyAlreadyEmailMessage(RegisterPageUI.ALREADY_EXIST_EMAIL_MESSAGE);
	}
	
	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToFirstNameInput(RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToLastNameInput(RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToEmailInput(RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToPasswordInput(RegisterPageUI.PASSWORD_INPUT, passLessThan6Chars);
		registerPage.sendkeyToConfirmPassInput(RegisterPageUI.CONFIRM_PASSWORD_INPUT, passLessThan6Chars);
		registerPage.verifyPassLessThan6Message(RegisterPageUI.PASSWORD_ERROR);
	}
	

	@Test
	public void TC_06_Password_And_CFPassword_Not_Match() {
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToFirstNameInput(RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToLastNameInput(RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToEmailInput(RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToPasswordInput(RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToConfirmPassInput(RegisterPageUI.CONFIRM_PASSWORD_INPUT, invalidConfirmPassword);
		registerPage.verifyCFPassNotMatchMessage(RegisterPageUI.PASSWORD_ERROR);

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
