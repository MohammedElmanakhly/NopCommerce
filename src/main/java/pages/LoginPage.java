package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By email = By.id("Email");

	private By password = By.id("Password");
	
	private By loginButton = By.cssSelector("button.button-1.login-button");
	
	
	
	public void UserLogin(String emailTxt, String passwordTxt) {
		sendKeys(email, emailTxt);
		sendKeys(password, passwordTxt);
		clickButton(loginButton);
	}
	
	


}
