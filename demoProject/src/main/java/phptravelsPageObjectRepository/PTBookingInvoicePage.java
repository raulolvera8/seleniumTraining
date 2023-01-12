package phptravelsPageObjectRepository;

import java.time.Duration;
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
import org.testng.Assert;

import library.utilities;

public class PTBookingInvoicePage {
	WebDriver driver;

	public PTBookingInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	PTBookingFormPage form = new PTBookingFormPage(driver);
	utilities utils = new utilities(driver);

	// ---- Booking status
	@FindBy(xpath = "//li[contains(.,'user@phptravels.com')]")
	WebElement emailLabel;
	// ------ VALIATION BOOKING UNPAID STATUS HOTEL ------
	@FindBy(xpath = "//div[@class='infobox infobox-danger'][contains(.,'Your booking status is ( Pending ) and payment status is stripe ( Unpaid )')]")
	WebElement paymentStatusStripeLabel;
	@FindBy(xpath = "//*[@class='py-0 card-text'][contains(.,'Checkin')]")
	WebElement checkInOutLabel;
	@FindBy(xpath = "//*[@class='list-group-item'][contains(.,'Total Price')]")
	WebElement totalPriceLabel;
	@FindBy(xpath = "//*[@class='list-group-item'][contains(.,'Room Type')]")
	WebElement hotelNameLabel;

	public WebElement getHotelNameLabel() {
		return hotelNameLabel;
	}

	public String readHotelNameLabel() {
		String hotelNameLabel = getHotelNameLabel().getText();
		return hotelNameLabel;
	}

	public WebElement getPriceUnpaidLabel() {
		return totalPriceLabel;
	}

	public String readTotalPriceUnpaidLabel() {
		String totalPriceUnpaidLabel = getPriceUnpaidLabel().getText();
		return totalPriceUnpaidLabel;
	}

	public WebElement getCheckInOutLabel() {
		return checkInOutLabel;
	}

	public String readCheckOutIn() {
		String checkOutInLabel = getCheckInOutLabel().getText();
		return checkOutInLabel;
	}

	public WebElement getpaymentStatusStripeLabel() {
		return paymentStatusStripeLabel;
	}

	// -- VALIATION BOOKING UNPAID STATUS HOTEL
	public void validationStatusStripe() {
		if (getpaymentStatusStripeLabel().getText().contains("Stripe")) {
			System.out.println("FIRST VALIDATION  PASSED");
			System.out.println(getpaymentStatusStripeLabel().getText());
			
		} else {
			Assert.fail("FIRST VALIDATION FAILED");
		}
	}

	// ------ VALIATION BOOKING CONFIRMED STATUS HOTEL ------
	@FindBy(xpath = "//div[@class='infobox infobox-success'][contains(.,' ( Paid')]")
	WebElement paymentStatusPaidLabel;

	public WebElement getPaymentStatusPaidLabel() {
		return paymentStatusPaidLabel;
	}

	public WebElement getTotalPriceLabel() {
		return totalPriceLabel;
	}

	public String readTotalPricePaidLabel() {
		String totalPricePaidLabel = getTotalPriceLabel().getText();
		return totalPricePaidLabel;
	}

