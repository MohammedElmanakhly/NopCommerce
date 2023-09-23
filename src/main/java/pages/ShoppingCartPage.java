package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	private By removeButton = By.cssSelector("button.remove-btn");
	
	private By productQuantity = By.cssSelector("input.qty-input");
	
	private By updateShoppingCartButton = By.cssSelector("button.button-2.update-cart-button");
	
	WebElement productName;
	
	public WebElement shoppingCartIsEmpty;
	
	public WebElement totalPrice;
	
	private By termsOfServiceButton = By.id("termsofservice");
	
	private By checkOutButton = By.cssSelector("button.button-1.checkout-button");

	private By checkOutAsGuestButton = By.cssSelector("button.button-1.checkout-as-guest-button");
	
	public boolean productNameIsDisplayed(String productNameTxt){
		productName = driver.findElement(By.className("product-name"));
		return productName.getText().contains(productNameTxt);
	}
	
	public void removeProductFromShoppingCart() {
		clickButton(removeButton);
		shoppingCartIsEmpty = driver.findElement(By.cssSelector("div.no-data"));
	}
	
	public void updateShoppingCart() {
		clickButton(updateShoppingCartButton);
		totalPrice = driver.findElement(By.className("product-subtotal"));
	}
	
	public void setProductQuantity(String quantity) {
		clearTxt(productQuantity);
		sendKeys(productQuantity, quantity);
	}
	
	public void openGuestCheckOutPage() {
		clickButton(termsOfServiceButton);
		clickButton(checkOutButton);
		clickButton(checkOutAsGuestButton);
	}
	
	public void openRegisteredUserCheckOutPage() {
		clickButton(termsOfServiceButton);
		clickButton(checkOutButton);
	}
	

}
