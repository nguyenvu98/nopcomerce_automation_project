package PageUI;

public class HomePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']"; 
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";

	public static final String DYNAMIC_HEADER_LINK = "xpath=//div[@class='header-links']//a[contains(string(),'%s')]";
	public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer-upper']//div[@class='footer-block customer-service']//ul//li[contains(string(),'%s')]//a";
	public static final String TOPMENU_COMPUTER_LINK = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//li//a[text()='Computers ']";
	public static final String SUBMENU_NOTEBOOK_LINK = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//li//a[text()='Computers ']//following-sibling::ul//li//a[text()='Notebooks ']";
}
