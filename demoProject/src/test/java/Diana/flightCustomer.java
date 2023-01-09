package Diana;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTFlightSearchResultsPage;
import phptravelsPageObjectRepository.PTFlightsPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import library.utilities;
public class flightCustomer extends Driver {
WebDriver Driver;
@BeforeClass 
public void setup() {
	System.out.println("set up driver travels");
		this.Driver=initFirefoxDriver();
	
 }
@Test
public void travels() throws InterruptedException {
	PTHomePage home=new PTHomePage(Driver);
	PTLoginPage login = new PTLoginPage(Driver);
	PTFlightsPage flights = new PTFlightsPage(Driver);
	PTMenuPage tabFlights= new PTMenuPage(Driver);
	PTFlightSearchResultsPage firstFlight = new PTFlightSearchResultsPage(Driver);
	PTBookingFormPage form = new PTBookingFormPage(Driver);
	PTBookingInvoicePage validationInvoice = new PTBookingInvoicePage(Driver);
	utilities utils= new utilities (Driver);
	
	// ----- PHPTRAVELS HOME PAGE WINDOW -----
	// CLICK ACCOUNT BUTTON
	home.clickBtnAccount();
	// SELECT ROLE
	home.clickCustomerLoginbtn();
	// ----- LOGIN WINDOW ----- 
	// TYPE CREDENTIALS
	// EMAIL
	login.fillEmail("user@phptravels.com");
	// PASSWORD
	login.fillPassword("demouser");
	// ACCEPT COOKIES
	login.clickGotItBtn();
	// CLICK LOGIN BUTTON
	login.clickLogin();
	// ----- CUSTOMER HOME PAGE WINDOW -----
	// CLICK FLIGHTS TAB
	tabFlights.clickFlightsbtn();
	// ----- FLIGHTS HOME PAGE WINDOW -----
	// TYPE FROM COUNTRY
	flights.writeFlyingFromOneWay("LHE");
	// SELECT COUNTRY
	flights.selectItemFlyingFromOneWay();
	// TYPE DESTINATION COUNTRY
	flights.writeFlyingDestinationOneWay("DXB");
	// SELECT COUNTRY
	flights.selectItemFlyingDestinationOneWay();
	// CLICK CALENDAR BOX
	flights.selectDepartureDateBox();
	// CLICK  DAY CALENDAR
	flights.clickDayDeparture();
	// CLICK SEARCHING BUTTON 
	flights.clickSearchFlights();
	// ----- SEARCH RESULTS WINDOW -----
	// CLICK FIRST FLIGHT RESULT  
	firstFlight.clickFirstFlight();
	// -----  FLIGHT BOOKING  WINDOW -----
	// INFORMATION TRAVELLER
	// CLICK NATIONALITY BOX
	form.clickDropdownNationality();
	// CLICK NATIONALITY VALUE 
	form.selectValueNationality();
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","50");
	// CLICK TITLE BOX
	form.selectDropDowntitle();
	// CLICK TITLE VALUE 
	form.selectValueTitle();
	// TYPE FIRST NAME
	form.writefirstNametb("Diana");
	// TYPE LAST NAME
	form.writelastNametb("Velasquez");
	// INFORMATION TRAVELLER  
	// CLICK NATIONALITY BOX
	form.selectDropDownNationality_1();
	// CLICK NATIONALITY VALUE 
	form.selectValueNationality_1();
	// CLICK MONTH BOX
	form.selectDropDownMonth();
	// CLICK MONTH VALUE 
	form.selectDateOfBirth();
	// CLICK DAY BOX
	form.selectDropDownDay();
	// CLICK DAY VALUE
	form.selectDay();
	// CLICK YEAR BOX
	form.selectDropDownYear();
	// CLICK YEAR VALUE
	form.selectYear();
	// INFORMATION TRAVELLER PASSPORT ISSUANCE
	// TYPE ID PASSPORT
	form.writePassport("5555sdfdsd25");
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","800");
	// CLICK MONTH BOX
	form.selectPassportMonth();
	// CLICK MONTH VALUE 
	form.itemPassportMonth();
	// CLICK DAY BOX 
	form.selectPassportDay();
	// CLICK DAY VALUE 
	form.itemPassportDay();
	// CLICK YEAR BOX 
	form.selectPassportYear();
	// CLICK YEAR VALUE 
	form.itemPassportYear();
	// INFORMATION EXPIRY DATE PASSPORT 
	// CLICK MONTH BOX
	form.selectExpiryMonth();
	// CLICK MONTH VALUE 
	form.itemExpiryMonth();
	// CLICK DAY BOX 
	form.selectExpiryDay();
	// CLICK DAY VALUE 
	form.itemExpiryDay();
	// CLICK YEAR BOX 
	form.selectExpiryYear();
	// CLICK YEAR VALUE 
	form.itemExpiryYear();
	// CLICK PAY LATER RADIO BUTTON 
	form.selectPayLaterRadioBtn();
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","1000");
	// CLICK TERMS AND CONDITIONS CHECK-BOX
	form.selectCheckBoxTerms();
	// CLICK CONFIRMED FLIGHT BUTTON
	form.clickBookingBtn();
	// PRINT VALIDATION STATUS
	validationInvoice.validationStatusLater();
}
@AfterClass
public void teardown() {
	
}
}
