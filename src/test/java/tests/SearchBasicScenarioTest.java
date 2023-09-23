package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchBasicScenarioTest extends TestBase {

	SearchPage searchObject;
	SearchResultPage searchResultObject;
	ProductDetailsPage productDetailsObject;

	@Test
	public void UserCanSearchForProductBasicScenario() {

		searchObject = new SearchPage(driver);
		searchObject.searchForProductBasicScenario(productName);
		searchResultObject = new SearchResultPage(driver);
		searchResultObject.openProductDetailsPage();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.checkProductNameBreadCrumbIsDisplayed(productName));

	}

}
