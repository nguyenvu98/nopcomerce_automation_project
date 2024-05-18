package pageObjects;

import org.openqa.selenium.WebDriver;

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

}
