package Juan;

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
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;
import phptravelsPageObjectRepository.PTPayWithCardPage;
import phptravelsPageObjectRepository.PTPaymentWithStripePage;
import phptravelsPageObjectRepository.PTTourBookingPage;
import phptravelsPageObjectRepository.PTTourDetails;
import phptravelsPageObjectRepository.PTToursInDubai;
import phptravelsPageObjectRepository.PTToursPage;

public class scriptTour extends Driver {
	WebDriver driver;

	@BeforeClass 
	public void setup() {
			this.driver=initFirefoxDriver();
	 }
	@Test
	public void CustomerPage() {


		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTMenuPage tourMenuPage = new PTMenuPage(driver);
		PTToursPage tourPage = new PTToursPage(driver);
		PTToursInDubai tourDubai = new PTToursInDubai(driver);
		PTTourDetails tourDetails = new PTTourDetails(driver);
		PTTourBookingPage bookingPage = new PTTourBookingPage(driver);
		PTBookingInvoicePage bookingInvoicePage = new PTBookingInvoicePage(driver);
		PTPaymentWithStripePage paymentStripePage= new PTPaymentWithStripePage(driver);
		PTPayWithCardPage payWithCardPage = new PTPayWithCardPage(driver);
		utilities utils = new utilities(driver);
		utils.ScrollDown( driver, "0", "200");
		
		
		homePage.clickAccountBtn();
		homePage.clickCustomerLoginBtn();
		
		//LOGIN 
		loginPage.fillEmailTb("user@phptravels.com");
		loginPage.fillPasswordTb("demouser");
		loginPage.clickGotItBtn();
		loginPage.clickLoginCustomerBtn();
		
		//ENTER TOURS
		tourMenuPage.clickToursBtn();
		tourPage.clickDestination();
		tourPage.writeCountry("dubai");
		tourPage.selectItemFromTour();
		tourPage.clickSubmit();
		
		
		tourDubai.clickDetails();
		
		//SELECT DATE
		tourDetails.clickDateTour();
		tourDetails.clickDateSelect();
		tourDetails.clickAdults();
		tourDetails.clickAdultsNumber();
		tourDetails.clickChilds();
		tourDetails.clickChildsNumber();
		tourDetails.clickInfants();
		tourDetails.clickInfantsNumber();
		tourDetails.clickBookNowDate();
		
		//TRAVELLERS INFO
		//TRAVELLER 1
		bookingPage.clickTraveller1();
		bookingPage.writeFirstName1("juan");
		bookingPage.writeLastName1("limon");
		//TRAVELLER 2
		bookingPage.clickTraveller2();
		bookingPage.writeFirstName2("anita");
		bookingPage.writeLastName2("bermudez");
		//TRAVELLER 3
		bookingPage.clickTraveller3();
		bookingPage.writeFirstName3("miri");
		bookingPage.writeLastName3("brown");
		//TRAVELLER 4
		bookingPage.clickTraveller4();
		bookingPage.writeFirstName4("karla");
		bookingPage.writeLastName4("brown");
		
		//PAYMENT METHOD
		bookingPage.clickPaymentMethod();
		bookingPage.clickContinuing();
		bookingPage.clickConfirmBooking();
		
		
		bookingInvoicePage.validationStatusPaid();
		bookingInvoicePage.validationStatusStripe();
		
		//PAYMENT SECTION
		//tourPage.printValidationPay();
		//tourPage.clickPayNowBtn();
		
		//PAYMENT INFORMATION
		bookingInvoicePage.printValidationInformation();
		bookingInvoicePage.printValidationGuestInformation();
		bookingInvoicePage.clickProceedPayBtn();
		
		//PAYMENT STRIPE
		paymentStripePage.VerifylabelAmount();
		paymentStripePage.PayNowWithAmount();
		
		//PAY WITH CARD
		payWithCardPage.clickCancelPopUpBtn();
		payWithCardPage.CardNumberInput("5555555555554444");
		payWithCardPage.CardExpiryInput("0330");
		payWithCardPage.CardCVCInput("200");
		payWithCardPage.NameCardInput("Customer January");
		payWithCardPage.clickPagarButtonWithInfoCard();
		
		
		//VALIDATION TOUR INVOICE
		bookingInvoicePage.printValidationStatusAndPayment();
		bookingInvoicePage.validateDateLabel();
		bookingInvoicePage.validateTitleHotel();
	}
}
