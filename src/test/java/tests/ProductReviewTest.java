package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;

public class ProductReviewTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ProductReviewPage productReviewObject;

	String reviewTitleTxt = "reviewing mac book 13";
	String reviewTxt = "this is an amazin laptop and it is suitable for graghic designers";
	String successMessageTxt = "Product review is successfully added.";

	@Test(priority = 0)
	public void UserCanSearchForProductUsingAutoSuggestScenario() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
	}

	@Test(dependsOnMethods = "UserCanSearchForProductUsingAutoSuggestScenario")
	public void OnlyRegisteredUserCanAddProductReview() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openProductReviewPage();
		productReviewObject = new ProductReviewPage(driver);
		productReviewObject.addProductReview(reviewTitleTxt, reviewTxt);
		Assert.assertEquals(successMessageTxt, productReviewObject.successMessage.getText());
	}

}
