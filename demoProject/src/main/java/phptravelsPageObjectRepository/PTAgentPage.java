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