package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUI.AdminProductDetailPageUI;
import PageUI.AdminProductPageUI;

import commons.BaseTest;
import pageObjects.AdminDashboardPageObject;
import pageObjects.AdminLoginPageObject;
import pageObjects.AdminProductDetailPageObject;
import pageObjects.AdminProductPageObject;

import pageObjects.PageGeneratorManager;

public class Admin_Search extends BaseTest {
	private WebDriver driver;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminProductPageObject adminProductPage;
	private AdminProductDetailPageObject adminProductDetailPage;
	private	String email = "admin@yourstore.com";
	private	String password = "admin";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriverAtAdmin(browser);
		adminLoginPage = new AdminLoginPageObject(driver);	
		
		adminLoginPage.sendkeyToEmailInput(email);
		adminLoginPage.sendkeyToPasswordInput(password);
		adminLoginPage.clickToLoginBUtton();
		
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	@Test
	public void TC_01_Search_With_Product_Name(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductPage.clickToSearchButton();	
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Product name", "1","Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("SKU", "1","LE_IC_600"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Price", "1","500"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Stock quantity","1","10000"));
	}
	
	@Test
	public void TC_02_Search_With_Product_Name_And_Parent_Category_Noncheck(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductPage.selectCategoryDropdown("Computers");
		adminProductPage.clickToSearchButton();	
		adminProductPage.isNonProductVisible(AdminProductPageUI.TABLE_MESSAGE);
	}
	
	@Test
	public void TC_03_Search_With_Product_Name_And_Parent_Category_Check(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductPage.selectCategoryDropdown("Computers");
		adminProductPage.clickToSearchSubCheckbox();
		adminProductPage.clickToSearchButton();	
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Product name", "1","Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("SKU", "1","LE_IC_600"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Price", "1","500"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Stock quantity","1","10000"));
	}

	
	@Test
	public void TC_04_Search_With_Product_Name_And_Child_Category(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductPage.selectCategoryDropdown("Computers >> Desktops");
		adminProductPage.clickToSearchButton();	
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Product name", "1","Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("SKU", "1","LE_IC_600"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Price", "1","500"));
		Assert.assertTrue(adminProductPage.isValueDisplayedAtColumnName("Stock quantity","1","10000"));
	}
	
	@Test
	public void TC_05_Search_With_Product_Name_And_Manufacturer(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		adminProductPage.selectCategoryDropdown("All");
		adminProductPage.selectManufacturerDropdown("Apple");
		adminProductPage.clickToSearchButton();	
		adminProductPage.isNonProductVisible(AdminProductPageUI.TABLE_MESSAGE);

	}
	
	
	@Test
	public void TC_06_Go_Directly_To_SKU(){
		adminDashboardPage.clickToDynamicMenu("Catalog","/Admin/Setting/Catalog");
		adminDashboardPage.clickToDynamicMenu("Products", "/Admin/Report/NeverSold");
		
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
		adminProductPage.sendkeyToSKUInput("LE_IC_600");
		adminProductPage.clickToGoButton();	
		
		adminProductDetailPage = PageGeneratorManager.getAdminProductDetailPageObject(driver);
		adminProductDetailPage.isProductDetailPageVisible(AdminProductDetailPageUI.PRODUCT_DETAIL_NAME);
	}
	
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
