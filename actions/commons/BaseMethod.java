package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.AdminProductPageUI;
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
	
	public boolean isValueDisplayedAtColumnName(String columnName, String rowIndex,String rowValue) {
		int columnIndex = getListElementSize(driver,AdminProductPageUI.DYNAMIC_INDEX_BY_COLUMN_NAME,columnName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX,String.valueOf(columnIndex),rowIndex,rowValue);
	}

}
