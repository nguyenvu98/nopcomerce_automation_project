package commons;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUI.BasePageUI;
import PageUI.CustomerInfoPageUI;
import pageObjects.PageGeneratorManager;


public class BasePage {
	
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	protected Duration Timeout = Duration.ofSeconds(50);
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToWeb(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToWeb(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshToWeb(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
		//driver.switchTo().alert().accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
		//driver.switchTo().alert().dismiss();
	}	
	
	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String keyToSend) {
		waitForAlertPresence(driver).sendKeys(keyToSend);
	}
	
	protected void switchWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	protected void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			driver.switchTo().window(id);
			String currentTitle = driver.getTitle();
			if(currentTitle.equals(title)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	protected By getByXpath(String locatorType) {
		return By.xpath(locatorType);
	}
	
	protected By getByLocatorType(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		}else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		}else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator is not support");
		}
		return by;
	}
	
	//get Dynamic Locator
	private String getDynamicXpath(String locatorType, String... values) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType,(Object[]) values);
		}
		return locatorType;
	}

	protected List<WebElement> getListWebElements(WebDriver driver, String locatorType){
		return driver.findElements(getByLocatorType(locatorType));
	}
	
	protected WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocatorType(locatorType));
	}
	
	protected WebElement getWebElement(WebDriver driver, String locatorType,String...values) {
		return driver.findElement(getByLocatorType(locatorType));
	}
	
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType,String... values) {
		getWebElement(driver, getDynamicXpath(locatorType, values)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String keyToSend) {
		WebElement element = getWebElement(driver, locatorType); 
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String keyToSend, String... values) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, values)); 
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	public String getSelectedItem(WebDriver driver, String locatorType ) {
		Select dropdown = new Select(getWebElement(driver, locatorType));
		return dropdown.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select dropdown = new Select(getWebElement(driver, locatorType));
		return dropdown.isMultiple();
	}
	
	public void selectInDropdownDefault(WebDriver driver, String locatorType, String value, String...values) {
		Select dropdown = new Select(getWebElement(driver, getDynamicXpath(locatorType, values)));
		dropdown.selectByVisibleText(value);
	}
	
	
	public void selectInDropdownCustom(WebDriver driver, String parentXpath, String childXpath, String expectedText) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocatorType(childXpath))); 
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	} 
	
	public String getHexaFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver,String locatorType){
		return getListWebElements(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver,String locatorType, String...values){
		return getListWebElements(driver, getDynamicXpath(locatorType, values)).size();
	}
	
	public void checkToCheckboxRadioDefault(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckboxRadioDefault(WebDriver driver,String locatorType,String...values) {
		WebElement element = getWebElement(driver, locatorType,values);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckboxRadioDefault(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	public boolean isElementUndisplayed(WebDriver driver,String locatorType) {
		return !getWebElement(driver, locatorType).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locatorType, String...values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver,String locatorType, String...values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	public boolean isElementEnabled(WebDriver driver,String locatorType, String...values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver,String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions actions = new Actions(driver);
		actions.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String...values) {
		Actions actions = new Actions(driver);
		actions.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, values)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, String locatorType, String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocatorType(getDynamicXpath(locatorType, values))));
	}

	protected void waitForElementVisibleNew(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locatorType)));
	}
	
	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocatorType(locatorType)));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locatorType,String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocatorType(getDynamicXpath(locatorType, values))));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocatorType(locatorType)));
	}
	
	protected void waitForElementInvisible(WebDriver driver, String locatorType,String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocatorType(getDynamicXpath(locatorType, values))));
	}
	
	
	protected void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocatorType(locatorType)));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locatorType)));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, String locatorType, String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, getDynamicXpath(locatorType, values))));
	}
	
	protected void waitForAllClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(locatorType)));
	}
	
	protected void waitForAllClickable(WebDriver driver, String locatorType, String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(getDynamicXpath(locatorType, values))));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(locatorType)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locatorType, String...values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(getDynamicXpath(locatorType, values))));
	}
	
	public static BasePage getPageGeneratorObject() {
		return new BasePage();
	}
	
	public BasePage openDynamicMyAccountPage(WebDriver driver, String pageName) {
		waitForAllClickable(driver, BasePageUI.DYNAMIC_PAGE_MY_ACCOUNT_PAGE, pageName);
		clickToElement(driver,BasePageUI.DYNAMIC_PAGE_MY_ACCOUNT_PAGE, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		case "Change password":
			return PageGeneratorManager.getChangePasswordPage(driver);
		case "My product review":
			return PageGeneratorManager.getMyProductReviewPage(driver);
		default:
			throw new RuntimeException("Invalid Page Name at My Account area");
		}
	}
	
	public static void clickToSideBarLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
	}
	
	public static void clickToSideBar(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator,(Object[]) params);	
	}
	
//	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
//		String filePath = GlobalConstants.UPLOAD_FILE;
//		String fullFileName = "";
//		for (String file : fileNames) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		getWebElement(driver, HomePageUploadUI.UPLOAD_FILE).sendKeys(fullFileName);
//	}
//	
//	public void clickUploadMultipleFile(WebDriver driver) {
//		List<WebElement> startButtons = getListWebElements(driver,HomePageUploadUI.BUTTON_UPLOAD);
//		for (WebElement startButton : startButtons) {
//			waitForAllClickable(driver, HomePageUploadUI.BUTTON_UPLOAD);
//			clickToElement(driver,HomePageUploadUI.BUTTON_UPLOAD);
//		}
//	}
	
	public String getErrorMessage(WebDriver driver, String xpathLocator) {
		WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement errMessage =  exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
		String acctualResult = errMessage.getText();
		return  acctualResult;
	}
	
	public void clickRadioButton(WebDriver driver, String locator, String value) {
		waitForElementClickable(driver, locator, value);
		clickToElement(driver, locator, value);
	}
	
	public void waitForLoadingInvisible(WebDriver driver, String locator) {
		waitForElementInvisible(driver, locator);
		isElementUndisplayed(driver, locator);
	}
}
