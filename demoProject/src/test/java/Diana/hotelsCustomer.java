package Diana;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTHotelBookingPage;
import phptravelsPageObjectRepository.PTHotelDetailsPage;
import phptravelsPageObjectRepository.PTHotelHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

public class hotelsCustomer extends Driver{
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.driver=initFirefoxDriver();
	}

	@Test
	public void travel() throws InterruptedException {
		System.out.println("----Welcome to Hotels----");
		PTHomePage home=new PTHomePage(driver);
		PTLoginPage login = new PTLoginPage(driver);
		PTCustomerPageObject tabHotel= new PTCustomerPageObject(driver);
		PTHotelHomePage hotelHomePage = new PTHotelHomePage(driver);
		PTHotelDetailsPage hotelDetails =  new PTHotelDetailsPage(driver);
		PTHotelBookingPage booking = new PTHotelBookingPage(driver);
		utilities utils = new utilities(driver);
		home.clickBtnAccount();
		home.clickCustomerLoginbtn();
		login.fillEmail("user@phptravels.com");
		login.fillPassword("demouser");
		login.clickGotItBtn();
		login.clickLogin();
		//---Click hotels tab
		tabHotel.clickHotelsBtn();
		// --- Click Firs hotel
		utils.ScrollDown(driver, "0", "400");
		hotelHomePage.clickhotelDiv();
		//Select Available rooms
		utils.ScrollDown(driver, "0", "600");
		// Select number of rooms
		hotelDetails.selectNumberRoomsBox();
		hotelDetails.selectNumOfRooms();
		// Click Book Now button
		hotelDetails.selectbookNowBtn();
		// Fill form information
		booking.selectDropDowntitle();
		booking.selectValueTitle();
		booking.writefirstNametb("Diana");
		booking.writelastNametb("Velasquez");
		utils.ScrollDown(driver, "0", "1100");
		booking.selectPayStripeRadioBtn();
		booking.selectCheckBoxTerms();
		booking.clickConfirmBookingBtn();

		
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
