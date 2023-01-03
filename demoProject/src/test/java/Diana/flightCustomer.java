package Diana;
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
	utilities utils= new utilities (Driver);
	//Login
	/*home.clickLanguageDropDownlist();
	home.clickLanguage();*/
	home.clickBtnAccount();
	home.clickCustomerLoginbtn();
	login.fillEmail("user@phptravels.com");
	login.fillPassword("demouser");
	flights.clickGotItBtn();
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
	flights.clickDropdownNationality();
	flights.selectValueNationality();
	// Title
	flights.selectDropDowntitle();
	flights.selectValueTitle();
	// Frist Name and Last Name 
	flights.writefirstNametb("Diana");
	flights.writelastNametb("Velasquez");
	// dropdown list
	// Nationality
	flights.selectDropDownNationality_1();
	flights.selectValueNationality_1();
	// Date of Birth
	flights.selectDropDownMonth();
	flights.selectDateOfBirth();
	// Day
	flights.selectDropDownDay();
	flights.selectDay();
	// Year
	flights.selectDropDownYear();
	flights.selectYear();
	//Passport ID
	// Passport Issuance Date
	flights.writePassport("5555sdfdsd25");
	// Scroll Down
	utils.ScrollDown(Driver,"0","700");
	flights.selectPassportMonth();
	flights.itemPassportMonth();
	flights.selectPassportDay();
	flights.itemPassportDay();
	flights.selectPassportYear();
	flights.itemPassportYear();
	// Passport Expiry Date
	flights.selectExpiryMonth();
	flights.itemExpiryMonth();
	flights.selectExpiryDay();
	flights.itemExpiryDay();
	flights.selectExpiryYear();
	flights.itemExpiryYear();
	flights.selectPayLaterRadioBtn();
	//ScrollDwon
	utils.ScrollDown(Driver,"0","1000");
	// Accept Terms and conditions
	flights.selectCheckBoxTerms();
	// Book now button
	flights.clickBookingBtn();
	// Print Validation status Booking invoice window
	flights.validationStatus();
}
@AfterClass
public void teardown() {
	
}
}
