package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	private By friendEmail = By.id("FriendEmail");
	
	private By personalMessage = By.id("PersonalMessage");
	
	private By sendEmailButton = By.cssSelector("button.button-1.send-email-a-friend-button");
	
	public WebElement successMessage;

	public void emailFriend(String friendEmailTxt,String personalMessageTxt) {
		sendKeys(friendEmail, friendEmailTxt);
		sendKeys(personalMessage, personalMessageTxt);
		clickButton(sendEmailButton);
		successMessage = driver.findElement(By.cssSelector("div.result"));
	}
}
