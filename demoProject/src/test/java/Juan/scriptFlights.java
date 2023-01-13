package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
//import phptravelsPageObjectRepository.PTCustomerPageObject;
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
		homePage.clickAccountBtn();
		//SELECT AND CLICK THE ROLE
		homePage.clickCustomerLoginBtn();
		
		//WRITE THE EMAIL AND PASSWORD
		//EMAIL
		loginPage.fillEmailTb("juan.ramirez@itstarksolutions.com");
		//PASSWORD
		loginPage.fillPasswordTb("demouser");
		//ACCEPT COOKIES
		loginPage.clickGotItBtn();
		//CLICK LOGIN BUTTON
		loginPage.clickLoginCustomerBtn();
		
		//Click on Flights Button
		selectFlight.clickFlightsbtn();
		
		//Select Country
		flightPage.writeFlyingFromOneWayTb("LAHO");
		// SELECT COUNTRY
		flightPage.selectItemFlyingFromOneWayDropDown();
		
		//Select Destination
		flightPage.writeFlyingDestinationOneWayTb("DUBA");
		// SELECT COUNTRY
		flightPage.selectItemFlyingDestinationOneWayDropDown();
		// CLICK CALENDAR BOX
		flightPage.selectDepartureDateCalendarBox();
		// CLICK  DAY CALENDAR
		flightPage.clickDayDepartureCalendar();
		// CLICK  PASSENGER BOX
		flightPage.clickPassengersBox();
		//Click On Search Button
		flightPage.clickSearchFlightsBtn();
		//---FILL THE INFO
		//flightResultPage.clickDirectSearch();	
		//ClICK BOOK NOW BUTTON
		flightResultPage.clickDirectSearchRadioBtn();
		flightResultPage.clickSubmitBookNow();
		//WRITE FIRST NAME
		flightBookingPage.writefirstNametb("Juan");
		//WRITE LAST NAME
		flightBookingPage.writelastNametb("Ramirez");
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","200");
		// CLICK NATIONALITY BOX
		flightBookingPage.clickNationalityDropdown();
		// CLICK NATIONALITY VALUE
		flightBookingPage.clickValueNationality_1DropDown();
		// CLICK MONTH BOX
		flightBookingPage.clickMonthDropDown();
		// CLICK MONTH VALUE 
		flightBookingPage.clickValueDateOfBirthDropDown(5);
		// CLICK DAY BOX
		flightBookingPage.clickDayDropDown();
		// CLICK DAY VALUE
		flightBookingPage.clickValueDayDropDown(10);
		// CLICK YEAR BOX
		flightBookingPage.clickYearDropDown();
		// CLICK YEAR VALUE
		flightBookingPage.clickValueYearDropDown(5);
		//WRITE ID PASSPORT
		flightBookingPage.writePassportTb("0909090JR887");
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","700");
		// CLICK MONTH BOX
		flightBookingPage.clickPassportMonthDropDown();
		// CLICK MONTH VALUE 
		flightBookingPage.clickValuePassportMonthDropDown(5);
		// CLICK DAY BOX 
		flightBookingPage.clickPassportDayDropDown();
		// CLICK DAY VALUE 
		flightBookingPage.clickValuePassportDayDropDown(5);
		// CLICK YEAR BOX 
		flightBookingPage.clickPassportYearDropDown();
		// CLICK YEAR VALUE 
		flightBookingPage.clickValuePassportYearDropDown(5);
		// CLICK MONTH BOX
		flightBookingPage.clickExpiryMonthDropDown();
		// CLICK MONTH VALUE 
		flightBookingPage.clickValueMonthDropDown(5);
		// CLICK DAY BOX 
		flightBookingPage.clickExpiryDayDropDown();
		// CLICK DAY VALUE 
		flightBookingPage.clickValueExpiryDayDropDown(5);
		// CLICK YEAR BOX 
		flightBookingPage.clickExpiryYearDropDown();
		// CLICK YEAR VALUE 
		flightBookingPage.clickValueExpiryYearDropDown(5);
		// (SCROLL DOWN)
		utils.ScrollDown(driver,"0","600");
		// CLICK PAY LATER RADIO BUTTON 
		flightBookingPage.clickPayLaterRadioBtn();
		//(SCROLL DOWN)
		utils.ScrollDown(driver,"0","1000");
		// CLICK TERMS AND CONDITIONS CHECK-BOX
		flightBookingPage.clickTermsConditionsCheckBox();
		// CLICK CONFIRMED FLIGHT BUTTON
		flightBookingPage.clickBookingBtn();
		// PRINT VALIDATION STATUS
		flightInvoicePage.validationStatusLater();
	
		
	}
	
	@AfterClass
	public void teardown() {

}
}
