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
	home.clickAccountBtn();
	// SELECT ROLE
	home.clickCustomerLoginBtn();
	// ----- LOGIN WINDOW ----- 
	// TYPE CREDENTIALS
	// EMAIL
	login.fillEmailTb("diana@itstark");//user@phptravels.com
	// PASSWORD
	login.fillPasswordTb("itstark");//demouser
	// ACCEPT COOKIES
	login.clickGotItBtn();
	// CLICK LOGIN BUTTON
	login.clickLoginCustomerBtn();
	// ----- CUSTOMER HOME PAGE WINDOW -----
	// CLICK FLIGHTS TAB
	tabFlights.clickFlightsbtn();
	// ----- FLIGHTS HOME PAGE WINDOW -----
	// TYPE FROM COUNTRY
	flights.writeFlyingFromOneWayTb("LHE");
	// SELECT COUNTRY
	flights.selectItemFlyingFromOneWayDropDown();
	// TYPE DESTINATION COUNTRY
	flights.writeFlyingDestinationOneWayTb("DXB");
	// SELECT COUNTRY
	flights.selectItemFlyingDestinationOneWayDropDown();
	// CLICK CALENDAR BOX
	flights.selectDepartureDateCalendarBox();
	// CLICK  DAY CALENDAR
	flights.clickDayDepartureCalendar();
	// CLICK SEARCHING BUTTON 
	flights.clickSearchFlightsBtn();
	// ----- SEARCH RESULTS WINDOW -----
	// CLICK FIRST FLIGHT RESULT  
	firstFlight.clickFirstFlightBtn();
	// -----  FLIGHT BOOKING  WINDOW -----
	// INFORMATION TRAVELLER
	// CLICK NATIONALITY BOX
	form.clickNationalityDropdown();
	// CLICK NATIONALITY VALUE 
	form.clickValueNationalityDropDown();
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","50");
	// CLICK TITLE BOX
	form.clickTitleDropDown();
	// CLICK TITLE VALUE 
	form.clickValueTitleDropDown();
	// TYPE FIRST NAME
	form.writefirstNametb("Diana");
	// TYPE LAST NAME
	form.writelastNametb("Velasquez");
	// INFORMATION TRAVELLER  
	// CLICK NATIONALITY BOX
	form.clickNationalityDropdown();
	// CLICK NATIONALITY VALUE 
	form.clickValueNationality_1DropDown();
	// CLICK MONTH BOX
	form.clickMonthDropDown();
	// CLICK MONTH VALUE 
	form.clickValueDateOfBirthDropDown();
	// CLICK DAY BOX
	form.clickDayDropDown();
	// CLICK DAY VALUE
	form.clickValueDayDropDown();
	// CLICK YEAR BOX
	form.clickYearDropDown();
	// CLICK YEAR VALUE
	form.clickValueYearDropDown();
	// INFORMATION TRAVELLER PASSPORT ISSUANCE
	// TYPE ID PASSPORT
	form.writePassportTb("5555sdfdsd25");
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","800");
	// CLICK MONTH BOX
	form.clickPassportMonthDropDown();
	// CLICK MONTH VALUE 
///<<<<<<< HEAD
	form.clickValuePassportMonthDropDown();
	// CLICK DAY BOX
	form.clickPassportDayDropDown();
//=======
	form.clickValuePassportMonthDropDown();
	// CLICK DAY BOX 
	form.clickPassportDayDropDown();
//>>>>>>> 1c96278a6387196460bcdb4de5cb11b884b81202
	// CLICK DAY VALUE 
	form.clickValuePassportDayDropDown();
	// CLICK YEAR BOX 
	form.clickPassportYearDropDown();
	// CLICK YEAR VALUE 
	form.clickValuePassportYearDropDown();
	// INFORMATION EXPIRY DATE PASSPORT 
	// CLICK MONTH BOX
	form.clickExpiryMonthDropDown();
	// CLICK MONTH VALUE 
	form.clickValueMonthDropDown();
	// CLICK DAY BOX 
	form.clickExpiryDayDropDown();
	// CLICK DAY VALUE 
	form.clickValueExpiryDayDropDown();
	// CLICK YEAR BOX 
	form.clickExpiryYearDropDown();
	// CLICK YEAR VALUE 
	form.clickValueExpiryYearDropDown();
	// CLICK PAY LATER RADIO BUTTON 
	form.clickPayLaterRadioBtn();
	// (SCROLL DOWN)
	utils.ScrollDown(Driver,"0","1000");
	// CLICK TERMS AND CONDITIONS CHECK-BOX
	form.clickTermsConditionsCheckBox();
	// CLICK CONFIRMED FLIGHT BUTTON
	form.clickBookingBtn();
	// PRINT VALIDATION STATUS
	validationInvoice.validationStatusLater();
}
@AfterClass
public void teardown() {
	
}
}
