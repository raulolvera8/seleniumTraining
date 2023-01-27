package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
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
	
	@Parameters ({"CardNumber", "CardExpiry", "CardCVC", "CardName"})
	
	@Test(dataProvider = "myInformation", dataProviderClass = dataProviderTour.class)

	
	public void CustomerPage(String cardNumber, String cardExpiry, String cardCVC, String cardName) {


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
		loginPage.fillEmailTb("juan.ramirez@itstarksolutions.com");
		loginPage.fillPasswordTb("demouser");
		loginPage.clickGotItBtn();
		loginPage.clickLoginCustomerBtn();
		
		//ENTER TOURS
		tourMenuPage.clickToursBtn();
		tourPage.clickDestination();
		tourPage.writeCountry("dubai");
		tourPage.selectItemFromTour();
		tourPage.clickSubmitBtn();
		
		
		tourDubai.clickDetailsBtn();
		
		//SELECT DATE
		tourDetails.clickDateTour();
		tourDetails.clickDateSelect();
		tourDetails.clickAdults();
		tourDetails.clickAdultsNumber();
		tourDetails.clickChilds();
		tourDetails.clickChildsNumber(1);
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
		bookingPage.writeLastName2("perez");
		
		//TRAVELLER 3
		//bookingPage.clickTraveller3();
		bookingPage.writeFirstName3("michael");
		bookingPage.writeLastName3("brown");
		
		//TRAVELLER 4
		//bookingPage.clickTraveller4();
		bookingPage.writeFirstName4("karla");
		bookingPage.writeLastName4("brown");
		
		
		//PAYMENT METHOD
		bookingPage.clickPaymentMethod();
		bookingPage.clickContinuing();
		bookingPage.clickConfirmBooking();
		
		
	    bookingInvoicePage.validationStatusStripe();
		bookingInvoicePage.VerifyFirstDataBooking();
		bookingInvoicePage.VerifySecondDataBooking();
		
		//String totalPriceInProcess = bookingInvoicePage.readTotalPricePaidLabel();
		//System.out.println("PAGO EN PROCESO DE AUTORIZAR: " + totalPriceInProcess);
		
		//bookingInvoicePage.readTotalPriceUnpaidLabel();
		bookingInvoicePage.clickTourProceedPayBtn();
		
		//PAYMENT STRIPE
		paymentStripePage.VerifylabelAmount();
		paymentStripePage.PayNowWithAmount();
		
		//PAY WITH CARD
		//payWithCardPage.clickCancelPopUpBtn();
		//payWithCardPage.CardNumberInput("5555555555554444");
		payWithCardPage.CardNumberInput(cardNumber);
		
		//payWithCardPage.CardExpiryInput("0330");
		payWithCardPage.CardExpiryInput(cardExpiry);
		
		//payWithCardPage.CardCVCInput("200");
		payWithCardPage.CardCVCInput(cardCVC);
		
		//payWithCardPage.NameCardInput("Customer January");
		payWithCardPage.NameCardInput(cardName);
		
		//payWithCardPage.clickPagarButtonWithInfoCard();
		
		
		//VALIDATION TOUR INVOICE
		bookingInvoicePage.validationStatusPaid();
		bookingInvoicePage.VerifyFirstDataBooking();
		bookingInvoicePage.VerifySecondDataBooking();
		
		String totalPrice = bookingInvoicePage.readTotalPricePaidLabel();
		System.out.println("PRECIO TOTAL : " + totalPrice);
		//bookingInvoicePage.printValidationStatusAndPayment();
		//bookingInvoicePage.validateDateLabel();
		//bookingInvoicePage.validateTitleHotel();
	}
}
