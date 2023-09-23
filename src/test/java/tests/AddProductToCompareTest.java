package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ComparePage compareObject;

	String partOfProduct1Name = "macB";
	String partOfProduct2Name = "Asus";

	@Test(priority = 0)
	public void UserCanAddProduct1ToCompareList() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProduct1Name);
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToCompareList();
	}

	@Test(dependsOnMethods = "UserCanAddProduct1ToCompareList")
	public void UserCanAddProduct2ToCompareList() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProduct2Name);
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToCompareList();
		productDetailsObject.openComparePage();
	}

	@Test(dependsOnMethods = "UserCanAddProduct2ToCompareList")
	public void UserCanCompareBetweenTwoProducts() {
		compareObject = new ComparePage(driver);
		compareObject.copmareTwoProducts();
		//Assert.assertTrue(compareObject.compareProductsTable.isDisplayed());
	}

	@Test(dependsOnMethods = "UserCanCompareBetweenTwoProducts")
	public void UserCanClearProductsCompareList() {
		compareObject = new ComparePage(driver);
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.compareListIsEmpty.getText().contains("You have no items to compare."));
	}

}
