package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	private By searchTxtBox = By.cssSelector("input#small-searchterms");
	
	private By searchButton = By.cssSelector("button.button-1.search-box-button");
	
	private List<WebElement> productList = driver.findElements(By.id("ui-id-1"));
	
	  
	public void searchForProductBasicScenario(String productName) {
		sendKeys(searchTxtBox, productName);
		clickButton(searchButton);
	}

	public void searchForProductAutoSuggestScenario(String partOfProductName) {
		sendKeys(searchTxtBox, partOfProductName);
		productList.get(0).click();
	}
}
