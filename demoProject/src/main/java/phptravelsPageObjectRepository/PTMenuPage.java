package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Driver;

////--------MENUPAGE-------JUAN--------------////
public class PTMenuPage extends Driver {
	WebDriver driver;

	public PTMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@href='https://phptravels.net/visa']")
	WebElement visaBtn;
	@FindBy(xpath = "//*[@href='https://phptravels.net/tours']")
	WebElement toursBtn;
	@FindBy(xpath = "//*[@title='flights']")
	WebElement flightsBtn;
	@FindBy(xpath="//*[@href='https://phptravels.net/hotels']") WebElement hotelsBtn;

	// ---- HOTELS TAB

	public WebElement gethotelsBtn() {
		return hotelsBtn;
	} 
	public void clickHotelsBtn() {
		gethotelsBtn().click();
	
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
				"display: none;"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='container']/h2")));			
	}
	// ---- VISA TAB

	public WebElement getVisaBtn() {
		return visaBtn;
	}
	public void clickVisaBtn() {
		getVisaBtn().click();
		// WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
		// Duration.ofSeconds(5));
		// waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCOUNT")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

	}

	public WebElement getToursBtn() {
		return toursBtn;

	}

	public void clickToursBtn() {

		getToursBtn().click();

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='checkin']")));
		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
		.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

	}
	//// --- FLIGHTS BTN
	public WebElement getFlightsBtn() {
		return flightsBtn;
	}

	public void clickFlightsbtn() {

		getFlightsBtn().click();

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SEARCH FOR BEST FLIGHTS']")));

	}

	/// -------- HOME PAGE FROM LOGO IMAGE -------- IRIS
	@FindBy(xpath = "(//a[@href='https://phptravels.net/'])[1]")
	WebElement logopage;

	private WebElement getLogoPage() {
		return logopage;
	}

	public void ClickLogoPage() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='https://phptravels.net/'])[1]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getLogoPage().click();
		System.out.println("Welcome to Home Page phptravels ...");
	}

	/// -------- FLIGHTS BUTTON -------- IRIS
	@FindBy(xpath = "//a[ contains (text(), 'flights') and @class='active_flights waves-effect']")
	WebElement btnFlights;

	private WebElement getbtnFlights() {
		return btnFlights;
	}

	public void clickbtnFlights() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[ contains (text(), 'flights') and @class='active_flights waves-effect']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnFlights().click();

		System.out.println("Clicking Flights button...");
	}

}
