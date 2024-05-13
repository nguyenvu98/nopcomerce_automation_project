package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageUI.SearchPageUI;
import commons.BasePage;

public class SearchPageObject extends BasePage{

	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyfResultOfRelativeName() {
		List<WebElement> products = getListWebElements(driver, SearchPageUI.PRODUCT_ITEM); 
		boolean product1Found = false;
		boolean product2Found = false;
    
		for (WebElement product : products) {
			if(product.getText().contains("lenovo")) {
				WebElement productNameElement = product.findElement(By.xpath("//h2[@class='product-title']"));
		        String productName = productNameElement.getText();
		        if (productName.equals("Lenovo IdeaCentre 600 All-in-One PC")) {
		            product1Found = true;
		        }
		        if (productName.equals("Lenovo ThinkPad X1 Carbon 4th Gen Laptop")) {
		            product2Found = true;
		        }
			}
		}
		Assert.assertFalse(product1Found,"Product 1 is not found in the search results");
        Assert.assertFalse(product2Found,"Product 2 is not found in the search results");
	}
	
	public void verifyfResultOfAbsoluteName() {
		List<WebElement> products = getListWebElements(driver, SearchPageUI.PRODUCT_ITEM); 
		boolean product1Found = false;
    
		for (WebElement product : products) {
			if(product.getText().contains("lenovo")) {
				WebElement productNameElement = product.findElement(By.xpath("//h2[@class='product-title']"));
		        String productName = productNameElement.getText();
		        if (productName.equals("Lenovo Thinkpad X1 Carbon Laptop")) {
		            product1Found = true;
		        }
			}
		}
		Assert.assertFalse(product1Found,"Product 1 is not found in the search results");
	}

	public String getEmptyErrorMessage() {
		waitForElementVisible(driver, SearchPageUI.EMPTY_ERROR_MESSAGE);
		return getElementText(driver, SearchPageUI.EMPTY_ERROR_MESSAGE);
	}

	public String getNoResultErrorMessage() {
		waitForElementVisible(driver, SearchPageUI.NO_RESULT_ERROR_MESSAGE);
		return getElementText(driver, SearchPageUI.NO_RESULT_ERROR_MESSAGE);	}

	public void selectDropdownCategories(WebDriver driver, String locator, String value) {
		Select selectCategory = new Select(getWebElement(driver, locator));
		selectCategory.selectByVisibleText(value);		
	}
	public void selectDropdownManufacturer(WebDriver driver, String locator, String value) {
		Select selectManufacturer = new Select(getWebElement(driver, locator));
		selectManufacturer.selectByVisibleText(value);		
	}

	public void verifyfResultOfSubCategory() {
		List<WebElement> products = getListWebElements(driver, SearchPageUI.PRODUCT_ITEM); 
		boolean product1 = false;
    
		for (WebElement product : products) {
			if(product.getText().contains("Apple Mackbook Pro 13-inch")) {
				WebElement productNameElement = product.findElement(By.xpath("//h2[@class='product-title']"));
		        String productName = productNameElement.getText();
		        if (productName.equals("Apple Mackbook Pro 13-inch")) {
		            product1 = true;
		        }
			}
		}
		Assert.assertFalse(product1,"Product 1 is not found in the search results");		
	}
}
