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
		utils.elementScrollDown(this.getlastNametb());
		getlastNametb().sendKeys(lastName);
		//utils.elementScrollDown(this.getNationalityDropDown());

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
	public void clickValueNationalityDropDown(int index) {
		List<WebElement> listNationality = driver
				.findElements(By.xpath("//*[@class='form-select form-select-sm nationality']//option"));
		listNationality.get(index).click();
		/*WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(2));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='form-title-wrap'][contains(.,'Travellers Information')]")));*/
	//	utils.elementScrollDown(titleDropDown);
	
	}
	// ----- TITLE --- DIANA

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
	// ----- NATIONALITY_01 --- DIANA

	public WebElement getNationality_1DropDown() {
		return Nationality_1DropDown;
	}

	public void clickNationality_1DropDown() {
		//utils.elementScrollDown(this.getNationality_1DropDown());
		utils.elementScrollDownWithTopMenu(this.getNationality_1DropDown());
		getNationality_1DropDown().click();
	}

	public void clickValueNationality_1DropDown() {
		List<WebElement> listNationality_1 = driver.findElements(By.xpath("//*[@name='nationality_1']//option"));
		listNationality_1.get(5).click();
	}
	// ----- DATE OF BIRTH ---- DIANA

	public WebElement getMonthDropDown() {
		return MonthDropDown;
	}

	public void clickMonthDropDown() {
		getMonthDropDown().click();
	}

	public void clickValueDateOfBirthDropDown(int index) {
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='dob_month_1']//option"));
		listMonth.get(index).click();
	}

	// ----- DAY ---- DIANA

	public WebElement getDayDropDown() {
		return DayDropDown;
	}

	public void clickDayDropDown() {
		getDayDropDown().click();
	}

	public void clickValueDayDropDown(int index) {
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='dob_day_1']//option"));
		listDay.get(index).click();
	}

	// ----- YEAR ---- DIANA

	public WebElement getYearDropDow() {
		return YearDropDown;
	}

	public void clickYearDropDown() {
		getYearDropDow().click();
	}

	public void clickValueYearDropDown(int index) {
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='dob_year_1']//option"));
		listYear.get(index).click();
	}
	// ---- END DROPDOWN LIST -------

	// ----- PASSPORT DATA ------ DIANA
	// Passport Issuance Date
	public WebElement getPassportTb() {
		return passportTb;
	}

	public void writePassportTb(String passport) {
		getPassportTb().sendKeys(passport);
	}

	// --Click Passport Month -- DIANA
	public WebElement getPassportMonthDropDown() {
		return passport_issuance_monthDropDown;
	}

	public void clickPassportMonthDropDown() {
		utils.elementScrollDownWithTopMenu(this.getPassportMonthDropDown());
		getPassportMonthDropDown().click();
	}

	public void clickValuePassportMonthDropDown(int index) {
		List<WebElement> listPassportMonth = driver
				.findElements(By.xpath("//*[@name='passport_issuance_month_1']//option"));
		listPassportMonth.get(index).click();
	}

	// -- Click Passport Day ---- DIANA
	public WebElement getPassportDayDropDown() {
		return passport_issuance_dayDropDown;
	}

	public void clickPassportDayDropDown() {
		getPassportDayDropDown().click();
	}

	public void clickValuePassportDayDropDown(int index) {
		List<WebElement> ListPassportDay = driver
				.findElements(By.xpath("//*[@name='passport_issuance_day_1']//option"));
		ListPassportDay.get(index).click();
	}

	// --- Click Passport Year  ---- DIANA
	public WebElement getPassportYearDropDown() {
		return passport_issuance_year_DropDown;
	}

	public void clickPassportYearDropDown() {
		getPassportYearDropDown().click();
	}

	public void clickValuePassportYearDropDown(int index) {
		List<WebElement> ListPassportYear = driver
				.findElements(By.xpath("//*[@name='passport_issuance_year_1']//option"));
		ListPassportYear.get(index).click();
	}

	/// Passport Expiry Date ---- DIANA
	// --- Expiry Month
	public WebElement getExpiryMonthDropDown() {
		return passport_month_DropDown;
	}

	public void clickExpiryMonthDropDown() {
		getExpiryMonthDropDown().click();
	}

	public void clickValueMonthDropDown(int index) {
		List<WebElement> listExpiryMonth = driver.findElements(By.xpath("//*[@name='passport_month_1']//option"));
		listExpiryMonth.get(index).click();
	}

	// --- Expiry Day ------ DIANA
	public WebElement getExpiryDayDropDown() {
		return passport_day_DropDown;
	}

	public void clickExpiryDayDropDown() {
		getExpiryDayDropDown().click();
	}

	public void clickValueExpiryDayDropDown(int index) {
		List<WebElement> listExpiryDay = driver.findElements(By.xpath("//*[@name='passport_day_1']//option"));
		listExpiryDay.get(index).click();
	}

	// --- Expiry Year ---- DIANA
	public WebElement getExpiryYearDropDown() {
		return passport_year_DropDown;
	}

	public void clickExpiryYearDropDown() {
		getExpiryYearDropDown().click();
	}

	public void clickValueExpiryYearDropDown(int index) {
		List<WebElement> listExpiryYear = driver.findElements(By.xpath("//*[@name='passport_year_1']//option"));
		listExpiryYear.get(index).click();
	}

	// PAY LATER ----- DIANA
	public WebElement getPayLaterRadioBtn() {
		return payLaterRadioBtn;
	}

	public void clickPayLaterRadioBtn() {
		utils.elementScrollDown(this.getPayLaterRadioBtn());
		getPayLaterRadioBtn().click();
	}

	// Pay with stripe ------ DIANA
	public WebElement getPayStripe() {
		return payWithStripeRadioBtn;
	}

	public void clickPayStripeRadioBtn() {
		utils.elementScrollDown(this.getPayStripe());
		getPayStripe().click();
	}

	// ACCEPT TERMS AND CONDITIONS ---- DIANA
	public WebElement getTermsConditionsCheckBox() {
		return termsAndConditionsCheckBox;
	}

	public void clickTermsConditionsCheckBox() {
		utils.elementScrollDown(this.getTermsConditionsCheckBox());
		getTermsConditionsCheckBox().click();
	}

	// CONFIRM BOOKING BTN ----- DIANA
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
