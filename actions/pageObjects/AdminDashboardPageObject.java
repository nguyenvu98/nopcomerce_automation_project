package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.AdminDashboardPageUI;
import commons.BaseMethod;

public class AdminDashboardPageObject extends BaseMethod {
	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToDynamicMenu(String pageName, String hrefLink) {
		waitForElementClickable(driver, AdminDashboardPageUI.DYNAMIC_NAV_LINK, pageName,hrefLink);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_NAV_LINK, pageName,hrefLink);		
	}
	
}
