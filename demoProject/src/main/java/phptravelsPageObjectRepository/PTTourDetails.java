package phptravelsPageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Driver;

public class PTTourDetails  extends Driver {
	WebDriver driver;

	public PTTourDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath="//*[@name='date']") WebElement dateTour;
	@FindBy(xpath="//*[text()='18']") WebElement dateSelect;

	public WebElement getDateTour() {
		return dateTour;
		
		
	}

	public void clickDateTour() {
		

		getDateTour().click();
		
			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
			waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
			("//*[text()='Description']")));
			
			
		
		}

	public WebElement getDateSelect() {
		return dateSelect;
	}

	public void clickDateSelect() {
		

		getDateSelect().click();
		
			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
			waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
			("//*[text()='Description']")));
			
			
		
		}

		//PEOPLE OF TOUR

		 @FindBy(xpath="//*[@id='adults']") WebElement adults;
		 @FindBy(xpath="//*[@id='adults']//option[@value='2']") WebElement adultsNumber;



	  public WebElement getAdults() {
		  return adults;
	  
	  
	  }
	  
	  public void clickAdults() {
	  
	  
	  getAdults().click();
	  
	  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	  Duration.ofSeconds(5));
	  waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	  ("//*[text()='Description']")));
	 
			

	  }
	 


	public WebElement getAdultsNumber() { 
			  return adultsNumber; 
		  
		  }

	public void clickAdultsNumber() {
		  
		  
		  getAdultsNumber().click();
		  
		  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
		  Duration.ofSeconds(5));
		  waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		  ("//*[text()='Description']")));
		 
				

		  }
		 
	@FindBy(xpath="//*[@id='childs']") WebElement childs;
	@FindBy(xpath="//*[@id='childs']//option[@value='1']") WebElement childsNumber;



	public WebElement getChilds() {
	 return childs;


	}

	public void clickChilds() {


	getChilds().click();

	WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	Duration.ofSeconds(5));
	waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	("//*[text()='Description']")));

		

	}

	public WebElement getChildsNumber() { 
		  return childsNumber; 
	 
	 }

	public void clickChildsNumber() {
	 
	 
	 getAdultsNumber().click();
	 
	 WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	 Duration.ofSeconds(5));
	 waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	 ("//*[text()='Description']")));

			

	 }

	@FindBy(xpath="//*[@id='infants']") WebElement infants;
	@FindBy(xpath="//*[@id='infants']//option[@value='1']") WebElement infantsNumber;



	public WebElement getInfants() {
	 return infants;


	}

	public void clickInfants() {


	getInfants().click();

	WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	Duration.ofSeconds(5));
	waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	("//*[text()='Description']")));

		

	}



	public WebElement getInfantsNumber() { 
		  return infantsNumber; 
	 
	 }

	public void clickInfantsNumber() {
	 
	 
	getInfantsNumber().click();
	 
	 WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	 Duration.ofSeconds(5));
	 waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	 ("//*[text()='Description']")));

			

	 }

	@FindBy(xpath="//*[@type='submit']") WebElement bookNowDate;

	public WebElement getBookNowDate() {
		 return bookNowDate;


		}

		public void clickBookNowDate() {


			getBookNowDate().click();

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
		Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		("//*[text()='Description']")));

			

		}

}
