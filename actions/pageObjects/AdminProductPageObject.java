package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUI.AdminProductPageUI;
import commons.BaseMethod;
import commons.BasePage;

public class AdminProductPageObject extends BaseMethod {
	WebDriver driver;
	public AdminProductPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void sendkeyToProductName(String productName) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_INPUT);
		sendkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_INPUT, productName);
		
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver,AdminProductPageUI.SEARCH_BUTTON);
		clickToElementByJS(driver, AdminProductPageUI.SEARCH_BUTTON);
	}
	public void selectCategoryDropdown(String value) {
		waitForElementClickable(driver,AdminProductPageUI.CATEGORY_DROPDOWN);
		selectInDropdownDefault(driver,AdminProductPageUI.CATEGORY_DROPDOWN , value);
	}
	public void isNonProductVisible(String locator) {
		String expectedMessage = "No data available in table";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);	
	}

	public void clickToSearchSubCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SEARCH_SUB_CHECKBOX);
		clickToElement(driver, AdminProductPageUI.SEARCH_SUB_CHECKBOX);
	}
	
	public void selectManufacturerDropdown(String value) {
		waitForElementClickable(driver,AdminProductPageUI.MANUFACTURER_DROPDOWN);
		selectInDropdownDefault(driver,AdminProductPageUI.MANUFACTURER_DROPDOWN , value);		
	}
	public void sendkeyToSKUInput(String productName) {
		waitForElementVisible(driver, AdminProductPageUI.SKU_INPUT);
		sendkeyToElement(driver, AdminProductPageUI.SKU_INPUT, productName);		
	}
	public void clickToGoButton() {
		waitForElementClickable(driver, AdminProductPageUI.GO_BUTTON);
		clickToElement(driver, AdminProductPageUI.GO_BUTTON);		
	}

}
