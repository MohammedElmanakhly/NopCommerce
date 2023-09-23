package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

	private By PDFInvoiceButton = By.cssSelector("a.button-2.pdf-invoice-button");
	
	private By printButton = By.cssSelector("a.button-2.print-order-button");
	
	public void downloadPDFInvoice() {
		clickButton(PDFInvoiceButton);
	}
	
	public void printOrderDetails() {
		clickButton(printButton);
	}
}