	public void validationStatusPaid() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOf(paymentStatusPaidLabel));

		if (paymentStatusPaidLabel.getText().contains("Paid")) {
			System.out.println(getPaymentStatusPaidLabel().getText());
		} else {
			Assert.fail("FAILED: Invoice status doesn't match");
		}
	}

	// ------ VALIATION BOOKING STATUS FLIGHT ------
	@FindBy(xpath = "//*[@class='card mt-2 mb-3']")
	WebElement travellerDetails;
	@FindBy(xpath = "//*[@class='customer']/li[contains(.,'Guest')]")
	WebElement nameTravellerLabel;
	@FindBy(xpath = "//*[@class='customer']/li[contains(.,'Passport No :')]")
	WebElement passportNumLabel;
	@FindBy(xpath = "//*[@class='customer']/li[contains(.,'Passport Expiry :')]")
	WebElement passportExpiryLabel;
	@FindBy(xpath = "//div[@class='infobox infobox-warning'][contains(.,'Your booking status is ( Pending ) and payment status is pay later ( Unpaid )')]")
	WebElement paymentStatusPLaterLabel;

	public WebElement getTravellerDetails() {
		return travellerDetails;
	}

	public WebElement getNameTravellerLabel() {
		return nameTravellerLabel;
	}

	public WebElement getPassportNumLabel() {
		return passportNumLabel;
	}

	public WebElement getPassportExpiryLabel() {
		return passportExpiryLabel;
	}

	public WebElement getPaymentStatusPLaterLabel() {
		return paymentStatusPLaterLabel;
	}

	public void validationStatusLater() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOf(paymentStatusPLaterLabel));
		
		String nombre = getNameTravellerLabel().getText().substring(8);
		String passportNum = getPassportNumLabel().getText().substring(12);
		String passportExpiry = getPassportExpiryLabel().getText().substring(16);

		System.out.println("BOOKING INVOICE UNPAID");
		if (getPaymentStatusPLaterLabel().getText().contains("Pay Later")) {
			System.out.println("PASSED: Payment status is correct");
			System.out.println(getPaymentStatusPLaterLabel().getText());
		} else {
			Assert.fail("FAILED");
		}
		if ((getTravellerDetails().getText().contains(nombre))
				& (getTravellerDetails().getText().contains(passportExpiry))
				& (getTravellerDetails().getText().contains(passportNum))) {
			System.out.println("PASSED: Traveller information is correct");
			System.out.println(getTravellerDetails().getText());
		} else {
			Assert.fail("FAILED: Traveller information doesn't match");
		}
	}

	// Proceed Button
	@FindBy(id = "form")
	WebElement proceedPayBtn;

	public WebElement getPrceedPayBtn() {
		return proceedPayBtn;
	}
	

	public void clickProceedPayBtn() {

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getPrceedPayBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@style='width:450px']/img")));
		System.out.println("Stripe Window");

	}

	// -- VALIATION BOOKING STATUS PENDIENTE - AGENT - IRIS
	@FindBy(xpath = "//li[contains(.,'agent@phptravels.com')]")
	WebElement reservationAccountAgent;

	public void validationStatusBooking() {
		System.out.println("BOOKING INVOICE WINDOW");
		if (reservationAccountAgent.getText().contentEquals("Email: agent@phptravels.com")) {
			System.out.println(paymentStatusStripeLabel.getText());
			System.out.println(reservationAccountAgent.getText());
		} else {
			Assert.fail("FAILED");
		}
	}
	// -------------------------------------------------------------


	/// -------- PRINT STATUS PENDING LABEL FROM BOOKING - IRIS
	@FindBy(xpath = "//div[@class='infobox infobox-danger']")
	WebElement bookingStatusDanger;

	private WebElement getBookingStatus() {
		return bookingStatusDanger;
	}

	public void PrintBookingStatus() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getBookingStatus().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='infobox infobox-danger']")));
		System.out.println(getBookingStatus().getText());
	}
	// -------------------------------------------------------------


	/// -------- PRINT STATUS CONFIRMED LABEL FROM BOOKING - IRIS
	@FindBy(xpath = "//li[contains(.,'agent@phptravels.com')]")
	WebElement emailLabelAgent;

	public void PrintBookingStatusConfirmed() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'agent@phptravels.com')]")));
		System.out.println("BOOKING INVOICE PAID");
		if (emailLabelAgent.getText().contentEquals("Email: agent@phptravels.com")) {
			System.out.println(paymentStatusPaidLabel.getText());
		} else {
			Assert.fail("FAILED: The payment was no successfull");
		}
	}
	// -------------------------------------------------------------


	/// --- PRINT LABELS DATA ON BOOKING VIEW (PERSONAL DATA, NAME, LAST NAME,
	/// EMAIL,
	/// PHONE, ADDRESS) - IRIS
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
	// -------------------------------------------------------------


	/// ---- PRINT LABELS DATA ON BOOKING VIEW (COMPANY DATA, NAME, EMAIL, PHONE,
	/// ADDRESS) - IRIS
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
	// -------------------------------------------------------------


	/// ---- PRINT LABELS TRAVELLER DATA 1 (NAME, NATIONALITY, DATE OF BIRTH) - IRIS
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
	// -------------------------------------------------------------


	/// ---- PRINT LABELS TRAVELLER DATA 2 (PASSPORT NO., PASSPORT EXPIRY, PASSPORT
	/// ISSUANCE) --- IRIS
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
	// -------------------------------------------------------------


	// -----VISA VALIDATION -------
	@FindBy(xpath = "//*[@class='card-body my-5 text-center']//h2")
	WebElement validationMsg;

	public WebElement getValidationVisa() {
		return validationMsg;
	}

	public void printVisaValidation() {
		String validation = getValidationVisa().getText();
		System.out.println("Demo: " + validation);
		if (getValidationVisa().getText().contains("Your visa form has been submitted")) {
			System.out.println(getValidationVisa().getText());
		} else {
			Assert.fail();
		}
	}

	///////// ---------------VERIFY BOOKING DETAILS ---------------
	/// ---JUAN
	// VALIDATION INFORMATION DETAILS
	@FindBy(xpath = "//*[@class='list-group list-group-flush']")
	WebElement validationInfoDetails;

	public WebElement getValidationInfoDetails() {
		return validationInfoDetails;
	}

	public void printValidationInformation() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOf(validationInfoDetails));
		
		if (getValidationInfoDetails().getText().contains("Booking Details")) {
			System.out.println(getValidationInfoDetails().getText());
		} else {
			Assert.fail();
		}
	}

