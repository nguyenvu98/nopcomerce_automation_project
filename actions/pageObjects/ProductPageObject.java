package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageUI.ProductPageUI;
import PageUI.SearchPageUI;
import commons.BasePage;

public class ProductPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver= driver;
	}

	public void selectSortByDropdown(WebDriver driver, String locator,String option) {
		Select selectOption = new Select(getWebElement(driver, locator));
		selectOption.selectByVisibleText(option);		
	}

	public void verifySortZToA(WebDriver driver,String locator) {
		List<WebElement> productElements =getListWebElements(driver, locator);
        List<String> sortedProductNames = new ArrayList<>();
        for (WebElement element : productElements) {
            sortedProductNames.add(element.getText());
        }	
        List<String> expectedSortedProductNames = new ArrayList<>(sortedProductNames);
        Collections.sort(expectedSortedProductNames,Collections.reverseOrder());
        Assert.assertEquals(sortedProductNames, expectedSortedProductNames, "Products were sorted correctly in ascending order by name.");    			
    }

	
	public void verifySortAToZ(WebDriver driver, String productName) {
		List<WebElement> products = getListWebElements(driver, SearchPageUI.PRODUCT_ITEM);
		List<String> originalList =  new ArrayList<String>();
		for (WebElement product : products) {
			originalList.add(product.getText());
		}
		List<String> expectedResultList = new ArrayList<String>(originalList);
		Collections.sort(expectedResultList);
		if (expectedResultList.equals(originalList)) {
            Assert.assertEquals(expectedResultList, originalList, "Products were sorted correctly in ascending order by name.");
		}
		
	}

	public void clickToAddReviewLink(WebDriver driver, String reviewLink) {
		waitForElementClickable(driver, ProductPageUI.REVIEW_LINK);
		clickToElement(driver, ProductPageUI.REVIEW_LINK);
	}

	public void verifySortLowToHigh(WebDriver driver, String locator) {
		List<WebElement> productPrices = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		List<Double> price =  new ArrayList<>();
		for (WebElement productPrice : productPrices) {
			price.add(Double.parseDouble(productPrice.getText().replace("$", "").replace(",", "")));
		}
		List<Double> expectedResultList = new ArrayList<Double>(price);
		Collections.sort(expectedResultList);
		System.out.println(expectedResultList);
		if (expectedResultList.equals(price)) {
            Assert.assertEquals(expectedResultList, price, "Products were sorted correctly in ascending order by name.");
		}
	}

	public void verifySortHighToLow(WebDriver driver, String locator) {
		List<WebElement> productPrices = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		List<Double> price =  new ArrayList<>();
		for (WebElement productPrice : productPrices) {
			price.add(Double.parseDouble(productPrice.getText().replace("$", "").replace(",", "")));
		}
		List<Double> expectedResultList = new ArrayList<Double>(price);
		Collections.sort(expectedResultList,Collections.reverseOrder());
		System.out.println(expectedResultList);
		if (expectedResultList.equals(price)) {
            Assert.assertEquals(expectedResultList, price, "Products were sorted correctly in ascending order by name.");
		}
	}

}
