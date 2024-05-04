package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageUI.ProductPageUI;
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
        Collections.sort(expectedSortedProductNames);
        
        Assert.assertEquals(sortedProductNames, expectedSortedProductNames, "Products were sorted correctly in ascending order by name.");
	}

}
