package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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
		PTCustomerPageObject tourPage = new PTCustomerPageObject(driver);
		homePage.clickBtnAccount();
		homePage.clickCustomerLoginbtn();
		
		//LOGIN 
		loginPage.fillEmail("user@phptravels.com");
		loginPage.fillPassword("demouser");
		loginPage.clickLogin();
		
		//ENTER TOURS
		tourPage.clickToursBtn();
		tourPage.clickDestination();
		tourPage.writeCity("dubai");
		tourPage.clickSubmit();
		tourPage.clickDetails();
		
		//SELECT DATE
		tourPage.clickDateTour();
		tourPage.clickDateSelect();
		tourPage.clickAdults();
		tourPage.clickAdultsNumber();
		tourPage.clickChilds();
		tourPage.clickChildsNumber();
		tourPage.clickInfants();
		tourPage.clickInfantsNumber();
		tourPage.clickBookNowDate();
		
		//TRAVELLERS INFO
		tourPage.clickTraveller1();
		tourPage.writeFirstName1("Ana");
		tourPage.writeLastName1("Lopez");
		
		tourPage.clickTraveller2();
		tourPage.writeFirstName2("Juliana");
		tourPage.writeLastName2("Delgado");
		
		tourPage.clickTraveller3();
		tourPage.writeFirstName3("Angel");
		tourPage.writeLastName3("Ramos");
		
		//PAYMENT METHOD
		tourPage.clickPaymentMethod();
		tourPage.clickContinuing();
		tourPage.clickConfirmBooking();
		tourPage.printValidationStatus();
		tourPage.printValidationDetails();
		tourPage.printValidationInfo();
		tourPage.clickProceed();
		
		//PAYMENT SECTION
		tourPage.printValidationPay();
		tourPage.clickPayNowBtn();
		
	}
}
