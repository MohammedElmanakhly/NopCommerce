package data;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {

	public static Properties testData = loadProperties(
			System.getProperty("user.dir") + "\\src\\main\\java\\properties\\testData.properties");

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		} catch (Exception e) {
			System.out.println("error occured!" + e.getMessage());
		}
		return pro;
	}
}
