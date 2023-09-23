package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends PageBase {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}
		
	private By oldPassword = By.id("OldPassword");
	
	private By newPassword = By.id("NewPassword");
	
	private By confirmNewPassword = By.id("ConfirmNewPassword");
	
	private By changePasswordButton = By.cssSelector("button.button-1.change-password-button");
	
	private By closeSuccessToaster = By.cssSelector("span.close");
	
	
	public void closeSuccessToaster() {
		clickButton(closeSuccessToaster);
	}
	
	public void ChangPassword(String oldPasswordTxt ,String newPasswordTxt ) {
		sendKeys(oldPassword, oldPasswordTxt);
		sendKeys(newPassword, newPasswordTxt);
		sendKeys(confirmNewPassword, newPasswordTxt);
		clickButton(changePasswordButton);
		closeSuccessToaster();
	}

}
