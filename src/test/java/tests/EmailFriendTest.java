package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class EmailFriendTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailFriendPage emailFriendObject;

	String friendEmail = "MoatzFathy23@gmail.com";
	String personalMessage = "this product is highly recommended";
	String successMessageTxt = "Your message has been sent.";

	@Test(priority = 0)
	public void UserCanSearchForProductWithAutoSuggestScenario() {
		searchObject = new SearchPage(driver);
		searchObject.searchForProductAutoSuggestScenario(partOfProductName);
	}

	@Test(dependsOnMethods = "UserCanSearchForProductWithAutoSuggestScenario")
	public void UserCanEmailFriend() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openEmailFriendPage();
		emailFriendObject = new EmailFriendPage(driver);
		emailFriendObject.emailFriend(friendEmail, personalMessage);
		Assert.assertTrue(emailFriendObject.successMessage.getText().equals(successMessageTxt));
	}

}
