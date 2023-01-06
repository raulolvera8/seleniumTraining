package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTBookingInvoicePage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

public class script3 extends Driver{

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}

	@Test
	public void ShoppingHome() {

		// ===================== DECLARAR LAS PAGINAS DE OBJETOS =====================
		// SIGN IN PAGE
		PTHomePage signInPage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTAgentPage agentPage = new PTAgentPage(driver);
		PTBookingInvoicePage bookingInvoicePage = new PTBookingInvoicePage(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// ========================= SIGN IN PAGE ====================================

		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickBtnAccount();

		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER EMAIL
		// loginPage.enterEmailInput("agent.phptravels@gmail.com");
		loginPage.enterEmailInput("agent@phptravels.com");

		// ENTER PASSWORD
		// loginPage.enterPasswordInput("26dediciembre");
		loginPage.enterPasswordInput("demoagent");

		// CLICK LOGIN BUTTON
		loginPage.clickLoginButtonAgent();

		// ======================== MY BOOKINGS WINDOW ========================
		
		// CLICK MY BOOKINGS BUTTON
		agentPage.ClickMyBookingsButton();

		// CLICK VIEW VOUCHER BUTTON
		agentPage.ClickViewVoucherButton();
		
		// PRINT DATA
		bookingInvoicePage.VerifyFirstDataBooking(); // FIRST NAME, LAST NAME, EMAIL, PHONE, ADDRESS
		bookingInvoicePage.VerifySecondDataBooking(); // COMPANY NAME, EMAIL, PHONE, ADDRESS COMPANY

	}
	

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
