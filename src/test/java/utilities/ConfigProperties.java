package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class ConfigProperties {

	private static Properties prop = new Properties();
	private static Logger Log1 = Logger.getLogger(ConfigProperties.class.getName());

	public ConfigProperties() {
		Log1.info("Inside ConfigProperties constructor..");
		DOMConfigurator.configure("log4j.xml");
	}

	public static void loadProperties() {
		try {
			Log1.info("inside loadProperties() method.. loading config file.");
			prop.load(new FileInputStream("config/config.properties"));

		} catch (FileNotFoundException e) {
			Log1.error("loadProperties() -> FileNotFoundException exception..");
			System.out.println("config.properties file not found");
		} catch (IOException e) {
			Log1.error("loadProperties() -> IOException exception..");
			System.out.println("IO exception while accessing config.properties file");
		}
	}

	public static String getProperty(String keyValue) {
		Log1.info("inside ConfigProperties->getProperty() called for value " + keyValue);
		return prop.getProperty(keyValue);
	}
}