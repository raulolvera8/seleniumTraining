package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;

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
		PTMenuPage tourPage = new PTMenuPage(driver);
		PTCustomerPageObject tourInfo = new PTCustomerPageObject(driver);
		homePage.clickBtnAccount();
		homePage.clickCustomerLoginbtn();
		
		//LOGIN 
		loginPage.fillEmail("user@phptravels.com");
		loginPage.fillPassword("demouser");
		loginPage.clickLogin();
		
		//ENTER TOURS
		tourPage.clickToursBtn();
		tourInfo.clickDestination();
		tourInfo.writeCountry("dubai");
		tourInfo.clickSubmit();
		tourInfo.clickDetails();
		
		//SELECT DATE
		tourInfo.clickDateTour();
		tourInfo.clickDateSelect();
		tourInfo.clickAdults();
		tourInfo.clickAdultsNumber();
		tourInfo.clickChilds();
		tourInfo.clickChildsNumber();
		tourInfo.clickInfants();
		tourInfo.clickInfantsNumber();
		tourInfo.clickBookNowDate();
		
		//TRAVELLERS INFO
		tourInfo.clickTraveller1();
		tourInfo.writeFirstName1("Ana");
		tourInfo.writeLastName1("Lopez");
		
		tourInfo.clickTraveller2();
		tourInfo.writeFirstName2("Juliana");
		tourInfo.writeLastName2("Delgado");
		
		tourInfo.clickTraveller3();
		tourInfo.writeFirstName3("Angel");
		tourInfo.writeLastName3("Ramos");
		
		//PAYMENT METHOD
		tourInfo.clickPaymentMethod();
		tourInfo.clickContinuing();
		tourInfo.clickConfirmBooking();
		tourInfo.printValidationStatus();
		tourInfo.printValidationDetails();
		tourInfo.printValidationInfo();
		tourInfo.clickProceed();
		
		//PAYMENT SECTION
		tourInfo.printValidationPay();
		tourInfo.clickPayNowBtn();
		
	}
}
