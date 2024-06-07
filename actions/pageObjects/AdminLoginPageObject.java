package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.AdminLoginPageUI;
import commons.BaseMethod;
import commons.BasePage;

public class AdminLoginPageObject extends BaseMethod {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void sendkeyToEmailInput(String value) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_INPUT);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_INPUT, value);
	}
	public void sendkeyToPasswordInput(String value) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_INPUT);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_INPUT, value);		
	}
	public void clickToLoginBUtton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElementByJS(driver, AdminLoginPageUI.LOGIN_BUTTON);
		
	}

	
}
