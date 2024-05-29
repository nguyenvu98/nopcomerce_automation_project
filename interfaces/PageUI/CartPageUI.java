package PageUI;

public class CartPageUI {

	public static final String QUANTITY_PRODUCT = "xpath=//span[text()='Shopping cart']//following-sibling::span[text()='(1)']";
	public static final String EDIT_BUTTON = "xpath=//div[@class='edit-item']//a";
	public static final String PRODUCT_NAME = "xpath=//a[@class='product-name']";
	public static final String PRODUCT_ATTRIBUTE = "xpath=//td[@class='product']//div[@class='attributes']";
	public static final String REMOVE_BUTTON = "xpath=//button[@class='remove-btn']";
	public static final String TOTAL_INFO = "xpath=//div[@class='cart-footer']//div[@class='totals']";
	public static final String ACCEPT_CHECKBOX = "xpath=//input[@id='termsofservice']";
	public static final String CHECKOUT_BUTTON ="xpath=//button[@id='checkout']";
	public static final String LOADING_BLOCK = "xpath=//div[contains(@class,'ajax-loading')]";
	
}
