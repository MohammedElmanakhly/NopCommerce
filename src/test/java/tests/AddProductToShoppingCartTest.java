package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;

	String quantity = "3";
	String totalPrice = "$5,400.00";

	@Test(priority = 0)
	public void UserCanAddProductToShoppingCart() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToCart();
		productDetailsObject.openShoppingCartPage();
		shoppingCartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartObject.productNameIsDisplayed(productName));
	}

	@Test(dependsOnMethods = "UserCanAddProductToShoppingCart")
	public void UserCanUpdateProductQuantity() {
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.setProductQuantity(quantity);
		shoppingCartObject.updateShoppingCart();
		Assert.assertEquals(totalPrice, shoppingCartObject.totalPrice.getText());
	}

	@Test(dependsOnMethods = "UserCanUpdateProductQuantity")
	public void UserCanRemoveProductFromShoppingCart() {
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.removeProductFromShoppingCart();
		Assert.assertTrue(shoppingCartObject.shoppingCartIsEmpty.getText().contains("empty!"));
	}

}
