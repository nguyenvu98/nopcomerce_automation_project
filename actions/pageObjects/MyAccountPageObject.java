package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.BasePageUI;
import commons.BasePage;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToBlockNavigationLinkByName(String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_MY_ACCOUNT_PAGE, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_MY_ACCOUNT_PAGE, pageName);
	}
}
