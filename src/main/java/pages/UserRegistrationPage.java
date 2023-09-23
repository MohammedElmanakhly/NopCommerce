package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	private By gender = By.id("gender-male");

	private By firstName = By.id("FirstName");

	private By lastName = By.id("LastName");

	private By email = By.id("Email");

	private By password = By.id("Password");

	private By confirmPassword = By.id("ConfirmPassword");

	private By registerButton = By.id("register-button");
	
	public By continueButton =  By.linkText("Continue"); 

	public void userRegistration(String firstNameTxtBox, String lastNameTxtBox, String emailTxtBox,
			String passwordTxtBox) {
		clickButton(gender);
		sendKeys(firstName, firstNameTxtBox);
		sendKeys(lastName, lastNameTxtBox);
		sendKeys(email, emailTxtBox);
		sendKeys(password, passwordTxtBox);
		sendKeys(confirmPassword, passwordTxtBox);
		clickButton(registerButton);
	}
	
	

}
