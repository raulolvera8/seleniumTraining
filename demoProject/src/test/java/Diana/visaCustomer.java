package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;
import phptravelsPageObjectRepository.PTVisaFormPage;
import phptravelsPageObjectRepository.PTVisaPage;

public class visaCustomer extends Driver {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.driver=initFirefoxDriver();
	}

	@Test
	public void travel() {
		System.out.println("----Welcome to travels----");
		PTHomePage home=new PTHomePage(driver);
		PTLoginPage login = new PTLoginPage(driver);
		PTVisaPage visaPage= new PTVisaPage(driver);
		PTMenuPage visaTab = new PTMenuPage(driver);
		PTVisaFormPage visaForm = new PTVisaFormPage(driver);
		PTBookingInvoicePage visaValidation = new PTBookingInvoicePage(driver);
		/// steps to login
		home.clickBtnAccount();
		home.clickCustomerLoginbtn();
		login.fillEmail("user@phptravels.com");
		login.fillPassword("demouser");
		login.clickLogin();
		//Click Visa Tab 
		visaTab.clickVisaBtn();
		//Click dropdown Btn
		visaPage.clickFromCountry();
		///Select From Country
		visaPage.selectItemFromCountry();
		//Click dropdown Btn
		visaPage.clickToCountryBtn();
		///Select To Country
		visaPage.selectItemToCountry();
		//Select DateBox
		visaPage.selectDateBox();
		//Select Day Calendar
		visaPage.clickDayCalendar();
		//Click Search Icon
		visaPage.clickSearchIcon();
		
		visaForm.writeFirstName("Diana");
		visaForm.writeLastName("Velasquez");
		visaForm.writeEmail("user@phptravels.com");
		visaForm.writePhone("844523659");
		visaForm.writeNotes("HELLO");
		visaForm.clickSubmitBtn();
		visaValidation.printVisaValidation();
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
