package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ChangePasswordPage;

public class ChangePasswordTest extends TestBase {

	HomePage homeObject;
	ChangePasswordPage changePasswordObject;
	MyAccountPage myAccountObject;

	@Test(priority = 0)
	public void RegisteredUserCanChangePassword() {
		homeObject = new HomePage(driver);
		homeObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		changePasswordObject = new ChangePasswordPage(driver);
		changePasswordObject.ChangPassword(password, newPassword);
	}

	@Test(dependsOnMethods = "RegisteredUserCanChangePassword")
	public void RegisteredUserCanLogout() throws InterruptedException {
		homeObject = new HomePage(driver);
		Thread.sleep(3000);
		homeObject.userLogout();
	}

	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLoginWithNewPassword() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
	}

}
