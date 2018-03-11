package javaandjava8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

interface MyInterface {
	void enterTextInAlertBox(String text);
}

public class LambdaExpressionToAddValueToPopup {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void fillPopup() throws InterruptedException {

		driver.get("https://sunilpatro1985.github.io/demo/alerts.html");
		driver.findElement(By.id("prompt")).click();

		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert al = driver.switchTo().alert();

		MyInterface myInt = (String text) -> {
			al.sendKeys(text);
		};

		myInt.enterTextInAlertBox("Text coming from Interface method");

		Thread.sleep(2000);

		 al.accept();

	}

	@AfterClass
	public void tearDown() {
		// driver.close();
	}
}