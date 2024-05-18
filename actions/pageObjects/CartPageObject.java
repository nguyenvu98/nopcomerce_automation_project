package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUI.CartPageUI;
import commons.BasePage;

public class CartPageObject extends BasePage {

	private WebDriver driver;
	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void verifyShoppingCartIsUpdate() {
		int defaultNumber = 0;
		WebElement actualQuantity = getWebElement(driver, CartPageUI.QUANTITY_PRODUCT,"1");
		int temp = Integer.parseInt(actualQuantity.getText());
		if(defaultNumber != temp) {
			Assert.assertTrue(true, temp +" Product was added to Shopping Cart");
		}

	}

}
