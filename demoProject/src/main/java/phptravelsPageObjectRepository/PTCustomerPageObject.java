package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PTCustomerPageObject {
	WebDriver driver;

	public PTCustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//######################## VISA ########################## Diana
	@FindBy(xpath="//*[@href='https://phptravels.net/visa']") WebElement visaBtn;
	@FindBy(id="select2-from_country-container") WebElement fromCountryBtn;
	@FindBy(id="select2-to_country-container") WebElement toCountryBtn;
	@FindBy (id="date") WebElement selectDateBox;
	@FindBy (xpath="//td[@class='day '][contains(text(),'26')]") WebElement selectDayCalendar;
	@FindBy (id="submit") WebElement searchIcon;
									//---SELECT VISA BTN---- 
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
									//---SELECT FROM COUNTRY---- 
	public WebElement getFromCountryBtn() {
		return fromCountryBtn;
	} 
	public void clickFromCountry() {
		getFromCountryBtn().click();
	}
	
	public void selectItemFromCountry() {
		List <WebElement> ListFromCountry =driver.findElements(By.xpath("//*[@id='select2-from_country-results']//li")); ;
		ListFromCountry.get(9).click();
	}
									//------SELECT TO COUNTRY
	public WebElement getToCountryBtn() {
		return toCountryBtn;
	} 
		
	public void clickToCountryBtn() {
		getToCountryBtn().click();
	}
	public void selectItemToCountry() {
		List <WebElement> ListToCountry =driver.findElements(By.xpath("//*[@id='select2-to_country-results']/li")); ;	
		ListToCountry.get(5).click();
	}
									//-------SELECT DATE BOX -----
	public WebElement getDateBox() {
		return selectDateBox;
	}
	public void selectDateBox() {
		getDateBox().click();
	}
									//-------SELECT DAY-----------------//
	public WebElement getDayCalendar() {
		return selectDayCalendar;
	}
	public void clickDayCalendar() {
		getDayCalendar().click();
	}
									//-----SEARCHING ICON -----///
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	public void clickSearchIcon() {
		getSearchIcon().click();
	}
	
				//-----------------SUBMISSION FORM -------------//
	
	@FindBy (name="first_name") WebElement firstNameTb;
	@FindBy (name="last_name") WebElement lastNameTb;
	@FindBy (name="email") WebElement emailTb;
	@FindBy (name="phone") WebElement phoneTb;
	@FindBy (name="notes") WebElement notesTb;
	@FindBy (id="submit") WebElement submitBtn;

	
	//------- FIRST NAME-----------------//

	public WebElement getFirstName() {
		return firstNameTb;
	}
	public void writeFirstName(String firstName) {
		getFirstName().sendKeys(firstName);
	}
	//------- LAST NAME-----------------//

	public WebElement getLasttName() {
		return lastNameTb;
	}
	public void writeLastName(String lastName) {
		getLasttName().sendKeys(lastName);
	}
	//------- EMAIL -----------------//

	public WebElement getEmail() {
		return emailTb;
	}
	public void writeEmail(String email) {
		getEmail().sendKeys(email);
	}
	//------- PHONE -----------------//

	public WebElement getPhone() {
		return phoneTb;
	}
	public void writePhone(String phone) {
		getPhone().sendKeys(phone);
	}
	//------- NOTES-----------------//

	public WebElement getNotes() {
		return notesTb;
	}
	public void writeNotes(String notes) {
		getNotes().sendKeys(notes);
	}
	
	//-------  SUMBIT BTN-----------------//
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void clickSubmitBtn() {
		getSubmitBtn().click();
		
	}
	//-----VALIDATION -------
		@FindBy(xpath="//*[@class='card-body my-5 text-center']//h2") WebElement validationMsg;
		public WebElement getValidationVisa(){
			return validationMsg;
		}
		
		public void printValidation() {
			if (getValidationVisa().getText().contains("Your visa form has been submitted")) {
				System.out.println(getValidationVisa().getText());
			}else {
				Assert.fail();
			}
		}
	

		//######################## END VISA ########################## Diana
		
		//######################## FLIGHTS ########################## Diana
		
		// Flights Btn
		
		//----- HOME PAGE WINDOW ----//
		@FindBy (xpath="//*[@href='https://phptravels.net/flights']") WebElement FlightsTab;
		public WebElement getFlightsTab() {
			return FlightsTab;
		}
		public void clickFlightsTab() {
			getFlightsTab().click();
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
		}
		
		//SEARCH FOR BEST FLIGHTS WINDOW
		
		@FindBy (id="autocomplete") WebElement FlyingFrom;
		@FindBy (id="autocomplete2") WebElement ToDestination;
		@FindBy (id="departure") WebElement departureDateBox;
		@FindBy (xpath="//td[@class='day '][contains (text(),'28')]") WebElement dayDeparture;
		@FindBy (xpath="//*[@class='dropdown dropdown-contain']") WebElement passengersBox;
		@FindBy (xpath="//*[@class='dropdown-item adult_qty']//*[@class='qtyInc']") WebElement iconPlus;
		@FindBy (xpath="//*[@class='guest_flights']") WebElement numberPassengers;
		@FindBy (id="flights-search") WebElement flightsSearchBtn;
		//---- WRITE FLYING FROM
		public WebElement getFlyingFrom() {
			return FlyingFrom;
		}
		public void writeFlyingFrom(String fromCountry) {
			getFlyingFrom().sendKeys(fromCountry);
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
		}
		
		public void selectItemFlyingFrom() {
			List <WebElement> listFlyingFrom = driver.findElements(By.xpath("//*[@class='autocomplete-wrapper _1 row_1']//div[@class='autocomplete-result']"));
			listFlyingFrom.get(0).click();
		}
		
		//---- WRITE  TO DESTINATION

		public WebElement getToDestination() {
			return ToDestination;
		}
		public void writeToDestination(String toCountry) {
			getToDestination().sendKeys(toCountry);
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
		}
		
		public void selectItemToDestination() {
			List <WebElement> listToDestination = driver.findElements(By.xpath("//*[@class='autocomplete-wrapper _1 row_2']//div[@class='autocomplete-result']"));
			listToDestination.get(0).click();
		}
		
		//---- SELECT DEPARTURE DATE
		
		
		  public WebElement getDepartureDateBox() { return departureDateBox; } 
		  public void selectDepartureDateBox() { getDepartureDateBox().click(); } public
		  WebElement getDayDeparture() { return dayDeparture; } public void
		  clickDayDeparture() { getDayDeparture().click(); } //---- OPEN PASSENGERS BOX
		  
		  public WebElement getPassengersBox() { 
			  return passengersBox; } 
		  public void
		  clickPassengersBox() { getPassengersBox().click(); Wait <WebDriver> wait =
		  new FluentWait <WebDriver> (this.driver) .withTimeout(Duration.ofSeconds(60))
		  .pollingEvery(Duration.ofSeconds(2))
		  .ignoring(ElementNotInteractableException.class);
		  wait.until(ExpectedConditions.attributeToBe(By.
		  xpath("//*[@class='dropdown-menu dropdown-menu-wrap']"),"style" ,
		  "display: block;"));
		  
		 
		 } 
		//---- SELECT PASSENGERS 

		public WebElement geticonPlus() {
			return iconPlus;
		}
		
		public void clickIconPlus() throws InterruptedException {
			Thread.sleep(6000);

			geticonPlus().click();
			Thread.sleep(6000);

		}
		/*public void numberOfPassengers() throws InterruptedException {
			int i;
			for ( i=0; i <=1; i++) {
				clickIconPlus();
				Thread.sleep(3000);
			}						
		}*/
		 
		public WebElement getflightsSearchBtn() {
			return flightsSearchBtn;
		}
		public void selectflightsSearchBtn() {
			getflightsSearchBtn().click();
		
			
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.id("preloader"), "style",
					"display: none;"));
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='theme-search-results-item-book row']")));
			System.out.println("FLIGHTS WINDOW");
			
		}
		
		/// ---- BOOK NOW WINDOW
		@FindBy (xpath="//*[@class='theme-search-results-item-book row']") WebElement bookNowBtn;
		public WebElement getBookNowBtn() {
			return bookNowBtn;
		}
		public void clickBookNowBtn() {		
			getBookNowBtn().click();
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='title'][contains(text(), 'Your Personal Information')]")));
			System.out.println("FLIGHTS BOOKING WINDOW");
		}
		
		/*/// ----  FLIGHTS BOOKING INFORMATION WINDOW
		@FindBy (xpath="//*[@class='form-select form-select-sm nationality']") WebElement dropdownNationality;
		@FindBy(name="title_1") WebElement DropDowntitle;
		@FindBy(name="nationality_1") WebElement DropDownNationality_1;
		@FindBy(name="dob_month_1") WebElement DropDownMonth;
		@FindBy(name="dob_day_1") WebElement DropDownDay;
		@FindBy(name="dob_year_1") WebElement DropDownYear;
		@FindBy (name="firstname_1") WebElement firstNametb;
		@FindBy (name="lastname_1") WebElement lastNametb;
		@FindBy (name="passport_1") WebElement passportTb;
		@FindBy(name="passport_issuance_month_1") WebElement dropDown_passport_issuance_month;
		@FindBy(name="passport_issuance_day_1") WebElement dropDown_passport_issuance_day;
		@FindBy(name="passport_issuance_year_1") WebElement DropDown_passport_issuance_year_1;
		@FindBy(name="passport_month_1") WebElement dropDown_passport_month_1;
		@FindBy(name="passport_day_1") WebElement dropDown_passport_day_1;
		@FindBy(name="passport_year_1") WebElement DropDown_passport_year_1;
		
		@FindBy (xpath="//*[@class='col-md-12 mb-1 gateway_pay-later']") WebElement payLaterRadioBtn;
		@FindBy (xpath="//*[@class='custom-checkbox']") WebElement termsAndConditionsCheckBox;
		@FindBy (id="booking") WebElement bookingBtn;
		
		


		// --- TRAVELLER INFORMATION
		
		public WebElement getFirstNametb() {
			return firstNametb;
		}
		public void writefirstNametb(String firstName) {			
			getFirstNametb().sendKeys(firstName);
		}
		public WebElement getlastNametb() {
			return lastNametb;
		}
		public void writelastNametb(String lastName) {			
			getlastNametb().sendKeys(lastName);
		}
		// ---- DROPDOWN LIST -------
		
		// ----- NATIONALITY
		public WebElement getdropdownNationality() {
			return dropdownNationality;
		}
		public void clickDropdownNationality() {			
			getdropdownNationality().click();
		}
		public void selectValueNationality() {	
			List <WebElement> listNationality = driver.findElements(By.xpath("//*[@class='form-select form-select-sm nationality']//option"));
			listNationality.get(5).click();
		}
		// ----- TITLE

		public WebElement getDropDowntitle() {
			return DropDowntitle;
		}
		public void selectDropDowntitle() {
			getDropDowntitle().click();
		}
		public void selectValueTitle() {	
			List <WebElement> listTitle = driver.findElements(By.xpath("//*[@name='title_1']//option"));
			listTitle.get(1).click();
		}
		// ----- NATIONALITY_01

		public WebElement getDropDownNationality_1() {
			return DropDownNationality_1;
		}
		public void selectDropDownNationality_1() {
			getDropDownNationality_1().click();
		}
		public void selectValueNationality_1() {	
			List <WebElement> listNationality_1 = driver.findElements(By.xpath("//*[@name='nationality_1']//option"));
			listNationality_1.get(5).click();
		}
		// ----- DATE OF BIRTH

		public WebElement getDropDownMonth() {
			return DropDownMonth;
		}
		public void selectDropDownMonth() {
			getDropDownMonth().click();
		}
		
		public void selectDateOfBirth() {	
			List <WebElement> listMonth = driver.findElements(By.xpath("//*[@name='dob_month_1']//option"));
			listMonth.get(5).click();
		}
		
		// ----- DAY

		public WebElement getDropDownDay() {
			return DropDownDay;
		}
		public void selectDropDownDay() {
			getDropDownDay().click();
		}
		
		public void selectDay() {	
			List <WebElement> listDay = driver.findElements(By.xpath("//*[@name='dob_day_1']//option"));
			listDay.get(10).click();
		}
		
		// ----- YEAR

		public WebElement getDropDownYear() {
			return DropDownYear;
		}
		public void selectDropDownYear() {
			getDropDownYear().click();
		}
		public void selectYear() {	
			List <WebElement> listYear = driver.findElements(By.xpath("//*[@name='dob_year_1']//option"));
			listYear.get(5).click();
		}
		// ---- END DROPDOWN LIST -------
		
		//----- PASSPORT DATA ------
		//   Passport Issuance Date 
		public WebElement getPassport() {
			return passportTb;
		}
		public void writePassport(String passport) {
			getPassport().sendKeys(passport);
		}
		// --select Passport Month
		public WebElement getPassportMonth() {
			return dropDown_passport_issuance_month;
		}
		public void selectPassportMonth() {
			getPassportMonth().click();
		}
		public void itemPassportMonth() {
			List <WebElement> listPassportMonth = driver.findElements(By.xpath("//*[@name='passport_issuance_month_1']//option"));
			listPassportMonth.get(5).click();
		}
		 // -- Select Passport Day
		public WebElement getPassportDay() {
			return dropDown_passport_issuance_day;
		}
		public void selectPassportDay() {
			getPassportDay().click();
		}
		public void itemPassportDay() {
			List <WebElement> ListPassportDay = driver.findElements(By.xpath("//*[@name='passport_issuance_day_1']//option"));
			ListPassportDay.get(5).click();
		}
		// --- Select Passport Year
		public WebElement getPassportYear() {
			return DropDown_passport_issuance_year_1;
		}
		public void selectPassportYear() {
			getPassportYear().click();
		}
		public void itemPassportYear() {
			List <WebElement> ListPassportYear = driver.findElements(By.xpath("//*[@name='passport_issuance_year_1']//option"));
			ListPassportYear.get(5).click();
		}
		/// Passport Expiry Date 
		// --- Expiry Month
		public WebElement getExpiryMonth() {
			return dropDown_passport_month_1;
		}
		public void selectExpiryMonth() {
			getExpiryMonth().click();
		}
		public void itemExpiryMonth() {
			List <WebElement> listExpiryMonth = driver.findElements(By.xpath("//*[@name='passport_month_1']//option"));
			listExpiryMonth.get(5).click();
		}
		// --- Expiry Day
		public WebElement getExpiryDay() {
			return dropDown_passport_day_1;
		}
		public void selectExpiryDay() {
			getExpiryDay().click();
		}
		public void itemExpiryDay() {
			List <WebElement> listExpiryDay = driver.findElements(By.xpath("//*[@name='passport_day_1']//option"));
			listExpiryDay.get(5).click();
		}
		// --- Expiry Year
		public WebElement getExpiryYear() {
			return DropDown_passport_year_1;
		}
		public void selectExpiryYear() {
			getExpiryYear().click();
		}
		public void itemExpiryYear() {
			List <WebElement> listExpiryYear = driver.findElements(By.xpath("//*[@name='passport_year_1']//option"));
			listExpiryYear.get(5).click();
		}

		
		// PAY LATER  
		public WebElement getPayLaterRadioBtn() {
			return payLaterRadioBtn;
		}
		public void selectPayLaterRadioBtn() {
			getPayLaterRadioBtn().click();
		}
		// ACCEPT TERMS AND CONDITIONS  termsAndConditionsCheckBoxbookingBtn
		public WebElement getCheckboxTerms() {
			return termsAndConditionsCheckBox;
		}
		public void selectCheckBoxTerms() {
			getCheckboxTerms().click();
		}
		// CONFIRM BOOKING BTN
		public WebElement getBookingBtn() {
			return bookingBtn;
		}

		public void clickBookingBtn() {
			getBookingBtn().click();
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']//span")));			
		}*/
		
	/*	//------ VALIDATION WINDOW ------
		// ---- Booking status
		@FindBy (xpath="//div[@class='infobox infobox-danger'][contains(.,'Your booking status is ( Pending ) and payment status is pay later ( Unpaid )')]") WebElement paymentStatusStripe;
		@FindBy (xpath="//div[@class='infobox infobox-warning'][contains(.,'Your booking status is ( Pending ) and payment status is pay later ( Unpaid )')]") WebElement paymentStatusPLater;		
		@FindBy (xpath = "//*[@class='card-body'][contains(.,'Miss Diana Velasquez ')]") WebElement travellerDetails;
		@FindBy (xpath="//li[contains(.,'user@phptravels.com')]") WebElement reservationNumber;
		public void validationStatusStripe() {
			System.out.println("BOOKING INVOICE WINDOW");
			if  (reservationNumber.getText().contentEquals("Email: user@phptravels.com")) {
				 System.out.println(paymentStatusStripe.getText());
				 System.out.println(travellerDetails.getText());
				 System.out.println(reservationNumber.getText());
			        } else {
			              Assert.fail( "FAILED" );
			        }	
		}
		
		public void validationStatusLater() {
			System.out.println("BOOKING INVOICE WINDOW");
			if  (reservationNumber.getText().contentEquals("Email: user@phptravels.com")) {
				 System.out.println(paymentStatusPLater.getText());
				 System.out.println(travellerDetails.getText());
				 System.out.println(reservationNumber.getText());
			        } else {
			              Assert.fail( "FAILED" );
			        }	
		}*/

		//######################## END FLIGHTS ########################## Diana
		
		//########################  HOTELS WINDOW ########################## Diana

		@FindBy(xpath="//*[@href='https://phptravels.net/hotels']") WebElement hotelsBtn;

		// ---- HOTELS TAB

		public WebElement gethotelsBtn() {
			return hotelsBtn;
		} 
		public void clickHotelsBtn() {
			gethotelsBtn().click();
		
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='container']/h2")));			
		}
		
		
	
		@FindBy (xpath="//*[@class='col-md-7']") WebElement nameHotel;
		
	
	//-----------------TOURS--------JUAN-------
	
	
	@FindBy(xpath="//*[@href='https://phptravels.net/tours']") WebElement toursBtn;

	public WebElement getToursBtn() {
		return toursBtn;
		
	}
	
	public void clickToursBtn() {
		
	
		getToursBtn().click();
		
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		("//*[@name='checkin']")));
	
}
	@FindBy(xpath="//*[@id='select2-tours_city-container']") WebElement destinationCity;
	@FindBy(xpath="//*[@id='select2-tours_city-container']") WebElement writeCity;

	public WebElement getDestination() {
		return destinationCity;
		
	}
	
	public void clickDestination() {
		
	
		getDestination().click();
		
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		("//*[@id='select2-tours_city-container']")));
	
	}
	
	
	
	
