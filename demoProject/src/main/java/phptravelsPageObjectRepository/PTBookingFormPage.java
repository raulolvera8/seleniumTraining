package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.utilities;

public class PTBookingFormPage {
	WebDriver driver;

	public PTBookingFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	utilities utils = new utilities(driver);


	/// ---- FLIGHTS BOOKING INFORMATION WINDOW
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
		return NationalityDropDown;
	}

	public void clickDropdownNationality() {
		getdropdownNationality().click();
	}

	public void selectValueNationality() {
		List<WebElement> listNationality = driver
				.findElements(By.xpath("//*[@class='form-select form-select-sm nationality']//option"));
		listNationality.get(5).click();
		/*WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(2));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='form-title-wrap'][contains(.,'Travellers Information')]")));*/
	//	utils.elementScrollDown(titleDropDown);

	
	}
	// ----- TITLE

	public WebElement getDropDowntitle() {
		return titleDropDown;
	}

	public void selectDropDowntitle() {
		getDropDowntitle().click();
	}

	public void selectValueTitle() {
		List<WebElement> listTitle = driver.findElements(By.xpath("//*[@name='title_1']//option"));
		listTitle.get(1).click();
	}
	// ----- NATIONALITY_01

	public WebElement getDropDownNationality_1() {
		return Nationality_1DropDown;
	}

	public void selectDropDownNationality_1() {
		getDropDownNationality_1().click();
	}

	public void selectValueNationality_1() {
		List<WebElement> listNationality_1 = driver.findElements(By.xpath("//*[@name='nationality_1']//option"));
		listNationality_1.get(5).click();
	}
	// ----- DATE OF BIRTH

	public WebElement getDropDownMonth() {
		return MonthDropDown;
	}

	public void selectDropDownMonth() {
		getDropDownMonth().click();
	}

	public void selectDateOfBirth() {
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='dob_month_1']//option"));
		listMonth.get(5).click();
	}

	// ----- DAY

	public WebElement getDropDownDay() {
		return DayDropDown;
	}

	public void selectDropDownDay() {
		getDropDownDay().click();
	}

	public void selectDay() {
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='dob_day_1']//option"));
		listDay.get(10).click();
	}

	// ----- YEAR

	public WebElement getDropDownYear() {
		return YearDropDown;
	}

	public void selectDropDownYear() {
		getDropDownYear().click();
	}

	public void selectYear() {
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='dob_year_1']//option"));
		listYear.get(5).click();
	}
	// ---- END DROPDOWN LIST -------

	// ----- PASSPORT DATA ------
	// Passport Issuance Date
	public WebElement getPassport() {
		return passportTb;
	}

	public void writePassport(String passport) {
		getPassport().sendKeys(passport);
	}

	// --select Passport Month
	public WebElement getPassportMonth() {
		return passport_issuance_monthDropDown;
	}

	public void selectPassportMonth() {
		getPassportMonth().click();
	}

	public void itemPassportMonth() {
		List<WebElement> listPassportMonth = driver
				.findElements(By.xpath("//*[@name='passport_issuance_month_1']//option"));
		listPassportMonth.get(5).click();
	}

	// -- Select Passport Day
	public WebElement getPassportDay() {
		return passport_issuance_dayDropDown;
	}

	public void selectPassportDay() {
		getPassportDay().click();
	}

	public void itemPassportDay() {
		List<WebElement> ListPassportDay = driver
				.findElements(By.xpath("//*[@name='passport_issuance_day_1']//option"));
		ListPassportDay.get(5).click();
	}

	// --- Select Passport Year
	public WebElement getPassportYear() {
		return passport_issuance_year_DropDown;
	}

	public void selectPassportYear() {
		getPassportYear().click();
	}

	public void itemPassportYear() {
		List<WebElement> ListPassportYear = driver
				.findElements(By.xpath("//*[@name='passport_issuance_year_1']//option"));
		ListPassportYear.get(5).click();
	}

	/// Passport Expiry Date
	// --- Expiry Month
	public WebElement getExpiryMonth() {
		return passport_month_DropDown;
	}

	public void selectExpiryMonth() {
		getExpiryMonth().click();
	}

	public void itemExpiryMonth() {
		List<WebElement> listExpiryMonth = driver.findElements(By.xpath("//*[@name='passport_month_1']//option"));
		listExpiryMonth.get(5).click();
	}

	// --- Expiry Day
	public WebElement getExpiryDay() {
		return passport_day_DropDown;
	}

	public void selectExpiryDay() {
		getExpiryDay().click();
	}

	public void itemExpiryDay() {
		List<WebElement> listExpiryDay = driver.findElements(By.xpath("//*[@name='passport_day_1']//option"));
		listExpiryDay.get(5).click();
	}

	// --- Expiry Year
	public WebElement getExpiryYear() {
		return passport_year_DropDown;
	}

	public void selectExpiryYear() {
		getExpiryYear().click();
	}

	public void itemExpiryYear() {
		List<WebElement> listExpiryYear = driver.findElements(By.xpath("//*[@name='passport_year_1']//option"));
		listExpiryYear.get(5).click();
	}

	// PAY LATER
	public WebElement getPayLaterRadioBtn() {
		return payLaterRadioBtn;
	}

	public void selectPayLaterRadioBtn() {
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

	public void selectPayStripeRadioBtn() {
		getPayStripe().click();
	}

	// ACCEPT TERMS AND CONDITIONS termsAndConditionsCheckBoxbookingBtn
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
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']//span")));

	}
}
