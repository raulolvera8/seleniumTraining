package library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class utilities {
	WebDriver driver;
	String mainWindow;

	public utilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ScrollDown(WebDriver driver, String X, String Y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(" + X + "," + Y + ")");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void elementScrollDown(WebElement element) {
		try {
			JavascriptExecutor js;
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error when trying to locate the element ");
			e.printStackTrace();
		}

	}

	public void elementScrollDownWithTopMenu(WebElement element) {
		try {
			JavascriptExecutor js;
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			js.executeScript("window.scrollByLines(-5)");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Error when trying to locate the element ");
			e.printStackTrace();
		}

	}
	// ******************************************************
	// Objective: Wait time without any validation of any object/element.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	public void waiting() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ******************************************************
	// Objective: Highlight any element using the xpath value.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	public void highlightElement(String elementXpath) {

		WebElement element = driver.findElement(By.xpath(elementXpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		try {
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
					element);
			Thread.sleep(1500);
			System.out.println("The element has been identified and highlighted...");
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:; background:')", element);
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(
					"The element with xpath " + elementXpath + " has not been identified properly. Please check.");
			e.printStackTrace();
		}
	}

	// ******************************************************
	// Objective: Performs a click with javascript, using xpath value.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	public void clickElementJavascript(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("The element provided has been clicked properly...");
	}

	public void saveMainWindowHandle() {
		// STORE THE ID OF THE ORIGINAL WINDOW
		mainWindow = driver.getWindowHandle();
	}

	// SWITCH TO NEW WINDOW
	public void switchToNewWindow() {

		// EXPLICIT WAIT
		WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(4), Duration.ofSeconds(2));

		// WAIT FOR THE NEW WINDOW OR TAB
		waitFor.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	// CLOSE ACTUAL WINDOW
	public void CloseCurrentWindow() {
		driver.close();
	}

	// SWITCH TO THE MAIN WINDOW
	public void switchToMainWindow() {
		driver.switchTo().window(mainWindow);
	}

	/*
	 * // WAIT THE COMPLETE PAGE public void pageStatus() { String currentUrl =
	 * driver.getCurrentUrl(); System.out.println(currentUrl);
	 * 
	 * }
	 */

}
