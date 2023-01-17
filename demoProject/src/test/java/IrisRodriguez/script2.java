package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTFlightSearchResultsPage;
import phptravelsPageObjectRepository.PTFlightsPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;
import phptravelsPageObjectRepository.PTPayWithCardPage;
import phptravelsPageObjectRepository.PTPaymentWithStripePage;

public class script2 extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}

	@Test
	public void ShoppingHome() throws InterruptedException {

		// ===================== DECLARAR LAS PAGINAS DE OBJETOS =====================
		// SIGN IN PAGE
		PTHomePage signInPage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTMenuPage menuPage = new PTMenuPage(driver);
		PTFlightsPage searchFlightPage = new PTFlightsPage(driver);
		PTFlightSearchResultsPage flightsPage = new PTFlightSearchResultsPage(driver);
		PTBookingFormPage travellerFormPage = new PTBookingFormPage(driver);
		PTBookingInvoicePage bookingInvoicePage = new PTBookingInvoicePage(driver);
		PTPayWithCardPage cardPage = new PTPayWithCardPage(driver);
		PTPaymentWithStripePage stripePage = new PTPaymentWithStripePage(driver);
		utilities utils = new utilities(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// ========================= SIGN IN PAGE ====================================

		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickAccountBtn();

		// AQUI SE GUARDA QUE ESTÁS EN LA VENTANA PRINCIPAL
		utils.saveMainWindowHandle();

		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER EMAIL
		loginPage.enterEmailInput("agent@phptravels.com");

		// ENTER PASSWORD
		loginPage.enterPasswordInput("demoagent");

		// CLICK LOGIN BUTTON
		loginPage.clickLoginButtonAgent();

		// ======================== FLIGHTS SEARCH WINDOW ========================

		// ENTER SECTION FLIGHTS
		menuPage.clickbtnFlights();

		// ENTER CITY FLYING FROM
		searchFlightPage.writeFlyingFromOneWayTb("LHE");

		// CLICK FIRST OPTION
		searchFlightPage.selectItemFlyingFromOneWayDropDown();

		// ENTER CITY TO DESTINATION
		searchFlightPage.writeFlyingDestinationOneWayTb("DXB");

		// CLICK SECOND OPTION
		searchFlightPage.selectItemFlyingDestinationOneWayDropDown();

		// CLICK DATE FLY INPUT FOR TO SEE OPTIONS
		searchFlightPage.selectDepartureDateCalendarBox();
		searchFlightPage.clickDayDepartureCalendar();

		// CLICK TO SEE OPTIONS FROM PASSANGERS
		searchFlightPage.clickPassengersBox();

		// PRINT NUMBER OF PASSENGERS
		searchFlightPage.PrintNumberPassangers();

		// SEARCH FLIGHTS BUTTON
		searchFlightPage.clickSearchFlightsBtn();

		// ========== TOTAL FLIGHTS WINDOW ==========
		// SELECT FIRST TRAVEL OPTION BOOK NOW
		flightsPage.clickFirstFlightBtn();

		// ======== ENTER TRAVELLERS INFORMATION =======
		// FIRST NAME
		travellerFormPage.writefirstNametb("Barry");

		// LAST NAME
		travellerFormPage.writelastNametb("Allen");

		// NATIONALITY FROM TRAVELLER DETAILS
		travellerFormPage.clickNationality_1DropDown();
		travellerFormPage.clickValueNationality_1DropDown();

		// DATE OF BIRTH
		// MONTH
		travellerFormPage.clickMonthDropDown();
		travellerFormPage.clickValueDateOfBirthDropDown(3);

		// DAY
		travellerFormPage.clickDayDropDown();
		travellerFormPage.clickValueDayDropDown(14);

		// YEAR
		travellerFormPage.clickYearDropDown();
		travellerFormPage.clickValueYearDropDown(38);

		// ================ PASSPORT INFORMATION ==================
		// PASSPORT ID
		travellerFormPage.writePassportTb("C03005988");

		// ================ PASSPORT ISSUANCE INFORMATION ==================
		// PASSPORT ISSUANCE MONTH
		travellerFormPage.clickPassportMonthDropDown();
		travellerFormPage.clickValuePassportMonthDropDown(2);

		// PASSPORT ISSUANCE DAY
		travellerFormPage.clickPassportDayDropDown();
		travellerFormPage.clickValuePassportDayDropDown(4);

		// PASSPORT ISSUANCE YEAR
		travellerFormPage.clickPassportYearDropDown();
		travellerFormPage.clickValuePassportYearDropDown(4);

		// ================ PASSPORT EXPIRY INFORMATION ==================
		// PASSPORT EXPIRY MONTH
		travellerFormPage.clickExpiryMonthDropDown();
		travellerFormPage.clickValueMonthDropDown(2);

		// PASSPORT EXPIRY DAY
		travellerFormPage.clickExpiryDayDropDown();
		travellerFormPage.clickValueExpiryDayDropDown(2);

		// PASSPORT EXPIRY YEAR
		travellerFormPage.clickExpiryYearDropDown();
		travellerFormPage.clickValueExpiryYearDropDown(3);

		// ================ PAYMENT METHOD INFORMATION ==================
		// CLICK RADIOBUTTON PAY WITH STRIPE METHOD TRAVELLER WINDOW
		travellerFormPage.clickPayStripeRadioBtn();

		// CLICK CHECKBOX AGREE TERMS AND CONDITIONS
		travellerFormPage.clickTermsConditionsCheckBox();

		// CONFIRM BOOKING
		travellerFormPage.clickBookingBtn();

		// ================= VERIFY DATA =========================
		// VALIDATE BOOKING STATUS
		bookingInvoicePage.validationStatusStripe();

		// PRINT STATUS
		// bookingInvocePage.PrintBookingStatus();

		// PRINT ACCOUNT DATA
		// bookingInvoicePage.VerifyFirstDataBooking(); // FIRST NAME, LAST NAME, EMAIL,
		// PHONE, ADDRESS
		// bookingInvoicePage.VerifySecondDataBooking(); // COMPANY NAME, EMAIL, PHONE,
		// ADDRESS COMPANY

		// PRINT TRAVELLER DATA
		bookingInvoicePage.VerifyFirstDataTraveller(); // NAME, NATIONALITY, DATE OF BIRTH
		bookingInvoicePage.VerifySecondDataTraveller(); // PASSPORT NO., PASSPORT EXPIRY, PASSPORT ISSUANCE

		// PROCEED TO CHECK
		bookingInvoicePage.clickProceedPayBtn();

		// ======================== WINDOW PAYMENT WITH STRIPE ==================
		// VERIFY PAYMENT
		stripePage.VerifylabelAmount();

		// CLICK PAY NOW WITH AMOUNT
		stripePage.PayNowWithAmount();

		// ======================== WINDOW PAY WITH CARD FORM ==================
		// ENTER NUMBER CARD
		cardPage.CardNumberInput("4242 4242 4242 4242");

		// ENTER CARD EXPIRY
		cardPage.CardExpiryInput("0630");

		// ENTER CARD CVC
		cardPage.CardCVCInput("123");

		// ENTER NAME
		cardPage.NameCardInput("Agent Selenium");

		// CLICK PAGAR BUTTON
		cardPage.clickPagarButtonWithInfoCard();

		// PRINT BOOKING STATUS CONFIRMED
		bookingInvoicePage.PrintBookingStatusConfirmed();

		// PRINT TRAVELLER DATA
		bookingInvoicePage.VerifyFirstDataTraveller(); // NAME, NATIONALITY, DATE OF BIRTH
		bookingInvoicePage.VerifySecondDataTraveller(); // PASSPORT NO., PASSPORT EXPIRY, PASSPORT ISSUANCE

		// SE CIERRA LA SEGUNDA VENTANA
		utils.CloseCurrentWindow();

		// SWITCH TO THE MAIN WINDOW
		utils.switchToMainWindow();
	}

	@AfterClass
	public void teardown() {
		teardownDriver();
	}

}
