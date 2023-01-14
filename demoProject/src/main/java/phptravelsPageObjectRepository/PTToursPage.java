package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import library.Driver;

public class PTToursPage extends Driver {
	WebDriver driver;

	public PTToursPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='https://phptravels.net/tours']") WebElement toursBtn;

	public WebElement getToursBtn() {
		return toursBtn;
		
	}
	
	public void clickToursBtn() {
		
	
		getToursBtn().click();
		
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		("//*[@name='checkin']")));
	
}
	@FindBy(xpath="//*[@id='select2-tours_city-container']") WebElement destinationCity;
	@FindBy(xpath="//*[@class='select2-search__field']") WebElement writeCountry;
	

	
	
    public WebElement getDestination() { return destinationCity;
	  
	  }
	  
    public void clickDestination() { getDestination().click();
	  
	  
	  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30),
	  Duration.ofSeconds(5));  
	  waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
	  ("//*[text()='Find the best tours packages']")));
	  
	  }
	 
	 
	
	public WebElement getCountry() {
	  return writeCountry;
	}
	public void writeCountry(String fromDestination) {
	  getCountry().sendKeys(fromDestination);
				
		
	  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(60),
	  Duration.ofSeconds(5));
	  waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
	  ("(//span[@class ='select2-results']/ul/li[not(contains(text(),'Searching')) and not(contains(text(),'Please enter 3'))])[1]" )));
		
	}
	
	public void selectItemFromTour() { 
	  List<WebElement> 	listTour = driver.findElements( By. xpath("(//span[@class ='select2-results']/ul/li[not(contains(text(),'Searching')) and not(contains(text(),'Please enter 3'))])[1]" ));
	  listTour.get(0).click();
		  
	}

	 

	


	

    @FindBy(xpath="//*[@id='submit']") WebElement submit;

     public WebElement getSubmit() { 
	 return submit; 
   }
  
   public void clickSubmit() {
 
 
     getSubmit().click();
     
 	WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(5));
	waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
	("//*[text()='Filter Search']")));
     
     
 	Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
			.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
	wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
 
		/*
		 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30),
		 * Duration.ofSeconds(5));
		 * waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		 * ("//*[text()='Dubai,United Arab Emirates']")));
		 */
 
   }

}
	
	

