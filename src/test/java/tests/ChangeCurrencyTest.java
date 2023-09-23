package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;

	String currency = "€";

	@Test
	public void UserCanChangeCurrency() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.checkProductPriceIsDisplayed(currency));
	}

}
