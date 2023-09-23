package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	private By emailFriendButton = By.cssSelector("button.button-2.email-a-friend-button");
	
	WebElement productNameBreadCrumb;
	
	WebElement productPrice;
	
	private By addYourReviewLink = By.linkText("Add your review");
	
	private By addToWishListButton = By.id("add-to-wishlist-button-4");
	
	private By wishListLink = By.linkText("wishlist");
	
	private By comparePageLink = By.linkText("product comparison");
	
	private By addToCompareListButton = By.className("compare-products");
	
	private By addToCartButton = By.cssSelector("button.button-1.add-to-cart-button");
	
	private By shoppingCartLink = By.linkText("shopping cart");
	
	public void openEmailFriendPage() {
		clickButton(emailFriendButton);
	}
	
	public void openProductReviewPage() {
		clickButton(addYourReviewLink);
	}

	public void addProductToWishList() {
		clickButton(addToWishListButton);
	}
	
	public void addProductToCompareList() {
		clickButton(addToCompareListButton);
	}
	
	public void openWishListPage() {
		clickButton(wishListLink);
	}
	
	public void openComparePage() {
		clickButton(comparePageLink);
	}
	
	public void addProductToCart() {
		clickButton(addToCartButton);
	}
	
	public void openShoppingCartPage() {
		clickButton(shoppingCartLink);
	}
	
	public boolean checkProductNameBreadCrumbIsDisplayed(String productName) {
		productNameBreadCrumb = driver.findElement(By.cssSelector("strong.current-item"));
		return productNameBreadCrumb.getText().contains(productName);
	}
	
	public boolean checkProductPriceIsDisplayed(String currency) {
		productPrice = driver.findElement(By.cssSelector("span.price-value-4"));
		return productPrice.getText().contains(currency);
	}
	
}
