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

import library.Driver;


////--------MENUPAGE-------JUAN--------------////
public class PTMenuPage extends Driver  {
	WebDriver driver;

	public  PTMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='https://phptravels.net/visa']") WebElement visaBtn;
	@FindBy(xpath="//*[@href='https://phptravels.net/tours']") WebElement toursBtn;
	@FindBy(xpath="//*[@title='flights']") WebElement flightsBtn;
	
	public WebElement getVisaBtn() {
		return visaBtn;
	} 
	public void clickVisaBtn() {
		getVisaBtn().click();
		//WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		//waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCOUNT")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
				"display: none;"));

	}
	
	public WebElement getToursBtn() {
		return toursBtn;
		
	}
	
	public void clickToursBtn() {
		
	
		getToursBtn().click();
		
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		("//*[@name='checkin']")));
	
}
	
	public WebElement getFlightsBtn() {
		return flightsBtn;
	}

	public void clickFlightsbtn() {
		

		getFlightsBtn().click();
		
			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//*[text()='SEARCH FOR BEST FLIGHTS']")));
		
		}




}


