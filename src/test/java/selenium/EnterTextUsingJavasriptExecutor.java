package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterTextUsingJavasriptExecutor {

	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		JavascriptExecutor myExecutor = (JavascriptExecutor) driver;
		myExecutor.executeScript("document.getElementById('lst-ib').setAttribute('value', 'Nitin')");
		
		//myExecutor.executeScript("document.getElementByName('lst-ib').setAttribute('value', 'Nitin')")
		
		Thread.sleep(2000);
		
		driver.close();
	}
}