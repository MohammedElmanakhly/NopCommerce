package utilities;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static void captureScreenshot(WebDriver driver,String screenshotName) {
		
		Path destination = Paths.get("./Screenshots",screenshotName+".png");
		
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream output = new FileOutputStream(destination.toString());
			output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			output.close();	
		}
		
		catch(Exception exception) {
			System.out.println("Exception while taking screenshot"+exception.getMessage());
		}
	}
}
