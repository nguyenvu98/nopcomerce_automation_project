package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.CheckoutPageUI;
import commons.BasePage;

public class CheckoutPageObject extends BasePage {
	WebDriver driver;
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void sendkeyToFirstNameInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);
	}
	public void sendkeyToLastNameInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}
	public void sendkeyToEmailInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);		
	}
	public void sendkeyToCompanyInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);				
	}
	public void selectCountry(String locator, String value) {
		waitForElementVisible(driver,locator);
		selectInDropdownDefault(driver, locator, value);
	}
	public void selectState(String locator, String value) {
		waitForElementVisible(driver,locator);
		selectInDropdownDefault(driver, locator, value);
	}
	public void sendkeyToCityInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);			
	}
	public void sendkeyToAddressInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);			
	}
	public void sendkeyToZipCodeInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);			
	}
	public void sendkeyToFaxInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);			
	}
	public void sendkeyToPhoneInput(String locator,String value) {
		waitForElementVisible(driver,locator);
		sendkeyToElement(driver, locator, value);			
	}
	public void clickToContinueButton(String locator) {
		waitForElementClickable(driver, locator);
		clickToElementByJS(driver, locator);
	}

}
