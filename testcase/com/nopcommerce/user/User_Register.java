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
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.FIRSTNAME_ERROR), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.LASTNAME_ERROR), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.EMAIL_ERROR), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.PASSWORD_ERROR), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR), "Password is required.");

}	
	@Test
	public void TC_02_With_Invalid_Email(){
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT,invalidEmail);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.WRONG_EMAIL_MESSAGE), "Wrong email");
	}
	
	@Test
	public void TC_03_Success(){
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_04_Email_Already_Exist() {
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.ALREADY_EXIST_EMAIL_MESSAGE), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, passLessThan6Chars);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, passLessThan6Chars);
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.PASSWORD_ERROR), 
				"Password must meet the following rules:\nmust have at least 6 characters");
	}
	

	@Test
	public void TC_06_Password_And_CFPassword_Not_Match() {
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		registerPage.sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, alreadyExistEmail);
		registerPage.sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, invalidConfirmPassword);
		Assert.assertEquals(registerPage.getErrorMessage(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR), 
				"The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
