package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class NotebookPageObject extends BasePage {

	WebDriver driver;

	public NotebookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProductLink(WebDriver driver,String locator,String productName) {
		waitForElementClickable(driver,locator,productName);
		clickToElement(driver, locator,productName);
	}

	
}
