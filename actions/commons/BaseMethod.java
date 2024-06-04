package commons;

import org.openqa.selenium.WebDriver;

import PageUI.HomePageUI;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;

public class BaseMethod extends BasePage {
	HomePageObject homePage;
	WebDriver driver;
	public void clickToDynamicHeaderLink(String pageName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_HEADER_LINK, pageName);
		clickToElement(driver, HomePageUI.DYNAMIC_HEADER_LINK, pageName);
	}
	
	public void clickToHomeLogoButton() {
		waitForElementClickable(driver, HomePageUI.HOME_LINK);
		clickToElementByJS(driver, HomePageUI.HOME_LINK);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}
}
