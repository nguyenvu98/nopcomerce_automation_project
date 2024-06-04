package PageUI;

public class HomePageUI {
	public static final String HOME_LINK = "xpath=//div[@class='header-logo']//a//img";

	
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']"; 
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";

	public static final String DYNAMIC_HEADER_LINK = "xpath=//div[@class='header-links']//li//a[contains(string(),'%s')]";
	public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer-upper']//div[@class='footer-block customer-service']//ul//li[contains(string(),'%s')]//a";
	public static final String TOPMENU_COMPUTER_LINK = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//li//a[text()='Computers ']";
	public static final String SUBMENU_NOTEBOOK_LINK = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//li//a[text()='Computers ']//following-sibling::ul//li//a[text()='Notebooks ']";
	public static final String PRODUCT_HOMEPAGE_LINK = "xpath=//div[@class='product-item' and @data-productid='18']";
	public static final String SUBMENU_DESKTOP_LINK = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//li//a[text()='Computers ']//following-sibling::ul//li//a[text()='Desktops ']";


	public static final String SHOPPING_CART_LINK = "xpath=//li[@id='topcartlink']";
	public static final String SEARCH_INPUT = "xpath=//input[@id='small-searchterms']";


	public static final String COMPARE_BUTTON = "xpath=//div[@class='item-box'][2]//button[contains(@class,'add-to-compare')]";


	public static final String PRODUCT_HOMEPAGE_TITLE = "xpath=//h2[@class='product-title']";


	public static final String COMPARE_PRODUCT_LIST_LINK = "xpath=//a[text()='Compare products list']";
}
