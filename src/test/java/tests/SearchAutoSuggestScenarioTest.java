package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchAutoSuggestScenarioTest extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;

	@Test
	public void UserCanSearchForProductAutoSuggestScenario() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.checkProductNameBreadCrumbIsDisplayed(productName));
	}

}
