package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTFlightSearchResultsPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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
		PTAgentPage agentPage = new PTAgentPage(driver);
		PTFlightSearchResultsPage flightsPage = new PTFlightSearchResultsPage(driver);
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
		agentPage.clickbtnFlights();

		// ENTER CITY FLYING FROM
		agentPage.flyingFromInput("LHE");

		// CLICK FIRST OPTION
		agentPage.flyingFromAutocomplete();

		// ENTER CITY TO DESTINATION
		agentPage.toDestinationInput("DXB");

		// CLICK SECOND OPTION
		agentPage.ToDestinationAutocomplete();

		// CLICK DATE FLY INPUT FOR TO SEE OPTIONS
		agentPage.DateInput();

		// SELECT 6 DAY FROM CALENDAR PICKER
		agentPage.SelectDateFromCalendar();

		// CLICK TO SEE OPTIONS FROM PASSANGERS
		agentPage.clickTravelersInput();

		// CLICK QUANTITY ADULT
		// agentPage.clickAdultsOptionPlus();

		// PRINT NUMBER OF PASSENGERS
		agentPage.PrintNumberPassangers();

		// SEARCH FLIGHTS BUTTON
		agentPage.clickSearchFlightButton();

		// ========== TOTAL FLIGHTS WINDOW ==========
		// SELECT FIRST TRAVEL OPTION BOOK NOW
		flightsPage.clickFirstFlight();

		// =========== FLIGHTS BOOKING WINDOW ==========

		// PRINT PERSONAL INFORMATION FROM ACCOUNT
		System.out.println("Your Personal Information");
		agentPage.PrintFirstName();
		agentPage.PrintLastNameLabel();
		agentPage.PrintEmailLabel();

		// ======== ENTER TRAVELLERS INFORMATION =======

		// FIRST NAME
		agentPage.firstnameTraveler1Input("Barry");

		// LAST NAME
		agentPage.lastnameTraveler1Input("Allen");

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "200");

		// NATIONALITY
		agentPage.selectDropDownNationality();
		agentPage.selectValueNationality();

		// DATE OF BIRTH
		// MONTH
		agentPage.selectDropDownMonth();
		agentPage.selectValueMonth();

		// DAY
		agentPage.selectDropDownDay();
		agentPage.selectValueDay();

		// YEAR
		agentPage.selectDropDownYear();
		agentPage.selectValueYear();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "700");

		// ================ PASSPORT INFORMATION ==================
		// PASSPORT ID
		agentPage.EnterPassportID("C03005988");

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "400");

		// ================ PASSPORT ISSUANCE INFORMATION ==================
		// PASSPORT ISSUANCE MONTH
		agentPage.selectDropDownPassportIssuanceMonth();
		agentPage.selectValuePassportIssuanceMonth();

		// PASSPORT ISSUANCE DAY
		agentPage.selectDropDownPassportIssuanceDay();
		agentPage.selectValuePassportIssuanceDay();

		// PASSPORT ISSUANCE YEAR
		agentPage.selectDropDownPassportIssuanceYear();
		agentPage.selectValuePassportIssuanceYear();

		// ================ PASSPORT EXPIRY INFORMATION ==================
		// PASSPORT EXPIRY MONTH
		agentPage.selectDropDownPassportExpiryMonth();
		agentPage.selectValuePassportExpiryMonth();

		// PASSPORT EXPIRY DAY
		agentPage.selectDropDownPassportExpiryDay();
		agentPage.selectValuePassportExpiryDay();

		// PASSPORT EXPIRY YEAR
		agentPage.selectDropDownPassportExpiryYear();
		agentPage.selectValuePassportExpiryYear();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "900");

		// ================ PAYMENT METHOD INFORMATION ==================
		// CLICK RADIOBUTTON PAY WITH STRIPE METHOD TRAVELLER WINDOW
		agentPage.clickrbtnPayWithStripe();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "1600");
		// CLICK CHECKBOX AGREE TERMS AND CONDITIONS
		agentPage.clickCheckAgreeTerms();

		// CONFIRM BOOKING
		agentPage.ClickConfirmBooking();

		// ================= VERIFY DATA =========================
		// PRINT BOOKING STATUS
		agentPage.VerifyBookingStatus();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "300");
		
		// ACCOUNT DATA
		agentPage.VerifyFirstDataBooking(); //FIRST NAME, LAST NAME, EMAIL, PHONE, ADDRESS
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
