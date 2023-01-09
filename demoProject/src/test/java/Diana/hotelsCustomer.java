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
import phptravelsPageObjectRepository.PTMenuPage;
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
		PTMenuPage tabHotel= new PTMenuPage(driver);
		PTHotelHomePage hotelHomePage = new PTHotelHomePage(driver);
		PTHotelDetailsPage hotelDetails =  new PTHotelDetailsPage(driver);
		PTBookingFormPage form = new PTBookingFormPage(driver);
		PTBookingInvoicePage invoiceStatus = new PTBookingInvoicePage(driver);
		PTPaymentWithStripePage stripeWindow = new PTPaymentWithStripePage(driver);
		PTPayWithCardPage payCard = new PTPayWithCardPage(driver);
		utilities utils = new utilities(driver);

		// ----- PHPTRAVELS HOME PAGE WINDOW -----
		// CLICK ACCOUNT BUTTON
		home.clickBtnAccount();
		// SELECT ROLE
		home.clickCustomerLoginbtn();
		// ----- LOGIN WINDOW ----- 
		// TYPE CREDENTIALS
		// EMAIL
		login.fillEmail("user@phptravels.com");
		// PASSWORD
		login.fillPassword("demouser");
		// ACCEPT COOKIES
		login.clickGotItBtn();
		// CLICK LOGIN BUTTON
		login.clickLogin();
		// ----- CUSTOMER HOME PAGE WINDOW -----
		// CLICK HOTEL TAB
		tabHotel.clickHotelsBtn();
		// (SCROLL DOWN)
		utils.ScrollDown(driver, "0", "400");
		// CLICK FIRST HOTEL
		hotelHomePage.clickhotelDiv();		
		// ----- HOTEL DETAILS  WINDOW -------
		// (SCROLL DOWN)
		utils.ScrollDown(driver, "0", "600");
		// CLICK NUMBER OF ROOMS BOX
		hotelDetails.selectNumberRoomsBox();
		// CLICK NUMBER OF ROOMS VALUE
		hotelDetails.selectNumOfRooms();
		// CLICK BOOK NOW BUTTON
		hotelDetails.selectbookNowBtn();
		// ----- HOTEL BOOKING WINDOW ----
		// INFORMATION TRAVELLER
		// (SCROLL DOWN)
		utils.ScrollDown(driver, "0", "300");
		// CLICK TITLE BOX
		form.selectDropDowntitle();
		// CLICK TITLE VALUE 
		form.selectValueTitle();
		// TYPE FIRST NAME
		form.writefirstNametb("Diana");
		// TYPE LAST NAME
		form.writelastNametb("Velasquez");
		// (SCROLL DOWN)
		utils.ScrollDown(driver, "0", "1200");
		// CLICK PAY WITH STRIPE  RADIO BUTTON 
		form.selectPayStripeRadioBtn();
		// CLICK TERMS AND CONDITIONS CHECK-BOX
		form.selectCheckBoxTerms();
		// CLICK CONFIRMED RESERVATION HOTEL BUTTON
		form.clickBookingBtn();
		// PRINT  STATUS	
		invoiceStatus.validationStatusStripe();
		// CLICK PROCEED TO PAY BUTTON
		invoiceStatus.clickProceedPayBtn();
		// ----- STRIPE  WINDOW ----
		// VERIFY LABEL AMOUNT
		stripeWindow.VerifylabelAmount();
		// CLICK PAY NOW AMOUNT BUTTON
		stripeWindow.PayNowWithAmount();
		// ----- PA WINDOW ----
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
