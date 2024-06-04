package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageUI.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public void verifyEmptyEmailMessage(String locator) {
		String expectedMessage = "Please enter your email";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);				
	}

	public void verifyInvalidEmailMessage(String locator) {
		String expectedMessage = "Please enter a valid email address.";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);	
	}

	public void verifyUnregistedEmailMessage(String locator) {
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\\nNo customer account found";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);		
	}

	public void verifyRegistedEmaiNonSendkeyMessage(String locator) {
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\\nThe credentials provided are incorrect";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);	
	}

	public void verifyRegistedEmaiWrongPassMessage(String locator) {
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\\nThe credentials provided are incorrect";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);			
	}
}
