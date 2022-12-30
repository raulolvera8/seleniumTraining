package Diana;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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
	home.clickBtnAccount();
	home.clickCustomerLoginbtn();
	login.fillEmail("user@phptravels.com");
	login.fillPassword("demouser");
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
	flights.clickDropdownNationality();
	flights.selectValueNationality();
	flights.selectValueTitle();
	flights.writefirstNametb("Diana");
	flights.writelastNametb("Velasquez");
	flights.selectValueNationality_1();
	flights.selectDateOfBirth();
	flights.selectDay();
	flights.selectYear();
}

@AfterClass
public void teardown() {
	
}
}
