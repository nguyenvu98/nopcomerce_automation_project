package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openRegisterPage(WebDriver driver) {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_HEADER_LINK, pageName);
		clickToElement(driver, HomePageUI.DYNAMIC_HEADER_LINK, pageName);
	}
	
	
}
