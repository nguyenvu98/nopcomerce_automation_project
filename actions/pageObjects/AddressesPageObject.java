package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageUI.AddressesPageUI;
import PageUI.CustomerInfoPageUI;
import commons.BasePage;

public class AddressesPageObject extends BasePage {
	private WebDriver driver;
	
	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDropdownCountry(WebDriver driver2, String locator, String value) {
		Select selectDay = new Select(getWebElement(driver, locator));
		selectDay.selectByVisibleText(value);		
	}

	public boolean verifySuccessMessage(String message) {
		waitForElementVisible(driver,AddressesPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, AddressesPageUI.SUCCESS_MESSAGE);
	}

}
