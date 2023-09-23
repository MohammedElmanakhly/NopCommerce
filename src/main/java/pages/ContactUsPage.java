package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);	
	}
	
	private By fullName = By.id("FullName");
	
	//private By email = By.id("Email");
	
	private By enquiry = By.id("Enquiry");
	
	private By submitButton = By.cssSelector("button.button-1.contact-us-button");
	
	public WebElement successMessage;
	
	public void contactUs(String fullNameTxt,String enquiryTxt) {
		sendKeys(fullName, fullNameTxt);
		//sendKeys(email, emailTxt);
		sendKeys(enquiry, enquiryTxt);
		clickButton(submitButton);
		successMessage = driver.findElement(By.cssSelector("div.result"));
	}

}
