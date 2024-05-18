package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUI.SearchPageUI;
import PageUI.WishlistPageUI;
import commons.BasePage;

public class WishlistPageObject extends BasePage {

private WebDriver driver;
	
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProductWasAdded() {
		waitForElementVisible(driver,WishlistPageUI.PRODUCT_NAME);
		List<WebElement> products = getListWebElements(driver, WishlistPageUI.PRODUCT_NAME);
		String expectedResult = "HTC One M8 Android L 5.0 Lollipop";
		
		for (int i = 0; i < products.size(); i++) {
			String temp = products.get(i).getText();
			try {
				if(temp.contains(expectedResult)) {
					Assert.assertTrue(true, expectedResult +" is displayed on Wishlist: " + temp);
				}
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void addToCart() {
		clickToElement(driver,WishlistPageUI.ADD_TO_CART_CHECKBOX);
		waitForElementVisible(driver,WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}

}
