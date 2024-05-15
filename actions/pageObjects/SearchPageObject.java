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
		String expectedResult_1 = "Lenovo IdeaCentre 600 All-in-One PC";
		String expectedResult_2 = "Lenovo Thinkpad X1 Carbon Laptop";

    
		for (int i = 0; i < products.size(); i++) {
			String temp1 = products.get(i).getText();
			String temp2 = products.get(i++).getText();
			try {
				if(temp1.contains(expectedResult_1) && temp2.contains(expectedResult_2)) {
					Assert.assertTrue(true, expectedResult_1 +" is displayed on product title Product Title: " + temp1);
					Assert.assertTrue(true, expectedResult_2 +" is displayed on product title Product Title: " + temp2);
				}
			} catch (Exception e) {
				throw e;
			}
//			if(temp1.contains(expectedResult_1) && temp2.contains(expectedResult_2)) {
//				Assert.assertTrue(true, expectedResult_1 +" is displayed on product title Product Title: " + temp1);
//				Assert.assertTrue(true, expectedResult_2 +" is displayed on product title Product Title: " + temp2);
//			}	else {
//				Assert.assertFalse(false, expectedResult_1 + " is not displayed on product title Product Title: " + temp1);
//				Assert.assertFalse(false, expectedResult_2 + " is not displayed on product title Product Title: " + temp2);
//			}
		}
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
	

	public void verifyfResultOfSubCategories() {
		String expectedResult = "Apple MacBook Pro 13-inch";
		List<WebElement> products = getListWebElements(driver, SearchPageUI.PRODUCT_ITEM); 
    
		for (int i = 0; i < products.size(); i++) {
			String temp = products.get(i).getText();
			if(temp.contains(expectedResult)) {
				Assert.assertTrue(true, expectedResult +" is displayed on product title Product Title: " + temp);
			}else {
				Assert.assertTrue(false, expectedResult + " is not displayed on product title Product Title: " + temp);			}
		}
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

}
