package library;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Driver {
	WebDriver driver;

	public void jsScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");
	}

	public WebDriver initFirefoxDriver() {
		String URL = "https://phptravels.net/";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();

		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		return driver;

	}
	public WebDriver initFirefoxDriverPetStore() {
		String URL = "https://petstore.octoperf.com/actions/Catalog.action";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();

		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		return driver;

	}

	public WebDriver initChromeDriver() {
		String URL = "https://phptravels.net/";

		System.out.println("Setting chrome driver path...");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Creating driver...");

		// adding chrome options to prevent that webdriver is detected in chrome.
		ChromeOptions options = new ChromeOptions();
		options.addArguments();
		options.addArguments("--incognito", "--disable-blink-features", "--disable-blink-features=AutomationControlled",
				"--disable-smooth-scrolling=true");
		options.addArguments(
				"--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36'");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		// open the url
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		System.out.println("Waiting page to be ready...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ACCOUNT']")));

		// webpage is ready at this point

		System.out.println("Page is loaded and ready to use!");

		return driver;
	}
	
	public WebDriver initChromeDriverWtURL(String URL) {
		String pageDir = URL;

		System.out.println("Setting chrome driver path...");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Creating driver...");

		// adding chrome options to prevent that webdriver is detected in chrome.
		ChromeOptions options = new ChromeOptions();
		options.addArguments();
		options.addArguments("--incognito", "--disable-blink-features", "--disable-blink-features=AutomationControlled",
				"--disable-smooth-scrolling=true");
		options.addArguments(
				"--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36'");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		// open the url
		driver.navigate().to(pageDir);
		driver.manage().window().maximize();

		System.out.println("Waiting page to be ready...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@src, 'reptiles')])[2]")));

		// webpage is ready at this point

		System.out.println("Page is loaded and ready to use!");

		return driver;
	}

	public void teardownDriver() {

		driver.close();
		driver = null;
	}

}
