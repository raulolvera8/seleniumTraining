package library;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class Driver {
	WebDriver driver;


	public WebDriver initFirefoxDriver() {
		String URL = "https://phptravels.net/";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();
		
		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		/*System.out.println("Waiting for page to be ready...");

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
*/
		return driver;

	}

	public WebDriver initChromeDriver() {
		String URL = "https://super.walmart.com.mx/tu-cuenta/iniciar-sesion?vid=oaoh&tid=0&returnUrl=%2F";

		System.out.println("Setting chrome driver path...");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		System.out.println("Creating driver...");

		
		//adding chrome options to prevent that webdriver is detected in chrome
		ChromeOptions options = new ChromeOptions() ;
		options.addArguments();
		options.addArguments("--incognito","--disable-blink-features","--disable-blink-features=AutomationControlled");
		options.addArguments("--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36'");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		
		//passing thru the options to the driver
		ChromeDriver driver =new ChromeDriver(options);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
//		params.put("source", "Object.defineProperty((Navigator.prototype, 'webdriver', {\r\n"
//				+ "        set: undefined,\r\n"
//				+ "        enumerable: true,\r\n"
//				+ "        configurable: true,\r\n"
//				+ "        get: new Proxy(\r\n"
//				+ "            Object.getOwnPropertyDescriptor(Navigator.prototype, 'webdriver').get,\r\n"
//				+ "            { apply: (target, thisArg, args) => {\r\n"
//				+ "                // emulate getter call validation\r\n"
//				+ "                Reflect.apply(target, thisArg, args);\r\n"
//				+ "                return false;\r\n"
//				+ "            }}\r\n"
//				+ "        )\r\n"
//				+ "    });");
		
		driver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", params);


		//open the url
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		System.out.println("Waiting for page to be ready...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()= 'Inicia sesión']" )));
		
		//loader object <-----------
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//img[@alt='PxPixel']/.."), "style", "position: fixed; top: 0px; left: 0px; display: none;"));
		// wait for invisibility of loading message
		//wait.until(ExpectedConditions.attributeToBe(By.className("image_image__mGFxl"), "src",
		//		"https://super.walmart.com.mx/static/media/logo-od.db4eec40.svg"));
		// Wait visibility of form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form_form__9MEAJ")));//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// webpage is ready at this point

		System.out.println("Page is loaded and ready to use!");

		return driver;
	}

	public void teardownDriver() {

		driver.close();
		driver = null;
	}

}
