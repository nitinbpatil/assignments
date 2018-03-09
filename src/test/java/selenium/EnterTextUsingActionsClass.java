package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EnterTextUsingActionsClass {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.facebook.com");

		WebElement email = driver.findElement(By.id("email"));

		Actions act = new Actions(driver);

		act.moveToElement(email).click().sendKeys(email, "niteenbpatil@gmail.com").perform();

		WebElement pass = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.id("u_0_2"));

		act.moveToElement(pass).click().sendKeys(pass, "123456").click(login).perform();
		
		Thread.sleep(2000);
		
		driver.close();
	}
}