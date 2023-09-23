package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
		
	private By changePasswordLink = By.linkText("Change password");

	public void openChangePasswordPage() {
		clickButton(changePasswordLink);
	}

}
