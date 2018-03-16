package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class Browser {

	private static WebDriver driver;

	public static void setBrowser(WebDriver remoteWebDriver) {
		driver = remoteWebDriver;
	}

	public static void setBrowser(String browser) {
		System.out.println("Inside setBrowser value = " + browser);
		if (browser.equals("CH")) {
			System.out.println("Test will run on Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("FF")) {
			System.out.println("Test will run on Firefox Browser");
			System.setProperty("webdriver.gecko.driver", "browsers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("Default test will run on Firefox Browser");
			System.setProperty("webdriver.gecko.driver", "browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void open(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}
}