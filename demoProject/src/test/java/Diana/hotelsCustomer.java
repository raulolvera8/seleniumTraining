package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTHotelDetailsPage;
import phptravelsPageObjectRepository.PTHotelHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTPayWithCardPage;
import phptravelsPageObjectRepository.PTPaymentWithStripePage;

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
		PTBookingFormPage form = new PTBookingFormPage(driver);
		PTBookingInvoicePage invoiceStatus = new PTBookingInvoicePage(driver);
		PTPaymentWithStripePage stripeWindow = new PTPaymentWithStripePage(driver);
		PTPayWithCardPage payCard = new PTPayWithCardPage(driver);
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
		form.selectDropDowntitle();
		form.selectValueTitle();
		form.writefirstNametb("Diana");
		form.writelastNametb("Velasquez");
		utils.ScrollDown(driver, "0", "1100");
		form.selectPayStripeRadioBtn();
		form.selectCheckBoxTerms();
		form.clickBookingBtn();
		// Print Validation status Booking invoice window
		
		invoiceStatus.validationStatusStripe();
		invoiceStatus.clickProceedPayBtn();
		stripeWindow.VerifylabelAmount();
		stripeWindow.PayNowWithAmount();
		payCard.clickCancelPopUpBtn();
		payCard.CardNumberInput("4242424242424242");
		payCard.CardExpiryInput("1024");
		payCard.CardCVCInput("123");
		payCard.NameCardInput("Diana Velasquez");
		payCard.clickPagarButtonWithInfoCard();
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		invoiceStatus.validationStatusPaid();
	}
	@AfterClass
	public void teardown() {
		
	}
}
