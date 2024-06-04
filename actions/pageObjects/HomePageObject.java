package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.HomePageUI;
import PageUI.ProductDetailPageUI;
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

	public void clickToFooterLinkByName(String pageName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, HomePageUI.DYNAMIC_FOOTER_LINK, pageName);		
	}

	public void scollToFooterLink() {
		WebElement footer =  driver.findElement(By.xpath("//div[@class='footer']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",footer);		
	}

	public void clickToProductLink() {
		scrollToElement(driver,HomePageUI.PRODUCT_HOMEPAGE_LINK);
		clickToElement(driver, HomePageUI.PRODUCT_HOMEPAGE_LINK);
	}

	public void clickToCompareAtHomepage() {
		scrollToElement(driver,HomePageUI.PRODUCT_HOMEPAGE_TITLE);
		clickToElement(driver,HomePageUI.COMPARE_BUTTON);

	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, ProductDetailPageUI.CLOSE_BUTTON);
		clickToElementByJS(driver, ProductDetailPageUI.CLOSE_BUTTON);		
	}

	public void clickToCompareProductList() {
		waitForElementClickable(driver, HomePageUI.COMPARE_PRODUCT_LIST_LINK);
		clickToElementByJS(driver, HomePageUI.COMPARE_PRODUCT_LIST_LINK);	
		
	}
	
	
}
