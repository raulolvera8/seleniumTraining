package library;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void waiting() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// wait loader
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
			break;
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
}
