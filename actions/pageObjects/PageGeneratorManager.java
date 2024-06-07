package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.HomePageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static AddressesPageObject getAddressPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	
	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}
	
	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}

	public static DesktopPageObject getDesktopPage(WebDriver driver) {
		return new DesktopPageObject(driver);
	}
	
	public static NotebookPageObject getNotebookPage(WebDriver driver) {
		return new NotebookPageObject(driver);
	}
	
	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public static ComparePageObject getComparePage(WebDriver driver) {
		return new ComparePageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminProductDetailPageObject getAdminProductDetailPageObject(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
}
