package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTFlightSearchResultsPage;
import phptravelsPageObjectRepository.PTFlightsPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;

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
		PTAgentPage agentPage = new PTAgentPage(driver);
		PTFlightsPage searchFlightPage = new PTFlightsPage(driver);
		PTFlightSearchResultsPage flightsPage = new PTFlightSearchResultsPage(driver);
		PTBookingFormPage travellerFormPage = new PTBookingFormPage(driver);
		utilities utils = new utilities(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// ========================= SIGN IN PAGE ====================================

		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickBtnAccount();

		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER EMAIL
		// loginPage.enterEmailInput("agent.phptravels@gmail.com");
		loginPage.enterEmailInput("agent@phptravels.com");

		// ENTER PASSWORD
		// loginPage.enterPasswordInput("26dediciembre");
		loginPage.enterPasswordInput("demoagent");

		// CLICK LOGIN BUTTON
		loginPage.clickLoginButtonAgent();

		// ======================== FLIGHTS SEARCH WINDOW ========================

		// ENTER SECTION FLIGHTS
		menuPage.clickbtnFlights();

		// ENTER CITY FLYING FROM
		searchFlightPage.writeFlyingFromOneWay("LHE");

		// CLICK FIRST OPTION
		searchFlightPage.selectItemFlyingFromOneWay();

		// ENTER CITY TO DESTINATION
		searchFlightPage.writeFlyingDestinationOneWay("DXB");

		// CLICK SECOND OPTION
		searchFlightPage.selectItemFlyingDestinationOneWay();

		// CLICK DATE FLY INPUT FOR TO SEE OPTIONS
		searchFlightPage.selectDepartureDateBox();
		searchFlightPage.clickDayDeparture();

		// CLICK TO SEE OPTIONS FROM PASSANGERS
		searchFlightPage.clickPassengersBox();

		// PRINT NUMBER OF PASSENGERS
		searchFlightPage.PrintNumberPassangers();

		// SEARCH FLIGHTS BUTTON
		searchFlightPage.clickSearchFlights();

		// ========== TOTAL FLIGHTS WINDOW ==========
		// SELECT FIRST TRAVEL OPTION BOOK NOW
		flightsPage.clickFirstFlight();


		// ======== ENTER TRAVELLERS INFORMATION =======
		// FIRST NAME
		travellerFormPage.writefirstNametb("Barry");

		// LAST NAME
		travellerFormPage.writelastNametb("Allen");

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "200");

		// NATIONALITY
		travellerFormPage.clickDropdownNationality();
		travellerFormPage.selectValueNationality();

		// DATE OF BIRTH
		// MONTH
		travellerFormPage.selectDropDownMonth();
		travellerFormPage.selectDateOfBirth();

		// DAY
		travellerFormPage.selectDropDownDay();
		travellerFormPage.selectDay();

		// YEAR
		travellerFormPage.selectDropDownYear();
		travellerFormPage.selectYear();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "700");

		// ================ PASSPORT INFORMATION ==================
		// PASSPORT ID
		travellerFormPage.writePassport("C03005988");

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "400");

		// ================ PASSPORT ISSUANCE INFORMATION ==================
		// PASSPORT ISSUANCE MONTH
		travellerFormPage.selectPassportMonth();
		travellerFormPage.itemPassportMonth();

		// PASSPORT ISSUANCE DAY
		travellerFormPage.selectPassportDay();
		travellerFormPage.itemPassportDay();

		// PASSPORT ISSUANCE YEAR
		travellerFormPage.selectPassportYear();
		travellerFormPage.itemPassportYear();

		// ================ PASSPORT EXPIRY INFORMATION ==================
		// PASSPORT EXPIRY MONTH
		travellerFormPage.selectExpiryMonth();
		travellerFormPage.itemExpiryMonth();

		// PASSPORT EXPIRY DAY
		travellerFormPage.selectExpiryDay();
		travellerFormPage.itemExpiryDay();

		// PASSPORT EXPIRY YEAR
		travellerFormPage.selectExpiryYear();
		travellerFormPage.itemExpiryYear();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "900");

		// ================ PAYMENT METHOD INFORMATION ==================
		// CLICK RADIOBUTTON PAY WITH STRIPE METHOD TRAVELLER WINDOW
		travellerFormPage.selectPayStripeRadioBtn();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "1600");
		
		// CLICK CHECKBOX AGREE TERMS AND CONDITIONS
		travellerFormPage.selectCheckBoxTerms();

		// CONFIRM BOOKING
		travellerFormPage.clickBookingBtn();

		// ================= VERIFY DATA =========================
		// PRINT BOOKING STATUS
		agentPage.VerifyBookingStatus();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "300");

		// ACCOUNT DATA
		agentPage.VerifyFirstDataBooking(); // FIRST NAME, LAST NAME, EMAIL, PHONE, ADDRESS
		agentPage.VerifySecondDataBooking(); // COMPANY NAME, EMAIL, PHONE, ADDRESS COMPANY

		// TRAVELLER DATA
		agentPage.VerifyFirstDataTraveller(); // NAME, NATIONALITY, DATE OF BIRTH
		agentPage.VerifySecondDataTraveller(); // PASSPORT NO., PASSPORT EXPIRY, PASSPORT ISSUANCE

		// VERIFY AMOUNT

	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}

}
