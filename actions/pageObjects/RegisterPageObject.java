package pageObjects;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUI.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public String getRegisterFailMessage() {
//		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_MESSAGE_ERROR);
//		return getElementText(driver, RegisterPageUI.DYNAMIC_MESSAGE_ERROR);
//	}
	
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

	public String getWrongEmailMessage() {
		waitForElementVisibleNew(driver, RegisterPageUI.WRONG_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.WRONG_EMAIL_MESSAGE);
	}
	
	
	
	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

//	public void sendkeyToEmailInput() {
//		waitForElementVisible(driver, RegisterPageUI.EMAIL_INPUT);
//		sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, invalidEmail);
//	}

//	public void sendkeyToInput() {
//		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
//		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_INPUT, validLastName);
//		sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, validEmail);
//		sendkeyToElement(driver, RegisterPageUI.PASSWORD_INPUT,validPassword);
//		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
//	}

	public String getRegisterSuccessMessage() {
		WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Your registration completed']")));
//		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
	}
}
