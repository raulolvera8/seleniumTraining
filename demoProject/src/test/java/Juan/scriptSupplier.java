package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTDashboardPage_Supplier;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;

public class scriptSupplier extends Driver {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	@Test
	public void supplierBooking() {
		
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTDashboardPage_Supplier dashboardPage = new PTDashboardPage_Supplier(driver);
		
		homePage.clickAccountBtn();
		//SELECT AND CLICK THE ROLE
		homePage.clickNewSupplierLoginbtn();
		
		//WRITE THE EMAIL AND PASSWORD
		//EMAIL
		loginPage.setEmailtxtbox("supplier@phptravels.com");
		//PASSWORD
		loginPage.setPasswordtxtbox("demosupplier");
		//CLICK IN LOGIN BUTTON
		loginPage.clickLoginBtn();
		//CLICK IN PENDING BUTTON
		dashboardPage.clickPendingBookingBtn();
		//VIEW THE ID
		dashboardPage.VerifyId();
		//CLICK BOOKING STATUS
		dashboardPage.clickBookingStatus();
		//SELECT THE STATUS
		dashboardPage.clickStatusCancel();
		//CLICK CANCEL BOOKING
		dashboardPage.clickCancelBookingBtn();
		//VERIFY THE ID
		dashboardPage.VerifyId();


}
}
