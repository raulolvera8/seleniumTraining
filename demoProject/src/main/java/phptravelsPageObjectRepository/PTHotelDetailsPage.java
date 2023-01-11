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

public class PTHotelDetailsPage {
	WebDriver driver;
	public PTHotelDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[@class='card mb-4'][contains(.,'Child 3')]//select") WebElement numRoomsBox;
	@FindBy (xpath="//*[@class='card mb-4'][contains(.,'Child 3')]//button") WebElement bookNowBtn;
	// Available rooms
	// Select number of rooms
	public WebElement getNumberRooms() {
		return numRoomsBox;
	}
	public void selectNumberRoomsBox() {
		getNumberRooms().click();
	}
	public void selectNumOfRooms() {
		List <WebElement> listNumOfRooms=driver.findElements(By.xpath("//*[@class='card mb-4'][contains(.,'Child 3')]//select/option"));
		listNumOfRooms.get(1).click();
	}
	// Click Book Now Button 
	
	public WebElement getbookNowBtn() {
		return bookNowBtn;
	}
	public void selectbookNowBtn() {
		getbookNowBtn().click();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait1.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
				"display: none;"));		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your Personal Information')]")));	
		Wait<WebDriver> wait3 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title'][contains(.,'Travellers Information')]")));
		
	}
	
	
}
