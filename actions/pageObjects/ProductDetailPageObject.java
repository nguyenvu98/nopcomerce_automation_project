package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageUI.ProductDetailPageUI;
import commons.BasePage;

public class ProductDetailPageObject extends BasePage {

	private WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddWishListButton() {
		scrollToElement(driver,ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, ProductDetailPageUI.CLOSE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.CLOSE_BUTTON);
	}

	public void clickToWishlistLink() {
		waitForElementClickable(driver, ProductDetailPageUI.WISHLIST_LINK);
		clickToElement(driver, ProductDetailPageUI.WISHLIST_LINK);
	}

	public String getSuccessfullyMessage() {
		waitForElementVisible(driver, ProductDetailPageUI.SUCCESSFULLY_MESSAGE);
		return getElementText(driver, ProductDetailPageUI.SUCCESSFULLY_MESSAGE);
	}

	public void selectRAMByDropdown(WebDriver driver,String locator,String option) {
		Select selectOption = new Select(getWebElement(driver, locator));
		selectOption.selectByVisibleText(option);		
	}

	public void selectHDDRadioButton() {
		waitForElementClickable(driver, ProductDetailPageUI.HDD_RADIO_BUTTON);
		clickToElement(driver, ProductDetailPageUI.HDD_RADIO_BUTTON);		
	}

	public void clickAddToCartButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickTopbarShippingCart() {
		scrollToElement(driver, ProductDetailPageUI.SHOPPING_CART_LINK);
		waitForElementClickable(driver, ProductDetailPageUI.SHOPPING_CART_LINK);
		clickToElementByJS(driver, ProductDetailPageUI.SHOPPING_CART_LINK);		
	}

	public void selectProcessorByDropdown(WebDriver driver, String locator,String option) {
		Select selectOption = new Select(getWebElement(driver, locator));
		selectOption.selectByVisibleText(option);
	}

	public void selectOSRadioButton() {
		waitForElementClickable(driver, ProductDetailPageUI.OS_RADIO_BUTTON);
		clickToElement(driver, ProductDetailPageUI.OS_RADIO_BUTTON);
	}

	public void selectSoftwareCheckbox() {
		waitForElementClickable(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX);
		clickToElement(driver,ProductDetailPageUI.SOFTWARE_CHECKBOX, "Acrobat Reader [+$10.00]");
	}

	public void changeQuantity() {
		waitForElementVisible(driver,ProductDetailPageUI.QUANTITY_INPUT);
		sendkeyToElement(driver, ProductDetailPageUI.QUANTITY_INPUT,"3");
	}

	public void clickUpdateCartButton() {
		waitForElementClickable(driver, ProductDetailPageUI.UPDATE_BUTTON);
		clickToElement(driver,ProductDetailPageUI.UPDATE_BUTTON);
	}

	public String getMessageEmpty() {
		waitForElementVisible(driver, ProductDetailPageUI.CART_EMPTY_MESSAGE);
		return getElementText(driver, ProductDetailPageUI.CART_EMPTY_MESSAGE);
	}

}
