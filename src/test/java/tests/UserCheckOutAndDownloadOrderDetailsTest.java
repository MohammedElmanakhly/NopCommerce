package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class UserCheckOutAndDownloadOrderDetailsTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkOutObject;
	OrderDetailsPage orderDetailsObject;

	@Test(priority = 0)
	public void RegisteredUserCanSearchForProduct() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
	}

	@Test(dependsOnMethods = "RegisteredUserCanSearchForProduct")
	public void RegisteredUserCanAddProductToCart() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToCart();
		productDetailsObject.openShoppingCartPage();
	}

	@Test(dependsOnMethods = "RegisteredUserCanAddProductToCart")
	public void RegisteredUserCanCheckOut() {
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.openRegisteredUserCheckOutPage();
		checkOutObject = new CheckOutPage(driver);
		checkOutObject.registeredUserCheckOut(city, address, postalCode, phoneNumber);
		Assert.assertTrue(checkOutObject.orderNumber.getText().contains("ORDER NUMBER:"));
		checkOutObject.openOrderDetailsPage();
	}

	@Test(dependsOnMethods = "RegisteredUserCanCheckOut")
	public void RegisteredUserCanDownloadOrderDetails() {
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.downloadPDFInvoice();
	}

}
