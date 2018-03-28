package javaprograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyTextAndPasteInTextbox {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.gecko.driver", "browsers//geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.facebook.com");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement textEle = driver.findElement(By.xpath("//span[text()='Create an account']"));

		Actions act = new Actions(driver);

		// act.moveToElement(textEle).doubleClick().build().perform();

		act.doubleClick(textEle).build().perform();

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);

		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		WebElement textBox = driver.findElement(By.id("email"));

		textBox.click();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
}
