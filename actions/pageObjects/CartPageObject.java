package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUI.CartPageUI;
import PageUI.ProductDetailPageUI;
import commons.BasePage;

public class CartPageObject extends BasePage {

	private WebDriver driver;
	
	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyShoppingCartWasUpdated() {
		int defaultNumber = 0;
		
	}
	
	public void verifyShoppingCartIsUpdate() {
		int defaultNumber = 0;
		WebElement actualQuantity = getWebElement(driver, CartPageUI.QUANTITY_PRODUCT);
		int temp = Integer.parseInt(actualQuantity.getText());
		System.out.println(temp);
		if(defaultNumber != temp) {
			Assert.assertTrue(true, temp +" Product was added to Shopping Cart");
		}

	}

	public void verifyProductWasAddedToCart() {
        WebElement cartQuantity = getWebElement(driver, ProductDetailPageUI.SHOPPING_CART_LABEL);
        String actualResult = "(1)";
        String cartQuantityText = cartQuantity.getText(); 
        try {
            if(cartQuantityText.contains(actualResult)) {
                Assert.assertEquals(actualResult, cartQuantityText, "The product was added to Shopping cart.");
            }	
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}

	public void editItemInCart() {
		waitForElementClickable(driver, CartPageUI.EDIT_BUTTON);
		clickToElement(driver,CartPageUI.EDIT_BUTTON);
	}

	public void verifyProductWasUpdateToCart() {
		String expectedProductName="Build your own computer";
		String expectedProductAttribute="Processor: 2.2 GHz Intel Pentium Dual-Core E2200"
				+ "RAM: 8GB [+$60.00]"+"HDD: 320 GB"+"OS: Vista Home [+$50.00]"+"Software: Microsoft Office [+$50.00]";
		
        WebElement productName = getWebElement(driver,CartPageUI.PRODUCT_NAME);
		WebElement productAttribute = getWebElement(driver,CartPageUI.PRODUCT_ATTRIBUTE);
		
		String actualProductName = productName.getText();
        String actualProductAttribute = productAttribute.getText();

        try {
            if (expectedProductName.equals(actualProductName) && expectedProductAttribute.equals(actualProductAttribute)) {
                Assert.assertEquals(actualProductName, expectedProductName, "The product Name was updated to Shopping cart.");
                Assert.assertEquals(actualProductAttribute, expectedProductAttribute, "The product Attributes was updated to Shopping cart.");
            }
		} catch (Exception e) {
			throw e;
		}
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, CartPageUI.REMOVE_BUTTON);
		clickToElement(driver,CartPageUI.REMOVE_BUTTON);
	}

	public void clickToAcceptCheckbox() {
		scrollToElement(driver, CartPageUI.TOTAL_INFO);
		waitForElementClickable(driver, CartPageUI.ACCEPT_CHECKBOX);
		clickToElement(driver, CartPageUI.ACCEPT_CHECKBOX);	
	}
	
	public void clickCheckoutButton() {
		waitForElementClickable(driver,CartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, CartPageUI.CHECKOUT_BUTTON);			
	}


}
