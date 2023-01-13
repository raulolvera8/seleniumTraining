package phptravelsPageObjectRepository;

import java.time.Duration;

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

public class PTFlightSearchResultsPage {
	WebDriver driver;

	public PTFlightSearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// ----- SELECT FIRST TRAVEL ON VIEW FLIGHTS ------ IRIS
	@FindBy(xpath = "(//button[@class='btn btn-block theme-search-results-item-price-btn ladda waves-effect'])[1]//span")
	WebElement firstflight;

	private WebElement getFirstFlight() {
		return firstflight;
	}

	public void clickFirstFlightBtn() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(60));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//button[@class='btn btn-block theme-search-results-item-price-btn ladda waves-effect'])[1]//span")));


		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
		
		getFirstFlight().click();
		
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
		
		System.out.println("Clicking first flight option  ...");
	}
	// -------------------------------------------------------------


	// filtro de Direct de juan

	@FindBy(xpath = "//*[@id='direct']")
	WebElement directSearch;

	public WebElement getDirectSearch() {
		return directSearch;
	}

	public void clickDirectSearchRadioBtn() {

		getDirectSearch().click();

	}

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitBookNow;

	public WebElement getSubmitBookNow() {
		return submitBookNow;
	}

	public void clickSubmitBookNow() {

		getSubmitBookNow().click();

		/*
		 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30),
		 * Duration.ofSeconds(5));
		 * waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//button[text()='Modify Search']")));
		 */

	}

}
