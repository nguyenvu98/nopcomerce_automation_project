package PageUI;

public class AdminProductPageUI {

	public static final String PRODUCT_NAME_INPUT = "xpath=//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON ="xpath=//button[@id='search-products']";
	public static final String DYNAMIC_INDEX_BY_COLUMN_NAME = "xpath=";
	public static final String DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//th[%s]//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//child::tr[%s]//td[contains(text(),'%s')]";
	public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='SearchCategoryId']";
	public static final String TABLE_MESSAGE = "xpath=//td[@class='dataTables_empty']";
	public static final String SEARCH_SUB_CHECKBOX ="xpath=//input[@id='SearchIncludeSubCategories']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";
	public static final String GO_BUTTON = "xpath=//button[contains(text(),'Go')]";
	public static final String SKU_INPUT= "xpath=//input[@id='GoDirectlyToSku']";

}
