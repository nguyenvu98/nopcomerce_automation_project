package PageUI;

public class RegisterPageUI {
	public static final String FIRSTNAME_ERROR = "xpath=//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR = "xpath=//span[@id='Password-error']";
	public static final String COMFIRM_PASSWORD_ERROR = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String ALREADY_EXIST_EMAIL_MESSAGE = "xpath=//div[contains(@class,'validation-summary-errors')]//ul//li";	
	public static final String PASSWORD_LESS_THAN_6CHARS = "";

	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String DYNAMIC_MESSAGE_ERROR = "xpath=//span[@class='field-validation-error']//span[contains(string(),'%s is required.')]";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[text()='Your registration completed']";
	public static final String CONTINUE_BUTTON = "xpath=//a[text()='Continue']";
	
	public static final String FIRST_NAME_INPUT = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_INPUT = "xpath=//input[@id='LastName']";
	public static final String EMAIL_INPUT = "xpath=//input[@id='Email']";
	public static final String PASSWORD_INPUT = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_INPUT = "xpath=//input[@id='ConfirmPassword']";
	public static final String LOGOUT_LINK = "xpath=//div[@class='header-links']//li//a[contains(string(),'Log out')]";

}
