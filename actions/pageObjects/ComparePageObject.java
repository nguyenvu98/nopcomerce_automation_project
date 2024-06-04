package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BaseMethod;

public class ComparePageObject extends BaseMethod{
	WebDriver driver;
	public ComparePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void compareTwoProducts() {
		String[] productName = new String[]{"Apple MacBook Pro 13-inch","Asus N551JK-XO076H Laptop"};
		String[] productPrice = new String[]{"180000","150000"};
		WebElement nameElement =  getWebElement(driver, null);
		

	}

}
