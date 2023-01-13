package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
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

import library.Driver;

////--------FLIGHTSPAGE-----JUAN--------------////
public class PTFlightsPage extends Driver {
	WebDriver driver;

	public PTFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// FROM
	@FindBy(xpath = "//*[@id='autocomplete']")
	WebElement flyingFromOneWay;

	// DESTINATION
	@FindBy(xpath = "//*[@id='autocomplete2']")
	WebElement flyingDestination;

	// DATE
	@FindBy(id = "departure")
	WebElement departureDateBox;
	@FindBy(xpath = "//td[@class='day '][contains (text(),'28')]")
	WebElement dayDeparture;

	// PASSENGER
	@FindBy(xpath = "//*[@class='dropdown dropdown-contain']")
	WebElement passengersBox;

	// SEARCH
	@FindBy(xpath = "//*[@id='flights-search']")
	WebElement search;

	// ------FLYING FROM
	public WebElement getFlyingFromOneWay() {
		return flyingFromOneWay;
	}

	public void writeFlyingFromOneWayTb(String fromCountry) {
		getFlyingFromOneWay().sendKeys(fromCountry);

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
	}

	
	  public void selectItemFlyingFromOneWayDropDown() { List<WebElement>
	  listFlyingFromOneWay = driver.findElements( By.
	  xpath("//*[@class='autocomplete-wrapper _1 row_1']//div[@class='autocomplete-result']"
	  )); listFlyingFromOneWay.get(0).click(); }
	 
//----FLYING DESTINATION
	public WebElement getFlyingDestinationOneWay() {
		return flyingDestination;
	}

	public void writeFlyingDestinationOneWayTb(String destinationCountry) {
		getFlyingDestinationOneWay().sendKeys(destinationCountry);

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
	}

	public void selectItemFlyingDestinationOneWayDropDown() {
		List<WebElement> listFlyingDestinationOneWay = driver.findElements(
				By.xpath("//*[@class='autocomplete-wrapper _1 row_2']//div[@class='autocomplete-result']"));
		listFlyingDestinationOneWay.get(0).click();
	}

//-------FLYING DATE
	public WebElement getDepartureDateBox() {
		return departureDateBox;
	}

	public void selectDepartureDateCalendarBox() {
		getDepartureDateBox().click();
	}

	public WebElement getDayDeparture() {
		return dayDeparture;
	}

	public void clickDayDepartureCalendar() {
		getDayDeparture().click();
	}
//---- PASSENGERS BOX

	public WebElement getPassengersBox() {
		return passengersBox;
	}

	public void clickPassengersBox() {
		getPassengersBox().click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@class='dropdown-menu dropdown-menu-wrap']"), "style",
				"display: block;"));

//------SEARCH
	}

	public WebElement getflightsSearchBtn() {
		return search;
	}

	public void clickSearchFlightsBtn() {
		getflightsSearchBtn().click();

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.id("preloader"), "style", "display: none;"));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='theme-search-results-item-book row']")));
		System.out.println("FLIGHTS WINDOW");

	}

	/// ----- PRINT NUMBER OF PASSENGERS ------ IRIS
	@FindBy(xpath = "//span[@class='guest_flights']")
	WebElement NumberPassengers;

	private WebElement getNumberPassengers() {
		return NumberPassengers;
	}

	public void PrintNumberPassangers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='guest_flights']")));

		System.out.println("Number of Passengers " + getNumberPassengers().getText());
	}
	// -------------------------------------------------------------

	
	////------CLICK BOOK NOW

}