public WebElement getCity() {
	return writeCity;
}


public void writeCity(String fromCity) {			
	getCity().sendKeys(fromCity);
		
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		("//*[@id='submit']")));
	
	}

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
		("//*[@id='currency']")));
		
		
	
	}

public WebElement getDateSelect() {
	return dateSelect;
}

public void clickDateSelect() {
	

	getDateSelect().click();
	
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		("//*[@id='currency']")));
		
		
	
	}

	//PEOPLE OF TOUR

	 @FindBy(xpath="//*[@id='adults']") WebElement adults;
	 @FindBy(xpath="//*[@id='adults']//option[@value='1']") WebElement adultsNumber;



  public WebElement getAdults() {
	  return adults;
  
  
  }
  
  public void clickAdults() {
  
  
  getAdults().click();
  
  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
  Duration.ofSeconds(5));
  waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
  ("//*[@id='currency']")));
 
		

  }
 


public WebElement getAdultsNumber() { 
		  return adultsNumber; 
	  
	  }

public void clickAdultsNumber() {
	  
	  
	  getAdultsNumber().click();
	  
	  WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	  Duration.ofSeconds(5));
	  waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	  ("//*[@id='currency']")));
	 
			

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
("//*[@id='currency']")));

	

}

public WebElement getChildsNumber() { 
	  return childsNumber; 
 
 }

