package pageObjects;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageUI.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	HomePageObject homePage;
	
	RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getFirstNameErrorMessage() {		
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR);
	}
	
	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR);
	}
	
	public String getEmaileErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}
	
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR);
	}
	
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR);
	}
	
	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	public void getErrorFirstnameMessage() {
		String expectedString = "First name is required.";
		String actualString = getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR);
	}

	public Object getErrorLastnameMessage() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return isElementDisplayed(driver, RegisterPageUI.LASTNAME_ERROR);
	}

	public Object getErrorEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_ERROR);
	}

	public Object getErrorPasswordMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_ERROR);
	}

	public Object getErrorConfirmPasswordMessage() {
		waitForElementVisible(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR);
		return isElementDisplayed(driver, RegisterPageUI.COMFIRM_PASSWORD_ERROR);
	}

	public void sendkeyToEmailInput(WebDriver driver, String locator,String value) {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_INPUT);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, value);
	}

	public void verifyFirstNameErrorMessage(String locator) {
		String expectedMessage = "First name is required.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	public void verifyLastNameErrorMessage(String locator) {
		String expectedMessage = "Last name is required.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}
	public void verifyEmailErrorMessage(String locator) {
		String expectedMessage = "Email is required.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}
	public void verifyPasswordErrorMessage(String locator) {
		String expectedMessage = "Password is required.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}
	public void verifyConfirmPasswordErrorMessage(String locator) {
		String expectedMessage = "Password is required.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}

	public void verifyWrongEmailMessage(String locator) {
		String expectedMessage = "Please enter a valid email address.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}

	public void verifyRegisterSuccessMessage(String locator) {
		String expectedMessage = "Your registration completed";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);	
	}

	public void sendkeyToFirstNameInput(String locator, String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}

	public void sendkeyToPasswordInput(String locator, String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}
	public void sendkeyToLastNameInput(String locator, String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}
	public void sendkeyToEmailInput(String locator, String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}
	
	public void sendkeyToConfirmPassInput(String locator, String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}

	public void verifyAlreadyEmailMessage(String locator) {
		String expectedMessage = "Password must meet the following rules:\\nmust have at least 6 characters";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	public void verifyPassLessThan6Message(String locator) {
		String expectedMessage = "Password must meet the following rules:\\nmust have at least 6 characters";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	public void verifyCFPassNotMatchMessage(String locator) {
		String expectedMessage = "The password and confirmation password do not match.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
