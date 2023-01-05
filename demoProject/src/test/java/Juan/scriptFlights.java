package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
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
		
		
		homePage.clickBtnAccount();
		homePage.clickCustomerLoginbtn();
		
		//Write the Email and Password
		loginPage.fillEmail("user@phptravels.com");
		loginPage.fillPassword("demouser");
		loginPage.clickLogin();
		
		//Click on Flights Button
		selectFlight.clickFlightsbtn();
		
		//Select Country
		flightPage.writeFlyingFromOneWay("Mex");
		flightPage.selectItemFlyingFromOneWay();
		
		//Select Destination
		flightPage.writeFlyingDestinationOneWay("Fra");
		flightPage.selectItemFlyingDestinationOneWay();
		
        // Select Date
		flightPage.selectDepartureDateBox();
		flightPage.clickDayDeparture();
		flightPage.clickPassengersBox();
		
		//Click On Search Button
		flightPage.clickSearchFlights();
		
		//Click On Modify Search
		//flightPage.clickModifySearch();
		
	}

}
