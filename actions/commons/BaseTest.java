package commons;

import java.time.Duration;
//import java.util.List;
import java.util.Random;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;

import PageUI.RegisterPageUI;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

//import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
//	protected final Logger log = LogManager.getLogger(getClass());
	private WebDriver driverBaseTest;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	protected String validFirstName = "abc";
	protected String validLastName = "abc";
	protected static String validEmail = "abc"+ randomNumber() +"@abc.com";
	protected String validPassword = "123456";
	protected String validConfirmPassword = "123456";

	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			driverBaseTest = new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			driverBaseTest = new ChromeDriver();
		}else {
			driverBaseTest = new EdgeDriver();
		}
		driverBaseTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
		return driverBaseTest;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	
	public void preLogin() {
		homePage.clickToHeaderLinkByName("Register");
		
		registerPage = PageGeneratorManager.getRegisterPageObject(driverBaseTest);
		registerPage.sendkeyToElement(driverBaseTest, RegisterPageUI.FIRST_NAME_INPUT, validFirstName);
		registerPage.sendkeyToElement(driverBaseTest, RegisterPageUI.LAST_NAME_INPUT, validLastName);
		registerPage.sendkeyToElement(driverBaseTest, RegisterPageUI.EMAIL_INPUT, validEmail);
		registerPage.sendkeyToElement(driverBaseTest, RegisterPageUI.PASSWORD_INPUT, validPassword);
		registerPage.sendkeyToElement(driverBaseTest, RegisterPageUI.CONFIRM_PASSWORD_INPUT, validConfirmPassword);
		registerPage.clickRegisterButton();
		registerPage.clickToContinueButton();
	}
	
	public static int randomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	protected Object getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
