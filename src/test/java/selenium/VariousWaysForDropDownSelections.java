package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//I have used Thread.sleep here in the script just for demo purpose, in ideal scenario we should never use Thread.sleep anywhere in the code.
//Thread.sleep is just used to see the option are getting selected in the dropdown using various options like
//Using Select class, Actions class, List<WebElements>, SendKeys and Javascript injection method.

public class VariousWaysForDropDownSelections {

	WebDriver driver;
	Select oSelect;
	Select mSelect;
	Actions act;

	//Initial setup required for the Test going to execute
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		oSelect = new Select(driver.findElement(By.id("continents")));
		mSelect = new Select(driver.findElement(By.id("selenium_commands")));
	}
	
	//Select dropdown value using Select class
	@Test(priority=0)
	public void usingSelectClass() throws InterruptedException {

		oSelect.selectByVisibleText("Europe");
		Thread.sleep(1000);
		oSelect.selectByIndex(2);
		Thread.sleep(1000);
	}

	//Select dropdown value using List<WebElements>
	@Test(priority=1)
	public void usingListOfWebElements() throws InterruptedException {

		// Using List<WebElements>
		Thread.sleep(2000);
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();

		for (int i = 0; i < iListSize; i++) {
			String sValue = oSelect.getOptions().get(i).getText();

			if (sValue.equals("Australia")) {
				oSelect.selectByIndex(i);
				// oSelect.selectByVisibleText("Australia");
				break;
			}
		}
	}

	//Select dropdown value using Actions class
	@Test(priority=2)
	public void usingActionsClass() throws InterruptedException {
		act = new Actions(driver);
		WebElement ele1 = driver
				.findElement(By.xpath("//select[@id='selenium_commands']/option[text()='Navigation Commands']"));
		WebElement ele2 = driver
				.findElement(By.xpath("//select[@id='selenium_commands']/option[text()='Switch Commands']"));
		act.moveToElement(ele1).keyDown(Keys.CONTROL).click().moveToElement(ele2).click().keyUp(Keys.CONTROL)
				.release(ele2).build().perform();

		Thread.sleep(2000);

		mSelect.deselectAll();
	}

	//Select dropdown value using SendKeys 
	@Test(priority=3)
	public void usingSendKeys() throws InterruptedException {

		driver.findElement(By.id("continents")).sendKeys("North America");

		Thread.sleep(2000);

		oSelect.deselectAll();
	}

	//Select dropdown value using JavascriptExecutor with Javascript Injection method
	@Test(priority = 4)
	public void usingJavaScriptExecutor() throws Exception {

		getJSDropdown("continents", "South America");

	}

	public void getJSDropdown(String dropDown, String elementID) throws Exception {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String dropdownScript = "var select = window.document.getElementById('" + dropDown + 
				"'); for(var i = 0; i < select.options.length; i++){if(select.options[i].text == '" + elementID +
				"'){ select.options[i].selected = true; } }";

		Thread.sleep(2000);
		executor.executeScript(dropdownScript);
		Thread.sleep(2000);

	}
	
	//Closing the Browser
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}