package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	public static WebDriver driver;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Select select;
	public Actions action;
	public Alert alert;
	public WebDriverWait wait;
	
	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
		action = new Actions(driver);
	}

	public static void clickButton(By button) {
		driver.findElement(button).click();
	} 
	
	public static void clickButton(WebElement button) {
		button.click();
	} 
	
	public static void sendKeys(By txt,String value) {
		driver.findElement(txt).sendKeys(value);
	}
	
	public void scrollDown() {
		js.executeScript("scrollBy(0,2500)");
	}
	
	public void clearTxt(By element) {
		driver.findElement(element).clear();
	}
	
    public void clearTxt(WebElement element) {
		element.clear();
	}
    
    public void explicitWait(WebElement element) {
    	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
