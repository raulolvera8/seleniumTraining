package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import library.utilities;

public class PTHotelHomePage {
	WebDriver driver;
	utilities utility;

	public PTHotelHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new utilities(driver);
	}

	// -------------- XPATH FOR HOTEL HOME WINDOW -----------REPARAR hotelSection
	@FindBy(xpath = "//*[@class='sec__title line-height-55 bottom-line']")
	WebElement hotelSection;

	@FindBy(xpath = "//*[@class='owl-stage']/div[position()=6]/*[@class='card-item mb-0']/*[@class='card-body']/h6")
	WebElement nameHotelLabel;

	// ---- NAME HOTEL LABEL ---- DIANA
	public WebElement getNameHotelLabel() {
		return nameHotelLabel;
	}

	// ---- READ HOTEL LABEL ---- DIANA
	public String readNameHotelLabel() {
		String nameHotelLabel = this.getNameHotelLabel().getText();
		return nameHotelLabel;
	}

	// ---- SELECT HOTEL LABEL ---- DIANA
	public void clickHotelName() {
		// SCROLL DOWN
		Wait<WebDriver> waitElementToBeClickable = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		waitElementToBeClickable.until(ExpectedConditions.elementToBeClickable(nameHotelLabel));
		utility.elementScrollDown(hotelSection);
		// CLICK NAME HOTEL
		getNameHotelLabel().click();
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sec__title_left left-line']")));

	}
}
