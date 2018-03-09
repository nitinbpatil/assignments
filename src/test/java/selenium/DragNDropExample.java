package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragNDropExample {

	

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		// Wait for the frame to be available and switch to it
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		
		Thread.sleep(2000);
		
		driver.close();
	}
}