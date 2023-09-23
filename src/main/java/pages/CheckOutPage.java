package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	private By firstName = By.id("BillingNewAddress_FirstName");

	private By lastName = By.id("BillingNewAddress_LastName");

	private By email = By.id("BillingNewAddress_Email");

	private WebElement country;

	private By city = By.id("BillingNewAddress_City");

	private By address = By.id("BillingNewAddress_Address1");

	private By postalCode = By.id("BillingNewAddress_ZipPostalCode");

	private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");

	private By continueNewAddressNextStepButton = By.cssSelector("button.button-1.new-address-next-step-button");

	private By shippingMethodNextStepButton = By.cssSelector("button.button-1.shipping-method-next-step-button");

	private By paymentMethodNextStepButton = By.cssSelector("button.button-1.payment-method-next-step-button");

	private By paymentInfoNextStepButton = By.cssSelector("button.button-1.payment-info-next-step-button");

	private By confirmOrderNextStepButton = By.cssSelector("button.button-1.confirm-order-next-step-button");

	public WebElement orderNumber;

	private By orderDetailsLink = By.linkText("Click here for order details.");

	public void guestCheckOut(String firstNameTxt, String lastNameTxt, String emailTxt, String cityTxt, String addressTxt,
			String postalCodeTxt, String phoneNumberTxt) {
		sendKeys(firstName, firstNameTxt);
		sendKeys(lastName, lastNameTxt);
		sendKeys(email, emailTxt);
		country = driver.findElement(By.name("BillingNewAddress.CountryId"));
		select = new Select(country);
		select.selectByVisibleText("Egypt");
		sendKeys(city, cityTxt);
		sendKeys(address, addressTxt);
		sendKeys(postalCode, postalCodeTxt);
		sendKeys(phoneNumber, phoneNumberTxt);
		clickButton(continueNewAddressNextStepButton);
		clickButton(shippingMethodNextStepButton);
		clickButton(paymentMethodNextStepButton);
		clickButton(paymentInfoNextStepButton);
		clickButton(confirmOrderNextStepButton);
		orderNumber = driver.findElement(By.cssSelector("div.order-number"));
	}

	public void registeredUserCheckOut(String cityTxt, String addressTxt,
			             String postalCodeTxt, String phoneNumberTxt) {
		country = driver.findElement(By.name("BillingNewAddress.CountryId"));
		select = new Select(country);
		select.selectByVisibleText("Egypt");
		sendKeys(city, cityTxt);
		sendKeys(address, addressTxt);
		sendKeys(postalCode, postalCodeTxt);
		sendKeys(phoneNumber, phoneNumberTxt);
		clickButton(continueNewAddressNextStepButton);
		clickButton(shippingMethodNextStepButton);
		clickButton(paymentMethodNextStepButton);
		clickButton(paymentInfoNextStepButton);
		clickButton(confirmOrderNextStepButton);
		orderNumber = driver.findElement(By.cssSelector("div.order-number"));
	}

	public void openOrderDetailsPage() {
		clickButton(orderDetailsLink);
	}
}
