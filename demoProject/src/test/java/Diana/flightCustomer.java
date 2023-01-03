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
	/// SCROLL DOWN JAVASCRIPT PDTE//
	//flights.clickGotItBtn();
	
	flights.clickDropdownNationality();
	flights.selectValueNationality();
	flights.selectDropDowntitle();
	flights.selectValueTitle();
	flights.writefirstNametb("Diana");
	flights.writelastNametb("Velasquez");
	jsScrollDown();

	// dropdown list
	flights.selectDropDownNationality_1();
	flights.selectValueNationality_1();
	flights.selectDropDownMonth();
	flights.selectDateOfBirth();
	flights.selectDropDownDay();
	flights.selectDay();
	flights.selectDropDownYear();
	flights.selectYear();
	jsScrollDown();
	flights.selectPayLaterRadioBtn();
	flights.selectCheckBoxTerms();
	flights.clickBookingBtn();

}

@AfterClass
public void teardown() {
	
}
}
