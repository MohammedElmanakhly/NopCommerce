package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	private By reviewTitle = By.id("AddProductReview_Title"); 
	
	private By review = By.id("AddProductReview_ReviewText");
	
	private By rating5RadioButton = By.id("addproductrating_5");
	
	private By submitButton = By.cssSelector("button.button-1.write-product-review-button");
	
	public WebElement successMessage;
	
	public void addProductReview(String reviewTitleTxt,String reviewTxt) {
		sendKeys(reviewTitle, reviewTitleTxt);
		sendKeys(review, reviewTxt);
		clickButton(rating5RadioButton);
		clickButton(submitButton);
		successMessage = driver.findElement(By.cssSelector("div.result"));
	}

}
