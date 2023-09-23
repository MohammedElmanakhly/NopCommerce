package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By registerLink = By.linkText("Register");

	private By loginLink = By.linkText("Log in");

	private By myAccountLink = By.linkText("My account");

	private By contactUsLink = By.linkText("Contact us");

	private By logoutLink = By.cssSelector("a.ico-logout");

	private WebElement electronicsDropdownList;

	private WebElement cellPhonesLink;

	private WebElement currencyDropdownList;

	public void openRegistrationPage() {
		clickButton(registerLink);
	}

	public void openLoginPage() {
		clickButton(loginLink);
	}

	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

	public void openContactUsPage() {
		scrollDown();
		clickButton(contactUsLink);
	}

	public void userLogout() {
		clickButton(logoutLink);
	}

	public void changeCurrency() {
		currencyDropdownList = driver.findElement(By.id("customerCurrency"));
		select = new Select(currencyDropdownList);
		select.selectByVisibleText("Euro");
	}

	public void hoverDropdownListAndSelectItem() {
		electronicsDropdownList = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(electronicsDropdownList);
		cellPhonesLink = driver.findElement(By.linkText("Cell phones"));
		action.moveToElement(cellPhonesLink);
		action.click().build().perform();
	}

}
