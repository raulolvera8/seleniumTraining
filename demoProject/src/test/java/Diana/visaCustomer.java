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
		// CLICK VISA TAB
		visaTab.clickVisaBtn();
		// ----- VISA HOME PAGE WINDOW -----
		// CLICK FROM COUNTRY BOX
		visaPage.clickFromCountry();
		// CLICK COUNTRY VALUE
		visaPage.selectItemFromCountry();
		// CLICK TO COUNTRY BOX
		visaPage.clickToCountryBtn();
		// CLICK COUNTRY VALUE
		visaPage.selectItemToCountry();
		// CLICK CALENDAR BOX
		visaPage.selectDateBox();
		// CLICK DAY CALENDAR
		visaPage.clickDayCalendar();
		// CLICK SEARCH ICON
		visaPage.clickSearchIcon();
		// TYPE FIRST NAME
		visaForm.writeFirstName("Diana");
		// TYPE LAST NAME
		visaForm.writeLastName("Velasquez");
		// TYPE EMAIL
		visaForm.writeEmail("user@phptravels.com");
		// TYPE PHONE
		visaForm.writePhone("844523659");
		// TYPE SOME NOTES
		visaForm.writeNotes("HELLO");
		// CLICK SUBMIT BUTTON
		visaForm.clickSubmitBtn();
		// PRINT VALIDATION STATUS
		visaValidation.printVisaValidation();
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
