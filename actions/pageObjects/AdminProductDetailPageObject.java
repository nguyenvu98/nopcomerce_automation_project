package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BaseMethod;

public class AdminProductDetailPageObject extends BaseMethod {

	WebDriver driver;
	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void isProductDetailPageVisible(String locator) {
		String expectedMessage = "Lenovo IdeaCentre 600 All-in-One PC";
		waitForElementVisible(driver, locator);
		String actualMessage = getElementText(driver,locator);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
