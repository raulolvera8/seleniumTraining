package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTFlightSearchResultsPage;
import phptravelsPageObjectRepository.PTFlightsPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;

public class scriptFlights extends Driver {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	@Test
	public void CustomerPage() {

        // Enter on Home Page
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTMenuPage selectFlight = new PTMenuPage(driver);
		PTFlightsPage flightPage = new PTFlightsPage(driver);
		PTCustomerPageObject flightModify = new PTCustomerPageObject(driver);
		PTFlightSearchResultsPage flightResultPage= new PTFlightSearchResultsPage(driver);
		PTBookingFormPage flightBookingPage  = new PTBookingFormPage(driver);
		PTBookingInvoicePage flightInvoicePage = new PTBookingInvoicePage(driver);
		utilities utils = new utilities(driver);
		utils.ScrollDown( driver, "0", "200");
		
		
		homePage.clickBtnAccount();
		homePage.clickCustomerLoginbtn();
		
		//Write the Email and Password
		loginPage.fillEmail("user@phptravels.com");
		loginPage.fillPassword("demouser");
		loginPage.clickLogin();
		
		//Click on Flights Button
		selectFlight.clickFlightsbtn();
		
		//Select Country
		flightPage.writeFlyingFromOneWay("LAHO");
		flightPage.selectItemFlyingFromOneWay();
		
		//Select Destination
		flightPage.writeFlyingDestinationOneWay("DUBA");
		flightPage.selectItemFlyingDestinationOneWay();
		
        // Select Date
		flightPage.selectDepartureDateBox();
		flightPage.clickDayDeparture();
		flightPage.clickPassengersBox();
		
		//Click On Search Button
		flightPage.clickSearchFlights();
		
		/*
		 * //Click On Modify Search flightModify.clickModifySearch();
		 * 
		 * flightModify.printValidationStops();
		 */
		
		
		/*
		 * flightModify.clickAirlines();
		 * 
		 * flightModify.clickFirstOption();
		 */
		//---FILL THE INFO
		//flightResultPage.clickDirectSearch();
		
		
		flightResultPage.clickSubmitBookNow();
		flightBookingPage.writefirstNametb("Juan");
		flightBookingPage.writelastNametb("Ramirez");
		
		utils.ScrollDown(driver,"0","200");
		flightBookingPage.selectDropDownNationality_1();
		flightBookingPage.selectValueNationality_1();

		flightBookingPage.selectDropDownMonth();
		flightBookingPage.selectDateOfBirth();
		flightBookingPage.selectDropDownDay();
		flightBookingPage.selectDay();
		flightBookingPage.selectDropDownYear();
		flightBookingPage.selectYear();
		flightBookingPage.writePassport("0909090JR887");
		
		utils.ScrollDown(driver,"0","700");

		flightBookingPage.selectPassportMonth();
		flightBookingPage.itemPassportMonth();
		flightBookingPage.selectPassportDay();
		flightBookingPage.itemPassportDay();
		flightBookingPage.selectPassportYear();
		flightBookingPage.itemPassportYear();
		flightBookingPage.selectExpiryMonth();
		flightBookingPage.itemExpiryMonth();
		flightBookingPage.selectExpiryDay();
		flightBookingPage.itemExpiryDay();
		flightBookingPage.selectExpiryYear();
		flightBookingPage.itemExpiryYear();
		utils.ScrollDown(driver,"0","600");

		flightBookingPage.selectPayLaterRadioBtn();
		utils.ScrollDown(driver,"0","1000");

		flightBookingPage.selectCheckBoxTerms();
		flightBookingPage.clickBookingBtn();
		flightInvoicePage.validationStatusLater();
	
		
	}

}
