package PageUI;

public class LoginPageUI {

	public static final String EMAIL_INPUT = "xpath=//input[@id='Email']";
	public static final String PASSWORD_INPUT = "xpath=//input[@id='Password']";
	public static final String LOGIN_BUTTON = "xpath=//button[@class='button-1 login-button']";
	
	public static final String EMAIL_ERROR = "xpath=//span[@class='field-validation-error']//span[@id='Email-error']";
	public static final String UNREGISTED_EMAIL_ERROR = "xpath=//div[contains(@class,'message-error')]";
}
