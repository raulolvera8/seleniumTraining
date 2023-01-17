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

public class PTToursInDubai extends Driver {
	WebDriver driver;

	public PTToursInDubai(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	  
	@FindBy(xpath= "//*[@src='https://phptravels.net/api/uploads/images/tours/slider/thumbs/9.jpg']") 
	WebElement details;
			  
	 public WebElement getDetails() { return details; }
			  
	 public void clickDetailsBtn() {
	      getDetails().click();
			  
		  Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
	   	  .pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		  wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
			
			  
			
			  
	 }
			  
			 
			 
	
}
	
	