//VALIDATION INFORMATION GUEST
	@FindBy(xpath = "//*[@class='card-body']")
	WebElement validationGuestInformation;

	public WebElement getValidationGuestInformation() {
		return validationGuestInformation;
	}

	public void printValidationGuestInformation() {
		if (getValidationGuestInformation().getText().contains("Guest Information")) {
			System.out.println(getValidationGuestInformation().getText());
		} else {
			Assert.fail();
		}
	}

	@FindBy(xpath = "//*[@class='infobox infobox-success']")
	WebElement validationStatusAndPayment;

	public WebElement getValidationStatusAndPayment() {
		return validationStatusAndPayment;
	}

	public void printValidationStatusAndPayment() {
		if (getValidationStatusAndPayment().getText()
				.contains("  Your booking status is ( Confirmed ) and payment status is stripe ( Paid )   ")) {
			System.out.println(getValidationStatusAndPayment().getText());
		} else {
			Assert.fail();
		}
	}

	@FindBy(xpath = "//*[@class='list-group-item'][contains(.,'Tours Date')]")
	WebElement dateLabel;

	public void validateDateLabel() {

		System.out.println("BOOKING INVOICE PAID");
		if (emailLabel.getText().contentEquals("Email: user@phptravels.com")) {

			// System.out.println(paymentStatusPaidLabel.getText());
			// System.out.println(bookingInvoiceDetails.getText());
			System.out.println(dateLabel.getText());
		} else {
			Assert.fail("FAILED");
		}
	}

	@FindBy(xpath = "//*[@class='card-title m-0']")
	WebElement titleHotel;

	public void validateTitleHotel() {

		System.out.println("Sheraton Trip");
		if (emailLabel.getText().contentEquals("Email: user@phptravels.com")) {

			// System.out.println(paymentStatusPaidLabel.getText());
			// System.out.println(bookingInvoiceDetails.getText());
			System.out.println(titleHotel.getText());
		} else {
			Assert.fail("FAILED");
		}

	}
}
