package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.github.javafaker.Faker;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	
	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	public String fullNameTxt = fakeData.name().fullName();
	public String enquiryTxt = fakeData.random().toString();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	String newPassword = fakeData.number().digits(8).toString();
	String productName = "Apple MacBook Pro 13-inch";
	String partOfProductName = "MacB";
	String city = fakeData.address().city();
	String address = fakeData.address().fullAddress();
	String postalCode = fakeData.number().digits(5).toString();
	String phoneNumber = fakeData.phoneNumber().toString();

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			String chromePath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		implicitlyWait();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@BeforeMethod
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@BeforeClass
	public void UserCanRegisterAndLogin() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration(firstName, lastName, email, password);
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
	}
	
	@AfterClass
	public void UserCanLogout() {
		homeObject = new HomePage(driver);
		homeObject.userLogout();
	}

	// Take a screenshot when test case fails and add it to Screenshots folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking a screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}

}
