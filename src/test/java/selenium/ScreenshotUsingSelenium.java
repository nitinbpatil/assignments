package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Demonstration for capturing the screenshot
public class ScreenshotUsingSelenium {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.epam.com");
		
		//Code to create and store the screenshot capture at a specified location
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("F:\\Nitin Patil\\screenshot.jpg"));
		
	}
}