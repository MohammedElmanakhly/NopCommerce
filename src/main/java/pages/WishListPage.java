package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	private By removeButton = By.className("remove-btn");
	
	public WebElement productName = driver.findElement(By.cssSelector("a.product-name"));
	
	//private By updateWishListButton = By.className("button-2.update-wishlist-button");
	
	public WebElement wishListIsEmpty;
	
	public void removeProductFromWishList() {
		clickButton(removeButton);
		wishListIsEmpty = driver.findElement(By.cssSelector("div.no-data"));
	}
}
