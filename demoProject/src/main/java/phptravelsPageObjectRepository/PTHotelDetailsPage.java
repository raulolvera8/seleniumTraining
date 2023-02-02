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

import library.utilities;

public class PTHotelDetailsPage {
	WebDriver driver;
	utilities utility;

	public PTHotelDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new utilities(driver);
	}
	// ----- HOTEL DETAILS WINDOW -------
	// ------ XPATH FOR HOTEL DETAILS WINDOW ----- DIANA

	@FindBy(xpath = "//*[@class='card mb-4'][contains(.,'Child 1')]//select")
	WebElement numRoomsBox;
	@FindBy(xpath = "//*[@class='card mb-4'][contains(.,'Child 1')]//button")
	WebElement bookNowBtn;
	@FindBy(xpath = "//*[@class='card mb-4'][1]")
	WebElement availableRoomsSection;

	// ---- SELECT NUMBER OF ROOMS BOX ----- DIANA
	public WebElement getNumberRooms() {
		return numRoomsBox;
	}

	public void selectNumberRoomsBox() {
		utility.elementScrollDown(availableRoomsSection);
		getNumberRooms().click();
	}
	// ---------------------
	// ---- SELECT NUMBER OF ROOMS ----- DIANA

	public void selectNumOfRooms(int index) {
		List<WebElement> listNumOfRooms = driver
				.findElements(By.xpath("//*[@class='card mb-4'][contains(.,'Child 1')]//select/option"));
		listNumOfRooms.get(index).click();
	}

	// ---- CLICK BOOK NOW BUTTON ----- DIANA
	public WebElement getbookNowBtn() {
		return bookNowBtn;
	}

	public void selectbookNowBtn() {
		getbookNowBtn().click();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait1.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your Personal Information')]")));
	}
}