public void clickChildsNumber() {
 
 
 getAdultsNumber().click();
 
 WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
 Duration.ofSeconds(5));
 waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
 ("//*[@id='currency']")));

		

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
("//*[@id='currency']")));

	

}



public WebElement getInfantsNumber() { 
	  return infantsNumber; 
 
 }

public void clickInfantsNumber() {
 
 
getInfantsNumber().click();
 
 WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
 Duration.ofSeconds(5));
 waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
 ("//*[@id='currency']")));

		

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
	("//*[@id='currency']")));

		

	}

	
	//------------TRAVELLERS INFORMATION----------
	
	
	//TRAVELLER 1
	@FindBy(xpath="//*[@name='title_1']//option[@value='Mrs']") WebElement traveller1;
	@FindBy(xpath="//*[@name='firstname_1']") WebElement firstName1;
	@FindBy(xpath="//*[@name='lastname_1']") WebElement lastName1;


	public WebElement getTraveller1() {
		 return traveller1;


		}

		public void clickTraveller1() {


		getTraveller1().click();

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
		Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
		("//*[text()='Tour Booking']")));

			

		}
		public WebElement getFirstName1() {
			return firstName1;
		}


		public void writeFirstName1(String firstName) {			
			getFirstName1().sendKeys(firstName);
				
				
			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
					Duration.ofSeconds(5));
					waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
					("//*[text()='Tour Booking']")));
			
			}
		public WebElement getLastName1() {
			return lastName1;
		}


		public void writeLastName1(String lastName) {			
			getLastName1().sendKeys(lastName);
				
				
			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
					Duration.ofSeconds(5));
					waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
					("//*[text()='Tour Booking']")));
			
			}
		
		
		//TRAVELLER 2
		@FindBy(xpath="//*[@name='title_2']//option[@value='Miss']") WebElement traveller2;
		@FindBy(xpath="//*[@name='firstname_2']") WebElement firstName2;
		@FindBy(xpath="//*[@name='lastname_2']") WebElement lastName2;


		public WebElement getTraveller2() {
			 return traveller2;


			}

			public void clickTraveller2() {


			getTraveller2().click();

			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
			Duration.ofSeconds(5));
			waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
			("//*[text()='Tour Booking']")));

				

			}
			public WebElement getFirstName2() {
				return firstName2;
			}


			public void writeFirstName2(String firstName) {			
				getFirstName2().sendKeys(firstName);
					
					
				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));
				
				}
			public WebElement getLastName2() {
				return lastName2;
			}


			public void writeLastName2(String lastName) {			
				getFirstName2().sendKeys(lastName);
					
					
				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));
				
				}
			
			//TRAVELLER 3
			
			@FindBy(xpath="//*[@name='title_3']//option[@value='Mr']") WebElement traveller3;
			@FindBy(xpath="//*[@name='firstname_3']") WebElement firstName3;
			@FindBy(xpath="//*[@name='lastname_3']") WebElement lastName3;


			public WebElement getTraveller3() {
				 return traveller3;


				}

				public void clickTraveller3() {


				getTraveller3().click();

				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
				Duration.ofSeconds(5));
				waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//*[text()='Tour Booking']")));

					

				}
				public WebElement getFirstName3() {
					return firstName3;
				}


				public void writeFirstName3(String firstName) {			
					getFirstName3().sendKeys(firstName);
						
						
					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
					
					}
				public WebElement getLastName3() {
					return lastName3;
				}


				public void writeLastName3(String lastName) {			
					getFirstName3().sendKeys(lastName);
						
						
					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
					
					}
				
				@FindBy(xpath="//*[@id='gateway_stripe']") WebElement paymentMethod;
				
				public WebElement getPaymentMethod() {
					 return paymentMethod;


					}

					public void clickPaymentMethod() {


					getPaymentMethod().click();

					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
					Duration.ofSeconds(5));
					waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
					("//*[text()='Tour Booking']")));
					
					}
					
					
					@FindBy(xpath="//*[@id='agreechb']") WebElement checkboxContinuing;
					
					public WebElement getContinuing() {
						 return checkboxContinuing;


						}

						public void clickContinuing() {


						getContinuing().click();

						WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));
						
						}
						
						
						@FindBy(xpath="//*[@id='booking']") WebElement confirmBooking;
						
						public WebElement getconfirm() {
							 return confirmBooking;


							}

							public void clickConfirmBooking() {


							getconfirm().click();

							WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
							
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
									
								
								
						

//-----------------FLIGHTS--------JUAN-------

									/*
									 * @FindBy(xpath="//*[@title='flights']") WebElement flightsBtn;
									 * 
									 * public WebElement getFlightsBtn() { return flightsBtn; }
									 * 
									 * public void clickFlightsbtn() {
									 * 
									 * 
									 * getFlightsBtn().click();
									 * 
									 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20),
									 * Duration.ofSeconds(5));
									 * waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
									 * ("//*[text()='Welcome Back']")));
									 * 
									 * }
									 * 
									 * @FindBy(xpath="//*[@id='autocomplete']") WebElement flyingFromOneWay;
									 * 
									 * public WebElement getFlyingFromOneWay() { return flyingFromOneWay; }
									 * 
									 * public void writeFlyingFromOneWay(String fromCountry) {
									 * getFlyingFromOneWay().sendKeys(fromCountry);
									 * 
									 * Wait<WebDriver> wait2 = new
									 * FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
									 * .pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException
									 * .class); wait2.until(ExpectedConditions.attributeToBe(By.xpath(
									 * "//div[@id='preloader']"), "style", "display: none;")); }
									 * 
									 * public void selectItemFlyingFromOneWay() { List <WebElement>
									 * listFlyingFromOneWay = driver.findElements(By.
									 * xpath("//*[@class='autocomplete-wrapper _1 row_1']//div[@class='autocomplete-result']"
									 * )); listFlyingFromOneWay.get(0).click(); }
									 * 
									 * 
									 * 
									 * @FindBy(xpath="//*[@id='autocomplete2']") WebElement flyingDestination;
									 * 
									 * public WebElement getFlyingDestinationOneWay() { return flyingDestination; }
									 * 
									 * public void writeFlyingDestinationOneWay(String destinationCountry) {
									 * getFlyingDestinationOneWay().sendKeys(destinationCountry);
									 * 
									 * Wait<WebDriver> wait2 = new
									 * FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
									 * .pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException
									 * .class); wait2.until(ExpectedConditions.attributeToBe(By.xpath(
									 * "//div[@id='preloader']"), "style", "display: none;")); }
									 * 
									 * public void selectItemFlyingDestinationOneWay() { List <WebElement>
									 * listFlyingDestinationOneWay = driver.findElements(By.
									 * xpath("//*[@class='autocomplete-wrapper _1 row_1']//div[@class='autocomplete-result']"
									 * )); listFlyingDestinationOneWay.get(0).click(); }
									 * 
									 * 
									 * 
									 * 
									 * 
									 * @FindBy(xpath="//*[@value='05-01-2023']") WebElement date;
									 * 
									 * public WebElement getDate() { return date; }
									 * 
									 * 
									 * public void clickDate() {
									 * 
									 * 
									 * getDate().click();
									 * 
									 * 
									 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
									 * Duration.ofSeconds(5));
									 * waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
									 * ("//*[text()='SEARCH FOR BEST FLIGHTS']")));
									 * 
									 * }
									 * 
									 * @FindBy(xpath="//*[@id='flights-search']") WebElement search;
									 * 
									 * public WebElement getSearch() { return search; }
									 * 
									 * 
									 * public void clickSearch() {
									 * 
									 * 
									 * getSearch().click();
									 * 
									 * 
									 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
									 * Duration.ofSeconds(5));
									 * waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
									 * ("//*[text()='SEARCH FOR BEST FLIGHTS']")));
									 * 
									 * }
									 */
//MODIFY SEARCH

@FindBy(xpath="//*[@id='direct']") WebElement modifySearch;

public WebElement getModifySearch() {
	return modifySearch;
}


public void clickModifySearch() {
	

	getModifySearch().click();
		
	WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
	waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	("//button[text()='Modify Search']")));
		
	
	}

@FindBy(xpath= "//*[@class='theme-search-results-item-preview']") WebElement verifyStops;

//"//*[@class='theme-search-results-item-preview']")[7]
public WebElement getValidationStops(){
	return verifyStops;
}

public void printValidationStops() {
	if (getValidationStops().getText().contains("Steps 0")) {
		System.out.println(getValidationStops().getText());
	}else {
		Assert.fail();
	}
}
@FindBy(xpath= "//*[@for='flights_7']") WebElement airlinesfilter;

public WebElement getAirlinesfilter() {
	return modifySearch;
}


public void clickAirlines() {
	

	getAirlinesfilter().click();
		
	WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
	waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	("//button[text()='Modify Search']")));
		
	
	}
@FindBy(xpath="//span[@class='btn btn-primary']") WebElement firstOption;

/*
 * "//span[@class='btn btn-primary']")[7]
 */
public WebElement getFirstOption() {
	return firstOption;
}


public void clickFirstOption() {
	

	getFirstOption().click();
		
	/*
	 * WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
	 * Duration.ofSeconds(5));
	 * waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
	 * ("//button[text()='Modify Search']")));
	 */
		
	
	}
}
