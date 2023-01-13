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

public class PTBookingFormPage {
	WebDriver driver;
	utilities utils;

	public PTBookingFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utils = new utilities(driver);
	}


	/// ---- FLIGHTS BOOKING INFORMATION WINDOW
	// ---- XPATH TO FLIGHTS BOOKING INFORMATION WINDOW
	@FindBy(xpath = "//*[@class='form-select form-select-sm nationality']")
	WebElement NationalityDropDown;
	@FindBy(name = "title_1")
	WebElement titleDropDown;
	@FindBy(name = "nationality_1")
	WebElement Nationality_1DropDown;
	@FindBy(name = "dob_month_1")
	WebElement MonthDropDown;
	@FindBy(name = "dob_day_1")
	WebElement DayDropDown;
	@FindBy(name = "dob_year_1")
	WebElement YearDropDown;
	@FindBy(name = "firstname_1")
	WebElement firstNametb;
	@FindBy(name = "lastname_1")
	WebElement lastNametb;
	@FindBy(name = "passport_1")
	WebElement passportTb;
	@FindBy(name = "passport_issuance_month_1")
	WebElement passport_issuance_monthDropDown;
	@FindBy(name = "passport_issuance_day_1")
	WebElement passport_issuance_dayDropDown;
	@FindBy(name = "passport_issuance_year_1")
	WebElement passport_issuance_year_DropDown;
	@FindBy(name = "passport_month_1")
	WebElement passport_month_DropDown;
	@FindBy(name = "passport_day_1")
	WebElement passport_day_DropDown;
	@FindBy(name = "passport_year_1")
	WebElement passport_year_DropDown;
	@FindBy(xpath = "//*[@class='col-md-12 mb-1 gateway_pay-later']")
	WebElement payLaterRadioBtn;
	@FindBy(xpath = "//*[@id='gateway_stripe']")
	WebElement payWithStripeRadioBtn;
	@FindBy(xpath = "//*[@class='custom-checkbox']")
	WebElement termsAndConditionsCheckBox;
	@FindBy(id = "booking")
	WebElement bookingBtn;
	// -------------------
	// --- TRAVELLER INFORMATION ---- 
	// --- WRITE FIRST NAME ----- DIANA
	public WebElement getFirstNametb() {
		return firstNametb;
	}

	public void writefirstNametb(String firstName) {
		getFirstNametb().sendKeys(firstName);
	}
	// -------------------
	// --- WRITE LAST NAME ----- DIANA

	public WebElement getlastNametb() {
		return lastNametb;
	}

	public void writelastNametb(String lastName) {
		getlastNametb().sendKeys(lastName);
	}
	// -------------------

	// ---- DROPDOWN LIST -------
	// ----- CLICK NATIONALITY BOX ---- DIANA
	public WebElement getNationalityDropDown() {
		return NationalityDropDown;
	}

	public void clickNationalityDropdown() {
		getNationalityDropDown().click();
	}
	// ----- CLICK  VALUE NATIONALITY  ---- DIANA
	public void clickValueNationalityDropDown() {
		List<WebElement> listNationality = driver
				.findElements(By.xpath("//*[@class='form-select form-select-sm nationality']//option"));
		listNationality.get(5).click();
		/*WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(2));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='form-title-wrap'][contains(.,'Travellers Information')]")));*/
	//	utils.elementScrollDown(titleDropDown);
	
	}
	// ----- TITLE

	public WebElement getTitleDropDown() {
		return titleDropDown;
	}

	public void clickTitleDropDown() {
		getTitleDropDown().click();
	}

	public void clickValueTitleDropDown() {
		List<WebElement> listTitle = driver.findElements(By.xpath("//*[@name='title_1']//option"));
		listTitle.get(1).click();
	}
	// ----- NATIONALITY_01

	public WebElement getNationality_1DropDown() {
		return Nationality_1DropDown;
	}

	public void clickNationality_1DropDown() {
		//utils.elementScrollDown(this.getNationality_1DropDown());
		getNationality_1DropDown().click();
	}

	public void clickValueNationality_1DropDown() {
		List<WebElement> listNationality_1 = driver.findElements(By.xpath("//*[@name='nationality_1']//option"));
		listNationality_1.get(5).click();
	}
	// ----- DATE OF BIRTH

	public WebElement getMonthDropDown() {
		return MonthDropDown;
	}

	public void clickMonthDropDown() {
		getMonthDropDown().click();
	}

	public void clickValueDateOfBirthDropDown() {
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='dob_month_1']//option"));
		listMonth.get(5).click();
	}

	// ----- DAY

	public WebElement getDayDropDown() {
		return DayDropDown;
	}

	public void clickDayDropDown() {
		getDayDropDown().click();
	}

	public void clickValueDayDropDown() {
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='dob_day_1']//option"));
		listDay.get(10).click();
	}

	// ----- YEAR

	public WebElement getYearDropDow() {
		return YearDropDown;
	}

	public void clickYearDropDown() {
		getYearDropDow().click();
	}

	public void clickValueYearDropDown() {
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='dob_year_1']//option"));
		listYear.get(5).click();
	}
	// ---- END DROPDOWN LIST -------

	// ----- PASSPORT DATA ------
	// Passport Issuance Date
	public WebElement getPassportTb() {
		return passportTb;
	}

	public void writePassportTb(String passport) {
		utils.elementScrollDown(this.getPassportTb());
		getPassportTb().sendKeys(passport);
	}

	// --click Passport Month
	public WebElement getPassportMonthDropDown() {
		return passport_issuance_monthDropDown;
	}

	public void clickPassportMonthDropDown() {
		utils.elementScrollDown(this.getPassportMonthDropDown());
		getPassportMonthDropDown().click();
	}

	public void clickValuePassportMonthDropDown() {
		List<WebElement> listPassportMonth = driver
				.findElements(By.xpath("//*[@name='passport_issuance_month_1']//option"));
		listPassportMonth.get(5).click();
	}

	// -- click Passport Day
	public WebElement getPassportDayDropDown() {
		return passport_issuance_dayDropDown;
	}

	public void clickPassportDayDropDown() {
		getPassportDayDropDown().click();
	}

	public void clickValuePassportDayDropDown() {
		List<WebElement> ListPassportDay = driver
				.findElements(By.xpath("//*[@name='passport_issuance_day_1']//option"));
		ListPassportDay.get(5).click();
	}

	// --- click Passport Year
	public WebElement getPassportYearDropDown() {
		return passport_issuance_year_DropDown;
	}

	public void clickPassportYearDropDown() {
		getPassportYearDropDown().click();
	}

	public void clickValuePassportYearDropDown() {
		List<WebElement> ListPassportYear = driver
				.findElements(By.xpath("//*[@name='passport_issuance_year_1']//option"));
		ListPassportYear.get(5).click();
	}

	/// Passport Expiry Date
	// --- Expiry Month
	public WebElement getExpiryMonthDropDown() {
		return passport_month_DropDown;
	}

	public void clickExpiryMonthDropDown() {
		getExpiryMonthDropDown().click();
	}

	public void clickValueMonthDropDown() {
		List<WebElement> listExpiryMonth = driver.findElements(By.xpath("//*[@name='passport_month_1']//option"));
		listExpiryMonth.get(5).click();
	}

	// --- Expiry Day
	public WebElement getExpiryDayDropDown() {
		return passport_day_DropDown;
	}

	public void clickExpiryDayDropDown() {
		getExpiryDayDropDown().click();
	}

	public void clickValueExpiryDayDropDown() {
		List<WebElement> listExpiryDay = driver.findElements(By.xpath("//*[@name='passport_day_1']//option"));
		listExpiryDay.get(5).click();
	}

	// --- Expiry Year
	public WebElement getExpiryYearDropDown() {
		return passport_year_DropDown;
	}

	public void clickExpiryYearDropDown() {
		getExpiryYearDropDown().click();
	}

	public void clickValueExpiryYearDropDown() {
		List<WebElement> listExpiryYear = driver.findElements(By.xpath("//*[@name='passport_year_1']//option"));
		listExpiryYear.get(5).click();
	}

	// PAY LATER
	public WebElement getPayLaterRadioBtn() {
		return payLaterRadioBtn;
	}

	public void clickPayLaterRadioBtn() {
		getPayLaterRadioBtn().click();
		
		
		/*
		 * Wait<WebDriver> wait = new
		 * FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(80))
		 * .pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException
		 * .class);
		 * wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"
		 * ), "style", "display: none;"));
		 */
	}

	// Pay with stripe
	public WebElement getPayStripe() {
		return payWithStripeRadioBtn;
	}

	public void clickPayStripeRadioBtn() {
		utils.elementScrollDown(this.getPayStripe());
		getPayStripe().click();
	}

	// ACCEPT TERMS AND CONDITIONS termsAndConditionsCheckBoxbookingBtn
	public WebElement getTermsConditionsCheckBox() {
		return termsAndConditionsCheckBox;
	}

	public void clickTermsConditionsCheckBox() {
		utils.elementScrollDown(this.getTermsConditionsCheckBox());
		getTermsConditionsCheckBox().click();
	}

	// CONFIRM BOOKING BTN
	public WebElement getBookingBtn() {
		return bookingBtn;
	}

	public void clickBookingBtn() {
		getBookingBtn().click();
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']//span")));

	}
	// ------ SCROLL TO FORM TRAVELLER SECTION ------ DIANA
	// ------ XPATH FOR SCROLL FORM TRAVELLER SECTION
	@FindBy (xpath="//*[@class='form-box payment-received-wrap mb-2']") WebElement formTravellerSection;
	public WebElement getFormTravellerSection() {
		return formTravellerSection;
	}
	public void scrollToFormTravellerSection() {
		utils.elementScrollDown(getFormTravellerSection());
	}
	// -----------------------------
	// ------ SCROLL TO FORM TRAVELLER NATIONALITY SECTION ------ DIANA
	// ------ XPATH FOR SCROLL FORM TRAVELLER NATIONALITY NASECTION
	
	@FindBy (xpath="//*[@class='row mt-3'][position()=1]") WebElement formTravellerNationalitySection;
	public WebElement getFormTravellerNationalitySection() {
		return formTravellerNationalitySection;
	}
	public void scrollToFormTravellerNationalitySection() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		utils.elementScrollDown(getNationalityDropDown());
	}
	//------------
	// ------ SCROLL TO METHOD PAYMENT SECTION ------ DIANA
	// ------ XPATH FOR SCROLL METHOD PAYMENT SECTION
		@FindBy (xpath="//*[@class='form-box']") WebElement methodPaymentSection;
		public WebElement getMethodPaymentSection() {
			return methodPaymentSection;
		}
		public void scrollToMethodPaymentSection() {
			utils.elementScrollDown(getMethodPaymentSection());
		}
		// -----------------------------

}
