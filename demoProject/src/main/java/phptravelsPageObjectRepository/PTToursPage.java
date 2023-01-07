package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;

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
	

	
	public WebElement getDestination() {
		return destinationCity;
		
	}
	
	public void clickDestination() {
	  getDestination().click();
	  
	  
	  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30),
	  Duration.ofSeconds(5));
	  waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	  ("//*[text()='Find the best tours packages']")));
	  
	  }
	 
	 
	
	public WebElement getCountry() {
		return writeCountry;
	}
	public void writeCountry(String fromDestination) {
		getCountry().sendKeys(fromDestination);
		
		
		  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(30),
		  Duration.ofSeconds(5));
		  waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		  ("//*[text()='Find the best tours packages']")));
		 
	}
	
	
	  public void selectItemFromTour() { List<WebElement> listTour =
	  driver.findElements( By.
	  xpath("//*[@class='select2-results__option']//i"
	  )); listTour.get(0).click(); }
	 
	


	
@FindBy(xpath="//*[@id='submit']") WebElement submit;

public WebElement getSubmit() {
	return submit;
}

public void clickSubmit() {
	

	getSubmit().click();
	
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		("//*[@id='select2-tours_city-container']")));
	
	}

@FindBy(xpath="//*[@src='https://phptravels.net/api/uploads/images/tours/slider/thumbs/9.jpg']") WebElement details;

public WebElement getDetails() {
	return details;
}

public void clickDetails() {
	

	getDetails().click();
	
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		("//*[@id='currency']")));
	
	}

@FindBy(xpath="//*[@name='date']") WebElement dateTour;
@FindBy(xpath="//*[text()='18']") WebElement dateSelect;

public WebElement getDateTour() {
	return dateTour;
	
	
}

public void clickDateTour() {
	

	getDetails().click();
	
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

							
							//VALIDATION
							
						//VALIDATION STATUS
							@FindBy(xpath="//*[@class='infobox infobox-danger']") WebElement validationStatus;
							public WebElement getValidationStatus(){
								return validationStatus;
							}
							
							public void printValidationStatus() {
								if (getValidationStatus().getText().contains("Your booking status is ( Pending ) and payment status is stripe ( Unpaid )")) {
									System.out.println(getValidationStatus().getText());
								}else {
									Assert.fail();
								}
							}
							
							
					    //VALIDATION DETAILS
							@FindBy(xpath="//*[@class='card-title px-3 pt-2 stgron']") WebElement validationDetails;
							public WebElement getValidationDetails(){
								return validationStatus;
							}
							
							public void printValidationDetails() {
								if (getValidationDetails().getText().contains("Booking Details")) {
									System.out.println(getValidationDetails().getText());
								}else {
									Assert.fail();
								}
							}
							
						// VALIDATION INFORMATION	
							@FindBy(xpath="//*[@class='card-title px-3 pt-2 strong']") WebElement validationInformation;
							public WebElement getValidationInfo(){
								return validationInformation;
							}
							
							public void printValidationInfo() {
								if (getValidationInfo().getText().contains("Booking Details")) {
									System.out.println(getValidationInfo().getText());
								}else {
									Assert.fail();
								}
							}
							
						// PROCEED
							@FindBy(xpath="//*[@id='form']") WebElement proceed;
					
							public WebElement getProceed() {
								 return proceed;


								}

								public void clickProceed() {


								getProceed().click();

							
								
								}
								
								@FindBy(xpath="//*[@class='card-header']") WebElement validationPay;
								public WebElement getValidationPay(){
									return validationPay;
								}
								
								public void printValidationPay() {
									if (getValidationPay().getText().contains("  Pay With stripe USD 385.00  ")) {
										System.out.println(getValidationPay().getText());
									}else {
										Assert.fail();
									}
								}
								
								@FindBy(xpath="//*[@type='button']") WebElement payNowBtn;
								
								public WebElement getPayNowBtn() {
									 return payNowBtn;


									}

									public void clickPayNowBtn() {


										getPayNowBtn().click();

								
									
									}
									
}
