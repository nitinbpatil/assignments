package selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingMultipleWindows {

	static WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() {

		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://www.naukri.com/");

		String parentWindow = driver.getWindowHandle();
		
		closeAllOtherWindows(parentWindow);
		
		Assert.assertTrue(driver.getTitle().contains("Jobs - Recruitment"), "Main window title is not matching");
	}

	// To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String parentWindow) {

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(parentWindow)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

}
