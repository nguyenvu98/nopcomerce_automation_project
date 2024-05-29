package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.DesktopPageUI;
import commons.BasePage;

public class DesktopPageObject extends BasePage{

	private WebDriver driver;
	public DesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickBuildYourComputerLink() {
		waitForElementClickable(driver,DesktopPageUI.BUILD_COMPUTER_LINK);
		clickToElement(driver, DesktopPageUI.BUILD_COMPUTER_LINK);
	}
	
}
