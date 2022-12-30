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
		
		public WebElement getDepartureDateBox() {
			return departureDateBox;
		}
		public void selectDepartureDateBox() {
			getDepartureDateBox().click();
		}
		public WebElement getDayDeparture() {
			return dayDeparture;
		}
		public void clickDayDeparture() {
			getDayDeparture().click();
			}
		//---- OPEN PASSENGERS BOX
		
		public WebElement getPassengersBox() {
			return passengersBox;
		}
		public void clickPassengersBox() {
			getPassengersBox().click();
			Wait <WebDriver> wait = new FluentWait <WebDriver> (this.driver)
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(ElementNotInteractableException.class);
			wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@class='dropdown-menu dropdown-menu-wrap']"),"style" , "display: block;"));
		
			
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
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
		}
		
		/// ---- BOOK NOW WINDOW
		@FindBy (xpath="//*[@class='btn btn-primary']") WebElement bookNowBtn;
		public WebElement getBookNowBtn() {
			return bookNowBtn;
		}
		public void clickBookNowBtn() {			
			getBookNowBtn().click();
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
					"display: none;"));
		}
		
		/// ----  FLIGHTS BOOKING INFORMATION WINDOW
		@FindBy (xpath="//*[@class='form-select form-select-sm nationality']") WebElement dropdownNationality;
		@FindBy (name="firstname_1") WebElement firstNametb;
		@FindBy (name="lastname_1") WebElement lastNametb;
		@FindBy (name="passport_1") WebElement passportTb;

		public WebElement getdropdownNationality() {
			return dropdownNationality;
		}
		public void clickDropdownNationality() {			
			getdropdownNationality().click();
		}
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
	
		public void selectValueNationality() {	
			List <WebElement> listNationality = driver.findElements(By.xpath("//*[@class='form-select form-select-sm nationality']//option"));
			listNationality.get(5).click();
		}
		public void selectValueTitle() {	
			List <WebElement> listTitle = driver.findElements(By.xpath("//*[@class='title_1']//option"));
			listTitle.get(1).click();
		}
		public void selectValueNationality_1() {	
			List <WebElement> listNationality_1 = driver.findElements(By.name("//*[@name='nationality_1']//option"));
			listNationality_1.get(5).click();
		}
		
		public void selectDateOfBirth() {	
			List <WebElement> listMonth = driver.findElements(By.name("//*[@name='dob_month_1']//option"));
			listMonth.get(5).click();
		}
		public void selectDay() {	
			List <WebElement> listDay = driver.findElements(By.name("//*[@name='dob_day_1']//option"));
			listDay.get(5).click();
		}
		public void selectYear() {	
			List <WebElement> listYear = driver.findElements(By.name("//*[@name='dob_year_1']//option"));
			listYear.get(5).click();
		}
		//######################## END FLIGHTS ########################## Diana


		
	
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
	}
