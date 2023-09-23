package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends PageBase {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	private String productLinkText = "Apple MacBook Pro 13-inch";
	
	private By productLink = By.linkText(productLinkText);
	
	public void openProductDetailsPage() {
		clickButton(productLink);
	}

}
