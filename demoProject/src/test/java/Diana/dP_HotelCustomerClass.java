package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTBookingFormPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTHotelDetailsPage;
import phptravelsPageObjectRepository.PTHotelHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;
import phptravelsPageObjectRepository.PTPayWithCardPage;
import phptravelsPageObjectRepository.PTPaymentWithStripePage;

public class dP_HotelCustomerClass extends Driver {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.driver = initFirefoxDriver();
	}
	//@Parameters ({"Digits_Credit_Card", "expireDate", "cvv", "name"})
	//@Test (dataProvider = "dataCreditCard", dataProviderClass =dataProvider_hotelCustomer.class )
	@Test (dataProvider = "ExcelData", dataProviderClass =ExcelDP.class )

	public void travel(String cardNumber, String expirationDate, String cvv, String name) throws InterruptedException {
		System.out.println("----Welcome to Hotels----");
		PTHomePage home = new PTHomePage(driver);
		PTLoginPage login = new PTLoginPage(driver);
		PTMenuPage tabHotel = new PTMenuPage(driver);
		PTHotelHomePage hotelHomePage = new PTHotelHomePage(driver);
		PTHotelDetailsPage hotelDetails = new PTHotelDetailsPage(driver);
		PTBookingFormPage form = new PTBookingFormPage(driver);
		PTBookingInvoicePage invoiceStatus = new PTBookingInvoicePage(driver);
		PTPaymentWithStripePage stripeWindow = new PTPaymentWithStripePage(driver);
		PTPayWithCardPage payCard = new PTPayWithCardPage(driver);
		utilities utils = new utilities(driver);

		// ----- PHPTRAVELS HOME PAGE WINDOW -----
		// CLICK ACCOUNT BUTTON
		home.clickAccountBtn();
		// SELECT ROLE
		home.clickCustomerLoginBtn();
		// ----- LOGIN WINDOW -----
		// TYPE CREDENTIALS
		// EMAIL
		login.fillEmailTb("user@phptravels.com");// user@phptravels.com
		// PASSWORD
		login.fillPasswordTb("demouser");//
		// ACCEPT COOKIES
		login.clickGotItBtn();
		// CLICK LOGIN BUTTON
		login.clickLoginCustomerBtn();
		// ----- CUSTOMER HOME PAGE WINDOW -----
		// CLICK HOTEL TAB
		tabHotel.clickHotelsBtn();
		// CLICK FIRST HOTEL
		// PRINT HOTEL NAME WILL SELECT
		String hotelName = hotelHomePage.readNameHotelLabel();
		System.out.println(hotelName);
		hotelHomePage.clickHotelName();
		// ----- HOTEL DETAILS WINDOW -------
		// (SCROLL DOWN)
		// CLICK NUMBER OF ROOMS BOX
		hotelDetails.selectNumberRoomsBox();
		// CLICK NUMBER OF ROOMS VALUE
		hotelDetails.selectNumOfRooms(2);
		// CLICK BOOK NOW BUTTON
		hotelDetails.selectbookNowBtn();
		// ----- HOTEL BOOKING WINDOW ----
		// INFORMATION TRAVELLER
		// CLICK TITLE BOX
		form.clickTitleDropDown();
		// CLICK TITLE VALUE
		form.clickValueTitleDropDown();
		// TYPE FIRST NAME
		form.writefirstNametb("Diana");
		// TYPE LAST NAME
		form.writelastNametb("Velasquez");
		// CLICK PAY WITH STRIPE RADIO BUTTON
		form.clickPayStripeRadioBtn();
		// CLICK TERMS AND CONDITIONS CHECK-BOX
		form.clickTermsConditionsCheckBox();
		// CLICK CONFIRMED RESERVATION HOTEL BUTTON
		form.clickBookingBtn();
		// PRINT STATUS
		invoiceStatus.validationStatusStripe();
		// SAVE TOTAL PRICE VARIABLE
		String totalPriceInProcess = invoiceStatus.readTotalPricePaidLabel();
		System.out.println("PAGO EN PROCESO DE AUTORIZAR: " + totalPriceInProcess);
		// SAVE HOTEL NAME VARIABLE
		String hotelNameInProcess = invoiceStatus.readHotelNameLabel();
		System.out.println("HOTEL EN PROCESO DE AUTORIZAR: " + hotelNameInProcess);
		// SAVE CHECK IN CHECK OUT DATES
		String checkOutInProcess = invoiceStatus.readCheckOutIn();
		System.out.println("FECHAS EN PROCESO DE AUTORIZAR: " + checkOutInProcess);
		// CLICK PROCEED TO PAY BUTTON
		invoiceStatus.clickProceedPayBtn();
		// ----- STRIPE WINDOW ----
		// VERIFY LABEL AMOUNT
		stripeWindow.VerifylabelAmount();
		// CLICK PAY NOW AMOUNT BUTTON
		stripeWindow.PayNowWithAmount();
		// ----- PAY WINDOW ----
		payCard.clickCancelPopUpBtn();
		payCard.CardNumberInput(cardNumber);//"4242424242424242"
		payCard.CardExpiryInput(expirationDate);//"1024;
		payCard.CardCVCInput(cvv);
		payCard.NameCardInput(name);//Diana Velasquez
		payCard.clickPagarButtonWithInfoCard();

		// SAVE TOTAL PRICE VARIABLE
		String totalPricePaid = invoiceStatus.readTotalPricePaidLabel();
		// SAVE HOTEL NAME VARIABLE
		String hotelNameLabel = invoiceStatus.readHotelNameLabel();
		// SAVE CHECK IN CHECK OUT DATES
		String checkOutInLabel = invoiceStatus.readCheckOutIn();
		if (totalPricePaid.contentEquals(totalPriceInProcess)) {
			System.out.println("PASSED:\n AUTORIZADO : " + totalPricePaid);
		} else {
			Assert.fail("FAILED: PAGO INCORRECTO");
		}
		if (hotelNameLabel.contentEquals(hotelNameInProcess)) {
			System.out.println("PASSED:\n HOTEL AUTORIZADO: " + hotelNameLabel);

		} else {
			Assert.fail("FAILED: NOMBRE HOTEL INCORRECTO");
		}
		if (checkOutInLabel.contentEquals(checkOutInProcess)) {
			System.out.println("PASSED:\n FECHAS AUTORIZADAS " + checkOutInLabel);

		} else {
			Assert.fail("FAILED: FECHAS INCORRECTAS");
		}
		// BOOKING INVOICE VALIDATION
		invoiceStatus.validationStatusPaid();
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
