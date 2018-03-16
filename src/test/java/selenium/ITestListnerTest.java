package selenium;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ConfigProperties;

public class ITestListnerTest {

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		ConfigProperties.loadProperties();
		Browser.setBrowser(browser);
		Browser.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Browser.getDriver().manage().window().maximize();
		Browser.getDriver().get("http://www.google.com");
	}

	@Test
	public void goToGooglePage() {
		Assert.assertTrue(Browser.getDriver().getTitle().equalsIgnoreCase("Google"));
	}
	
	@Test
	public void findElementOnGooglePage() {
		Assert.assertTrue(Browser.getDriver().getTitle().equalsIgnoreCase("Google Page"));
	}

	@AfterClass
	public void tearDown() {
		Browser.close();
	}
	
}
