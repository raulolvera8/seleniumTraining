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
	flights.writeFlyingFrom("Mag");
	flights.selectItemFlyingFrom();
	flights.writeToDestination("yaz");
	flights.selectItemToDestination();
	flights.selectDepartureDateBox();
	flights.clickDayDeparture();
	flights.clickPassengersBox();
	//flights.clickIconPlus();	
	flights.selectflightsSearchBtn();
	//Book now flight
	flights.clickBookNowBtn();
	// ------- FLIGHTS BOOKING WINDOW
	// ----Fill form  -----
	flights.clickDropdownNationality();
	flights.selectValueNationality();
	flights.selectDropDowntitle();
	flights.selectValueTitle();
	flights.writefirstNametb("Diana");
	flights.writelastNametb("Velasquez");
	// dropdown list
	flights.selectDropDownNationality_1();
	flights.selectValueNationality_1();
	flights.selectDropDownMonth();
	flights.selectDateOfBirth();
	flights.selectDropDownDay();
	flights.selectDay();
	flights.selectDropDownYear();
	flights.selectYear();
	//Passport ID
	// Passport Issuance Date
	utils.ScrollDown(Driver,"0","900");

	flights.writePassport("5555sdfdsd25");

	//jsScrollDown();
	flights.selectPassportMonth();
	flights.itemPassportMonth();
	//flights.selectPassportDay();
	//flights.itemPassportDay();
	/*flights.selectPassportYear();
	flights.itemPassportYear();
	// Passport Expiry Date
	flights.selectExpiryMonth();
	flights.itemExpiryMonth();
	flights.selectExpiryDay();
	flights.itemExpiryDay();
	flights.selectExpiryYear();
	flights.itemExpiryYear();
	ScrollDown(Driver);

	flights.selectPayLaterRadioBtn();
	flights.selectCheckBoxTerms();
	flights.clickBookingBtn();
*/
}

@AfterClass
public void teardown() {
	
}
}
