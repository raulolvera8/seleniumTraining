package library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

@SuppressWarnings("unused")
public class Driver {
	WebDriver driver;

	public WebDriver initFirefoxDriver() {
		String URL = "https://super.walmart.com.mx/tu-cuenta/iniciar-sesion";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		System.out.println("Waiting for page to be ready...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
		// wait for invisibility of loading message
		wait.until(ExpectedConditions.attributeToBe(By.className("image_image__mGFxl"), "src",
				"https://super.walmart.com.mx/static/media/logo-od.db4eec40.svg"));
		// Wait visibility of form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form_form__9MEAJ")));//
		System.out.println("Page is loaded and ready to use!");

		return driver;

	}

	public WebDriver initChromeDriver() {

		String URL = "https://super.walmart.com.mx/";

		System.out.println("Setting chrome driver path...");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Creating driver...");
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		System.out.println("Waiting for page to be ready...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
		// wait for invisibility of loading message
		wait.until(ExpectedConditions.attributeToBe(By.className("image_image__mGFxl"), "src",
				"https://super.walmart.com.mx/static/media/logo-od.db4eec40.svg"));
		// Wait visibility of form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form_form__9MEAJ")));//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(15)) .pollingEvery(Duration.ofSeconds(2))
		 * .ignoring(ElementNotInteractableException.class);
		 * 
		 * //wait for invisibility of loading message
		 * wait.until(ExpectedConditions.attributeToBe(By.xpath("//img[@class='db']"),
		 * "alt", "Walmart"));
		 * 
		 * //wait for visibility of contact us button
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@class='new-atf-wrapper']")));
		 */

		// webpage is ready at this point

		System.out.println("Page is loaded and ready to use!");

		return driver;
	}

	public void teardownDriver() {
		driver.close();
		driver = null;
	}

}
