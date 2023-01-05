package Diana;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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
	PTCustomerPageObject flights = new PTCustomerPageObject(Driver);
	PTBookingFormPage form = new PTBookingFormPage(Driver);
	PTBookingInvoicePage validationInvoice = new PTBookingInvoicePage(Driver);
	utilities utils= new utilities (Driver);
	//Login
	/*home.clickLanguageDropDownlist();
	home.clickLanguage();*/
	home.clickBtnAccount();
	home.clickCustomerLoginbtn();
	login.fillEmail("user@phptravels.com");
	login.fillPassword("demouser");
	login.clickGotItBtn();
	login.clickLogin();
	// Click Flights Tab
	flights.clickFlightsTab();
	// Filling trip form to search
	flights.writeFlyingFrom("LHE");
	flights.selectItemFlyingFrom();
	flights.writeToDestination("DXB");
	flights.selectItemToDestination();
	flights.selectDepartureDateBox();
	flights.clickDayDeparture();
	flights.clickPassengersBox();
	// Searching flight
	flights.selectflightsSearchBtn();
	// --List of flights window
	//Book now flight 
	flights.clickBookNowBtn();
	// ------- INFORMATION FLIGHTS BOOKING WINDOW
	// ----FILLING INFORMATION FORM   -----
	// Nationality
	form.clickDropdownNationality();
	form.selectValueNationality();
	// Title
	form.selectDropDowntitle();
	form.selectValueTitle();
	// Frist Name and Last Name 
	form.writefirstNametb("Diana");
	form.writelastNametb("Velasquez");
	// dropdown list
	// Nationality
	form.selectDropDownNationality_1();
	form.selectValueNationality_1();
	// Date of Birth
	form.selectDropDownMonth();
	form.selectDateOfBirth();
	// Day
	form.selectDropDownDay();
	form.selectDay();
	// Year
	form.selectDropDownYear();
	form.selectYear();
	//Passport ID
	// Passport Issuance Date
	form.writePassport("5555sdfdsd25");
	// Scroll Down
	utils.ScrollDown(Driver,"0","700");
	form.selectPassportMonth();
	form.itemPassportMonth();
	form.selectPassportDay();
	form.itemPassportDay();
	form.selectPassportYear();
	form.itemPassportYear();
	// Passport Expiry Date
	form.selectExpiryMonth();
	form.itemExpiryMonth();
	form.selectExpiryDay();
	form.itemExpiryDay();
	form.selectExpiryYear();
	form.itemExpiryYear();
	form.selectPayLaterRadioBtn();
	//ScrollDwon
	utils.ScrollDown(Driver,"0","1000");
	// Accept Terms and conditions
	form.selectCheckBoxTerms();
	// Book now button
	form.clickBookingBtn();
	// Print Validation status Booking invoice window
	validationInvoice.validationStatusLater();
}
@AfterClass
public void teardown() {
	
}
}
