package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

public class scriptFlights extends Driver {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	@Test
	public void CustomerPage() {


		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTCustomerPageObject flightPage = new PTCustomerPageObject(driver);
		homePage.clickBtnAccount();
		homePage.clickCustomerLoginbtn();
		loginPage.fillEmail("user@phptravels.com");
		loginPage.fillPassword("demouser");
		loginPage.clickLogin();
		flightPage.clickFlightsbtn();
		flightPage.writeFrom("monterrey");
		flightPage.writeDestination("italy");
		flightPage.clickDate();
		flightPage.clickSearch();
		
	}

}
