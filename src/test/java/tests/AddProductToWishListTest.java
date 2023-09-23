package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListObject;

	@Test(priority = 0)
	public void UserCanSearchForProductAutoSuggestScenario() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
	}

	@Test(dependsOnMethods = "UserCanSearchForProductAutoSuggestScenario")
	public void UserCanAddProductToWishList() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToWishList();
		productDetailsObject.openWishListPage();
		wishListObject = new WishListPage(driver);
		Assert.assertEquals(productName, wishListObject.productName.getText());
	}

	@Test(dependsOnMethods = "UserCanAddProductToWishList")
	public void UserCanRemoveProductFromWishList() {
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.wishListIsEmpty.getText().contains("empty!"));
	}

}
