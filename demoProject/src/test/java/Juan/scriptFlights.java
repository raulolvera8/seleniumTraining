package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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
		//PTCustomerPageObject flightModify = new PTCustomerPageObject(driver);
		PTFlightSearchResultsPage flightResultPage= new PTFlightSearchResultsPage(driver);
		PTBookingFormPage flightBookingPage  = new PTBookingFormPage(driver);
		PTBookingInvoicePage flightInvoicePage = new PTBookingInvoicePage(driver);
		utilities utils = new utilities(driver);
		utils.ScrollDown( driver, "0", "200");
		
		//CLICK ACCOUNT BUTTON
		homePage.clickBtnAccount();
		//SELECT AND CLICK THE ROLE
		homePage.clickCustomerLoginbtn();
		
		//WRITE THE EMAIL AND PASSWORD
		//EMAIL
		loginPage.fillEmail("user@phptravels.com");
		//PASSWORD
		loginPage.fillPassword("demouser");
		//ACCEPT COOKIES
		loginPage.clickGotItBtn();
		//CLICK LOGIN BUTTON
		loginPage.clickLogin();
		
		//Click on Flights Button
		selectFlight.clickFlightsbtn();
		
		//Select Country
		flightPage.writeFlyingFromOneWay("LAHO");
		// SELECT COUNTRY
		flightPage.selectItemFlyingFromOneWay();
		
		//Select Destination
		flightPage.writeFlyingDestinationOneWay("DUBA");
		// SELECT COUNTRY
		flightPage.selectItemFlyingDestinationOneWay();
		// CLICK CALENDAR BOX
		flightPage.selectDepartureDateBox();
		// CLICK  DAY CALENDAR
		flightPage.clickDayDeparture();
		// CLICK  PASSENGER BOX
		flightPage.clickPassengersBox();
		//Click On Search Button
		flightPage.clickSearchFlights();	
		//---FILL THE INFO
		//flightResultPage.clickDirectSearch();	
		//ClICK BOOK NOW BUTTON
		flightResultPage.clickSubmitBookNow();
		//WRITE FIRST NAME
		flightBookingPage.writefirstNametb("Juan");
		//WRITE LAST NAME
		flightBookingPage.writelastNametb("Ramirez");
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","200");
		// CLICK NATIONALITY BOX
		flightBookingPage.selectDropDownNationality_1();
		// CLICK NATIONALITY VALUE
		flightBookingPage.selectValueNationality_1();
		// CLICK MONTH BOX
		flightBookingPage.selectDropDownMonth();
		// CLICK MONTH VALUE 
		flightBookingPage.selectDateOfBirth();
		// CLICK DAY BOX
		flightBookingPage.selectDropDownDay();
		// CLICK DAY VALUE
		flightBookingPage.selectDay();
		// CLICK YEAR BOX
		flightBookingPage.selectDropDownYear();
		// CLICK YEAR VALUE
		flightBookingPage.selectYear();
		//WRITE ID PASSPORT
		flightBookingPage.writePassport("0909090JR887");
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","700");
		// CLICK MONTH BOX
		flightBookingPage.selectPassportMonth();
		// CLICK MONTH VALUE 
		flightBookingPage.itemPassportMonth();
		// CLICK DAY BOX 
		flightBookingPage.selectPassportDay();
		// CLICK DAY VALUE 
		flightBookingPage.itemPassportDay();
		// CLICK YEAR BOX 
		flightBookingPage.selectPassportYear();
		// CLICK YEAR VALUE 
		flightBookingPage.itemPassportYear();
		// CLICK MONTH BOX
		flightBookingPage.selectExpiryMonth();
		// CLICK MONTH VALUE 
		flightBookingPage.itemExpiryMonth();
		// CLICK DAY BOX 
		flightBookingPage.selectExpiryDay();
		// CLICK DAY VALUE 
		flightBookingPage.itemExpiryDay();
		// CLICK YEAR BOX 
		flightBookingPage.selectExpiryYear();
		// CLICK YEAR VALUE 
		flightBookingPage.itemExpiryYear();
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","600");
		// CLICK PAY LATER RADIO BUTTON 
		flightBookingPage.selectPayLaterRadioBtn();
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","1000");
		// CLICK TERMS AND CONDITIONS CHECK-BOX
		flightBookingPage.selectCheckBoxTerms();
		// CLICK CONFIRMED FLIGHT BUTTON
		flightBookingPage.clickBookingBtn();
		// PRINT VALIDATION STATUS
		flightInvoicePage.validationStatusLater();
	
		
	}
	
	@AfterClass
	public void teardown() {

}
}
