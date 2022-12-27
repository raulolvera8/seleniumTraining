package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTAgentPage;
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
	public void ShoppingHome() {

		// ===================== DECLARAR LAS PAGINAS DE OBJETOS =====================
		// SIGN IN PAGE
		PTHomePage signInPage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTAgentPage agentPage = new PTAgentPage(driver);

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
		agentPage.flyingFromInput("Canadian Rockies Intl");

		// CLICK FIRST OPTION
		agentPage.flyingFromAutocomplete();

		// ENTER CITY TO DESTINATION
		agentPage.toDestinationInput("John F Kennedy Intl");

		// CLICK SECOND OPTION
		agentPage.ToDestinationAutocomplete();

		// CLICK DATE FLY INPUT FOR TO SEE OPTIONS
		agentPage.DateInput();

		// SELECT 6 DAY FROM CALENDAR PICKER
		agentPage.SelectDateFromCalendar();

		// CLICK TO SEE OPTIONS FROM PASSANGERS
		agentPage.clickTravelersInput();

		// CLICK QUANTITY ADULT
		//agentPage.clickAdultsOptionPlus();

		// PRINT NUMBER OF PASSENGERS
		agentPage.PrintNumberPassangers();

		// SEARCH FLIGHTS BUTTON
		agentPage.clickSearchFlightButton();

		// ========== TOTAL FLIGHTS WINDOW ==========

		// SELECT FIRST TRAVEL OPTION BOOK NOW
		agentPage.clickFirstFlight();

		// =========== FLIGHTS BOOKING WINDOW ==========
		
		// PRINT PERSONAL INFORMATION FROM ACCOUNT
		System.out.println("Your Personal Information");
		agentPage.PrintFirstName();
		agentPage.PrintLastNameLabel();
		agentPage.PrintEmailLabel();
		
		// ENTER TRAVELLERS INFORMATION

		// FIRST NAME
		agentPage.firstnameTraveler1Input("Barry");
		
		// LAST NAME
		agentPage.lastnameTraveler1Input("Allen");

		// NATIONALITY
		agentPage.nationalityTraveller1Select();
		// SEARCH OPTION
		//agentPage.SelectnationalityTraveller1();
		
		// DATE OF BIRTH
		// MONTH
		//agentPage.SelectDateOfBirth();
		
		// DAY
		//agentPage.SelectDayOfBirth();
		
		// YEAR
		//agentPage.SelectYearOfBirth();
		
		// ================ PASSPORT INFORMATION ==================
		// PASSPORT ID
		//agentPage.EnterPassportID("C03005988");
		
		// PASSPORT ISSUANCE MONTH
		//agentPage.SelectMonthPassport();
		
		// PASSPORT ISSUANCE DAY
		//agentPage.SelectDayPassport();
		
		// PASSPORT ISSUANCE YEAR
		//agentPage.SelectYearPassport();
		
		// PASSPORT EXPIRE DATE MONTH
		//agentPage.SelectMonthExpirePassport();
		
		// PASSPORT EXPIRE DAY
		//agentPage.SelectDayExpirePassport();
		
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}

}
