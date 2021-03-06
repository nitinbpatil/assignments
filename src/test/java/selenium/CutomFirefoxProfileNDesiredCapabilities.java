package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CutomFirefoxProfileNDesiredCapabilities {
	WebDriver driver;

	@BeforeTest
	public void StartBrowser() {

		// Create object of FirefoxProfile in built class to access Its properties.
		FirefoxProfile fprofile = new FirefoxProfile();
		// creating DesiredCapabilities object to set firefox browser properties
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		// Set Location to store files after downloading.
		fprofile.setPreference("browser.download.dir", "E:\\WebDriverdownloads");
		fprofile.setPreference("browser.download.folderList", 2);
		// Set Preference to not show file download confirmation dialogue using MIME
		// types Of different file extension types.
		fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"// MIME types Of MS Excel File.
						+ "application/pdf;" // MIME types Of PDF File.
						+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" // MIME types Of MS
																										// doc File.
						+ "text/plain;" // MIME types Of text File.
						+ "text/csv"); // MIME types Of CSV File.
		fprofile.setPreference("browser.download.manager.showWhenStarting", false);
		fprofile.setPreference("pdfjs.disabled", true);
		// Pass fprofile parameter In webdriver to use preferences to download file.
		fprofile.setAcceptUntrustedCertificates(false);
		fprofile.setAssumeUntrustedCertificateIssuer(true);
		
		dc = DesiredCapabilities.firefox();
		
		dc.setCapability(FirefoxDriver.PROFILE, fprofile);

		
		System.setProperty("webdriver.gecko.driver", "browsers\\geckodriver.exe");
		
		driver = new FirefoxDriver(dc);
	}

	@Test
	public void OpenURL() throws InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
		// Download Text File
		driver.findElement(By.xpath("//a[contains(.,'Download Text File')]")).click();
		Thread.sleep(5000);// To wait till file gets downloaded.
		// Download PDF File
		driver.findElement(By.xpath("//a[contains(.,'Download PDF File')]")).click();
		Thread.sleep(5000);
		// Download CSV File
		driver.findElement(By.xpath("//a[contains(.,'Download CSV File')]")).click();
		Thread.sleep(5000);
		// Download Excel File
		driver.findElement(By.xpath("//a[contains(.,'Download Excel File')]")).click();
		Thread.sleep(5000);
		// Download Doc File
		driver.findElement(By.xpath("//a[contains(.,'Download Doc File')]")).click();
		Thread.sleep(5000);
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
