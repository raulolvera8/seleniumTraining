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

public class PTAgentPage {

	WebDriver driver;

	public PTAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// -------- ADD FUNDS BUTTON --------
	@FindBy(xpath = "//a[ contains (text(), 'Add Funds') and @class=' waves-effect']")
	WebElement btnAddFunds;

	private WebElement getbtnAddFunds() {
		return btnAddFunds;
	}

	public void clickBtnAddFunds() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(40), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnAddFunds().click();

		System.out.println("Clicking Add Funds button...");
	}

	/// -------- SELECT STRIPE RADIOBUTTON --------
	@FindBy(xpath = "//input[@name='payment_gateway' and @value='stripe']")
	WebElement rbtnStripePayment;

	private WebElement getStripePayment() {
		return rbtnStripePayment;
	}

	public void clickrbtnStripePayment() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains (text(), 'Payment Method')]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getStripePayment().click();
		System.out.println("Clicking radiobutton Stripe payment method ...");
	}

	/// -------- CLEAR AMOUNT INPUT --------
	@FindBy(name = "price")
	WebElement inputPriceClear;

	private WebElement getPriceInputClean() {
		return inputPriceClear;
	}

	public void clearPrice() {
		getPriceInputClean().clear();
	}

	/// -------- ENTER AMOUNT INPUT --------
	@FindBy(name = "price")
	WebElement inputPrice;

	private WebElement getPriceInput() {
		return inputPrice;
	}

	public void enterPrice(String Price) {
		System.out.println("Entering price ...");
		getPriceInput().sendKeys(Price);
	}

	/// -------- CLICK PAY NOW BUTTON --------
	@FindBy(xpath = "//button[contains (text(), 'Pay Now') and @type='submit']")
	WebElement PayNowButton;

	private WebElement getPayNowButton() {
		return PayNowButton;
	}

	public void clickPayNowButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));

		getPayNowButton().click();
		System.out.println("Clicking Pay Now button ...");
	}



	/// -------- VERIFY PAYMENT SUCCESSFULL --------

	@FindBy(xpath = "//strong[contains (text(), 'Payment successfull')]")
	WebElement labelSuccessfull;

	private WebElement getLabelSuccessfull() {
		return labelSuccessfull;
	}

	public void Verifylabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getLabelSuccessfull().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//strong[contains (text(), 'Payment successfull')]")));

		System.out.println("Hi, Agent.. " + getLabelSuccessfull().getText());
	}

	/// -------- LOGOUT BUTTON FROM USER VIEW --------
	@FindBy(xpath = "(//a[ contains (text(), 'Logout')])[2]")
	WebElement LogOut;

	private WebElement getLogouttButton() {
		return LogOut;
	}

	public void ClickLogoutButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[ contains (text(), 'Logout')])[2]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getLogouttButton().click();
		System.out.println("Clicking LOGOUT button ...");
	}

	
	/// -------- WALLET BALANCE --------
	@FindBy(xpath = "//p[contains (text(), 'Wallet Balance') and @class='info__desc']")
	WebElement walletbalance;

	private WebElement getWalletBalance() {
		return walletbalance;
	}

	public void VerifyWalletBalance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains (text(), 'Wallet Balance') and @class='info__desc']")));

		System.out.println("Hi, Your " + getWalletBalance().getText());
	}

	/// -------- VERIFY AMOUNT BLANCE --------
	@FindBy(xpath = "//h4[contains (text(), 'USD ') and @class='info__title']")
	WebElement walletbalanceAmount;

	private WebElement getWalletBalanceAmount() {
		return walletbalanceAmount;
	}

	public void VerifyWalletBalanceAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[contains (text(), 'USD ') and @class='info__title']")));

		System.out.println("Is now " + getWalletBalanceAmount().getText());
	}


	/// ========== DEMO INFORMATION FROM BOOK FLIGHT VIEW ============
	/// ------- FIRST NAME -------
	@FindBy(xpath = "(//div[@class='row'])[3]")
	WebElement firstnameLabel;

	private WebElement getfirstnamelabel() {
		return firstnameLabel;
	}

	public void PrintFirstName() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[3]")));

		System.out.println(getfirstnamelabel().getText());
	}

	/// ------- LAST NAME -------
	@FindBy(xpath = "(//div[@class='row'])[4]")
	WebElement lastnameLabel;

	private WebElement getlastnamelabel() {
		return lastnameLabel;
	}

	public void PrintLastNameLabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[4]")));

		System.out.println(getlastnamelabel().getText());
	}

	/// ------- EMAIL -------
	@FindBy(xpath = "(//div[@class='row'])[5]")
	WebElement emailLabel;

	private WebElement getEmailLabel() {
		return emailLabel;
	}

	public void PrintEmailLabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[5]")));

		System.out.println(getEmailLabel().getText());
	}

	/// ========== TRAVELLER INFORMATION ============

	/// ------ FIRST NAME ---------
	@FindBy(name = "firstname_1")
	WebElement firstnameTraveller1;

	private WebElement getfirstnameTraveller1() {
		return firstnameTraveller1;
	}

	public void firstnameTraveler1Input(String firstnameTraveller1) {
		System.out.println("Entering first name Traveller 1 ...");
		getfirstnameTraveller1().sendKeys(firstnameTraveller1);
	}

	/// ------ LAST NAME --------
	@FindBy(name = "lastname_1")
	WebElement lastnameTraveller1;

	private WebElement getlastnameTraveller1() {
		return lastnameTraveller1;
	}

	public void lastnameTraveler1Input(String lastnameTraveller1) {
		System.out.println("Entering last name Traveller 1 ...");
		getlastnameTraveller1().sendKeys(lastnameTraveller1);
	}

	/// -------- SELECT NATIONALITY -----------
	@FindBy(xpath = "//select[@name='nationality_1']")
	WebElement nationalityTraveller1;

	public WebElement getDropDownNationality() {
		return nationalityTraveller1;
	}

	public void selectDropDownNationality() {
		getDropDownNationality().click();
	}

	public void selectValueNationality() {
		System.out.println("Selecting Nationality ...");
		List<WebElement> listNationality = driver.findElements(By.xpath("//*[@name='nationality_1']//option"));
		listNationality.get(5).click();
	}

	/// -------- SELECT DATE OF BIRTH MONTH -----------
	@FindBy(xpath = "//*[@name='dob_month_1']")
	WebElement MonthTraveller1;

	public WebElement getDropDownMonth() {
		return MonthTraveller1;
	}

	public void selectDropDownMonth() {
		getDropDownMonth().click();
	}

	public void selectValueMonth() {
		System.out.println("Selecting month of birth ...");
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='dob_month_1']//option"));
		listMonth.get(3).click();
	}

	/// -------- SELECT DAY -----------
	@FindBy(xpath = "//*[@name='dob_day_1']")
	WebElement DayTraveller1;

	public WebElement getDropDownDay() {
		return MonthTraveller1;
	}

	public void selectDropDownDay() {
		getDropDownDay().click();
	}

	public void selectValueDay() {
		System.out.println("Selecting day of birth ...");
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='dob_day_1']//option"));
		listDay.get(14).click();
	}

	/// -------- SELECT YEAR -----------
	@FindBy(xpath = "//*[@name='dob_year_1']")
	WebElement YearTraveller1;

	public WebElement getDropDownYear() {
		return YearTraveller1;
	}

	public void selectDropDownYear() {
		getDropDownYear().click();
	}

	public void selectValueYear() {
		System.out.println("Selecting year of birth ...");
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='dob_year_1']//option"));
		listYear.get(39).click();
	}

	/// =============== PASSPORT INFORMATION ====================

	/// ------ PASSPORT ID -----------
	@FindBy(xpath = "//input[@name='passport_1']")
	WebElement passportID;

	private WebElement getpassportID() {
		return passportID;
	}

	public void EnterPassportID(String passportId) {
		System.out.println("Entering Passport ID ...");
		getpassportID().sendKeys(passportId);
	}

	/// ============== PASSPORT ISSUANCE INFORMATION ============
	/// -------- SELECT PASSPORT ISSUANCE MONTH -----------
	@FindBy(xpath = "//*[@name='passport_issuance_month_1']")
	WebElement PassportIssuanceMonth;

	public WebElement getDropDownPassportIssuanceMonth() {
		return PassportIssuanceMonth;
	}

	public void selectDropDownPassportIssuanceMonth() {
		getDropDownPassportIssuanceMonth().click();
	}

	public void selectValuePassportIssuanceMonth() {
		System.out.println("Selecting month of passport issuance ...");
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='passport_issuance_month_1']//option"));
		listMonth.get(2).click();
	}

	/// -------- SELECT PASSPORT ISSUANCE DAY -----------
	@FindBy(xpath = "//*[@name='passport_issuance_day_1']")
	WebElement PassportIssuanceDay;

	public WebElement getDropDownPassportIssuanceDay() {
		return PassportIssuanceDay;
	}

	public void selectDropDownPassportIssuanceDay() {
		getDropDownPassportIssuanceDay().click();
	}

	public void selectValuePassportIssuanceDay() {
		System.out.println("Selecting day of passport issuance ...");
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='passport_issuance_day_1']//option"));
		listDay.get(2).click();
	}

	/// -------- SELECT PASSPORT ISSUANCE YEAR -----------
	@FindBy(xpath = "//*[@name='passport_issuance_year_1']")
	WebElement PassportIssuanceYear;

	public WebElement getDropDownPassportIssuanceYear() {
		return PassportIssuanceYear;
	}

	public void selectDropDownPassportIssuanceYear() {
		getDropDownPassportIssuanceYear().click();
	}

	public void selectValuePassportIssuanceYear() {
		System.out.println("Selecting year of passport issuance ...");
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='passport_issuance_year_1']//option"));
		listYear.get(2).click();
	}

	/// ============== PASSPORT EXPIRY INFORMATION ============
	/// -------- SELECT PASSPORT EXPIRY MONTH -----------
	@FindBy(xpath = "//*[@name='passport_month_1']")
	WebElement PassportExpiryMonth;

	public WebElement getDropDownPassportExpiryMonth() {
		return PassportExpiryMonth;
	}

	public void selectDropDownPassportExpiryMonth() {
		getDropDownPassportExpiryMonth().click();
	}

	public void selectValuePassportExpiryMonth() {
		System.out.println("Selecting month of passport expiry ...");
		List<WebElement> listMonth = driver.findElements(By.xpath("//*[@name='passport_month_1']//option"));
		listMonth.get(2).click();
	}

	/// -------- SELECT PASSPORT EXPIRY DAY -----------
	@FindBy(xpath = "//*[@name='passport_day_1']")
	WebElement PassportExpiryDay;

	public WebElement getDropDownPassportExpiryDay() {
		return PassportExpiryDay;
	}

	public void selectDropDownPassportExpiryDay() {
		getDropDownPassportExpiryDay().click();
	}

	public void selectValuePassportExpiryDay() {
		System.out.println("Selecting day of passport expiry ...");
		List<WebElement> listDay = driver.findElements(By.xpath("//*[@name='passport_day_1']//option"));
		listDay.get(3).click();
	}

	/// -------- SELECT PASSPORT ISSUANCE YEAR -----------
	@FindBy(xpath = "//*[@name='passport_year_1']")
	WebElement PassportExpiryYear;

	public WebElement getDropDownPassportExpiryYear() {
		return PassportExpiryYear;
	}

	public void selectDropDownPassportExpiryYear() {
		getDropDownPassportExpiryYear().click();
	}

	public void selectValuePassportExpiryYear() {
		System.out.println("Selecting year of passport expiry ...");
		List<WebElement> listYear = driver.findElements(By.xpath("//*[@name='passport_year_1']//option"));
		listYear.get(1).click();
	}

	/// ------- SELECT PAY WITH STRIPE FORM TRAVELLER
	@FindBy(xpath = "//input[@id='gateway_stripe']")
	WebElement rbtnPayWithStripe;

	private WebElement getPaymentwithStripe() {
		return rbtnPayWithStripe;
	}

	public void clickrbtnPayWithStripe() {
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getPaymentwithStripe().click();
		System.out.println("Clicking radiobutton Stripe payment method ...");
	}

	/// ------- SELECT AGREE THE TERMS AND CONDITIONS
	@FindBy(xpath = "//*[@class='custom-checkbox']")
	WebElement chckAgreeTerms;

	private WebElement getCheckAgreeTerms() {
		return chckAgreeTerms;
	}

	public void clickCheckAgreeTerms() {
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getCheckAgreeTerms().click();
		System.out.println("Clicking checkbutton agree the terms and conditions ...");
	}

	/// -------- CONFIRM BOOKING BUTTON ON VIEW TRAVELLER INFORMATION ------------
	@FindBy(xpath = "//button[@id='booking']")
	WebElement btnConfirmBooking;

	private WebElement getbtnConfirmBooking() {
		return btnConfirmBooking;
	}

	public void ClickConfirmBooking() {
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnConfirmBooking().click();
		System.out.println("Clicking Confirm Booking button ...");
	}

	/// -------- VERIFY BOOKING STATUS
	@FindBy(xpath = "//div[@class='infobox infobox-danger']")
	WebElement bookingStatus;

	private WebElement getBookingStatus() {
		return bookingStatus;
	}

	public void VerifyBookingStatus() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getBookingStatus().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='infobox infobox-danger']")));
		System.out.println(getBookingStatus().getText());
	}

	/// -------- MY BOOKINGS BUTTON FROM USER VIEW --------
	@FindBy(xpath = "(//a[ contains (text(), 'My Bookings')])[2]")
	WebElement MyBookingsButton;

	private WebElement getMyBookingsButton() {
		return MyBookingsButton;
	}

	public void ClickMyBookingsButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[ contains (text(), 'My Bookings')])[2]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getMyBookingsButton().click();
		System.out.println("Clicking My Bookings button ...");
	}

	/// -------- VIEW VOUCHER BUTTON --------
	@FindBy(xpath = "//a[ contains (text(), 'View Voucher')]")
	WebElement ViewVoucher;

	private WebElement getViewVoucher() {
		return ViewVoucher;
	}

	public void ClickViewVoucherButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[ contains (text(), 'View Voucher')]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getViewVoucher().click();
		System.out.println("Clicking View Voucher button ...");
	}

	/// --- VERIFY DATA ON BOOKING VIEW (PERSONAL DATA, NAME, LAST NAME, EMAIL,
	/// PHONE, ADDRESS) --------
	@FindBy(xpath = "(//ul[@class='customer'])[1]")
	WebElement firstData;

	private WebElement getFirstData() {
		return firstData;
	}

	public void VerifyFirstDataBooking() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getFirstData().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='customer'])[1]")));

		System.out.println("BOOKING INVOICE " + getFirstData().getText());
	}

	/// ---- VERIFY DATA ON BOOKING VIEW (COMPANY DATA, NAME, EMAIL, PHONE, ADDRESS)

	@FindBy(xpath = "(//ul[@class='customer'])[2]")
	WebElement secondData;

	private WebElement getSecondData() {
		return secondData;
	}

	public void VerifySecondDataBooking() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getSecondData().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='customer'])[2]")));
		System.out.println(getSecondData().getText());
	}

	/// ---- VERIFY TRAVELLER DATA 1 (NAME, NATIONALITY, DATE OF BIRTH)
	@FindBy(xpath = "(//ul[@class='customer'])[3]")
	WebElement thirdData;

	private WebElement getFirstDataTraveller() {
		return thirdData;
	}

	public void VerifyFirstDataTraveller() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getFirstDataTraveller().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='customer'])[3]")));
		System.out.println(getFirstDataTraveller().getText());
	}
	
	/// ---- VERIFY TRAVELLER DATA 2 (PASSPORT NO., PASSPORT EXPIRY, PASSPORT ISSUANCE)
	@FindBy(xpath = "(//ul[@class='customer'])[4]")
	WebElement fourthData;

	private WebElement getSecondDataTraveller() {
		return fourthData;
	}

	public void VerifySecondDataTraveller() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getSecondDataTraveller().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='customer'])[4]")));
		System.out.println(getSecondDataTraveller().getText());
	}

}