package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homeObject;
	ContactUsPage contactUsObject;

	String fullNameTxt = "Mohamed Farag Elmanakhly";
	//String emailTxt = "elmanakhlym22@gmail.com";
	String enquiryTxt = "this is for test";
	String successMessageTxt = "Your enquiry has been successfully sent to the store owner.";

	@Test
	public void UserCanContactUs() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(fullNameTxt,enquiryTxt);
		Assert.assertTrue(contactUsObject.successMessage.getText().contains(successMessageTxt));
	}
}
