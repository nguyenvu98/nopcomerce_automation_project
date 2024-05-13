package PageUI;

public class ProductPageUI {

	public static final String SORT_DROPDOWN = "xpath=//div[@class='product-sorting']//select";
	public static final String SORT_DROPDOWN_OPTION = "xpath=//div[@class='product-sorting']//select//option[text()='Name: Z to A']";
	public static final String PRODUCT_NAME = "xpath=//h2[@class='product-title']";
	public static final String PRODUCT_LINK = "xpath=//div[@data-productid='4']//div[@class='picture']//a";
	public static final String REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String REVIEW_TITLE_INPUT = "xpath=//input[contains(@id,'Title')]";
	public static final String REVIEW_TEXT_INPUT = "xpath=//textarea[contains(@id,'ReviewText')]";
	public static final String MESSAGE_SUCCESS = "xpath=//p[@class='content']";
	public static final String REVIEW_SUBMIT_BUTTON = "xpath=//button[text()='Submit review']";
}
