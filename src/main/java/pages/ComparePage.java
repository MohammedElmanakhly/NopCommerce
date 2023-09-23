package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	private By clearListButton = By.className("clear-list");
	
	public WebElement compareListIsEmpty;
	
	//public WebElement compareProductsTable;
	
	public List<WebElement> allRows;
	
	public List<WebElement> allCols;
	
	public void copmareTwoProducts() {
		
		//compareProductsTable = driver.findElement(By.className("compare-products-table"));
		
		allRows = driver.findElements(By.tagName("tr"));
		
		allCols = driver.findElements(By.tagName("td"));
		
		for(WebElement rows : allRows) {
			System.out.println(rows.getText()+"\t");
			for(WebElement cols : allCols) {
				System.out.println(cols.getText()+"\t");
			}
		}
	}
	
	public void clearCompareList() {
		clickButton(clearListButton);
		compareListIsEmpty = driver.findElement(By.cssSelector("div.no-data"));
	}
	
}
