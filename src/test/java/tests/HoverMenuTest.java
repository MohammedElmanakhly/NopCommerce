package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMenuTest extends TestBase{

	HomePage homeObject;
	
	@Test
	public void hoverMenuTest() {
		homeObject = new HomePage(driver);
		homeObject.hoverDropdownListAndSelectItem();
		Assert.assertTrue(driver.getCurrentUrl().contains("phones"));
	}
}
