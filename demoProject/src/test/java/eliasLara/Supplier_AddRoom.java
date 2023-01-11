package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;


public class Supplier_AddRoom extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initChromeDriver();
	}

	@Test
	public void Supplier_AddRoomScript() {

		// Page object instances.
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		//PTSupplier_Page supplierPage = new PTSupplier_Page(driver);

		// Account selection, main page.
		homePage.clickAccountBtn();

		// Click in Supplier login, main page.
		homePage.clickSupplierLoginbtn();

		// Insert email textbox, login supplier page.
		loginPage.setEmailtxtbox("supplier@phptravels.com");

		// Insert email textbox, login supplier page.
		loginPage.setPasswordtxtbox("demosupplier");

		// Click in login button.
		loginPage.clickLoginBtn();
		
		/*
		 * //Click in first level Hotels Module. supplierPage.clickHotelsModuleBtn();
		 * 
		 * //Click in second level Hotels Module > Hotels.
		 * supplierPage.clickHotelsModuleNestedBtn();
		 * 
		 * //Click in third level Hotels Module > Hotels > Add Room.
		 * supplierPage.clickAddRoomsBtn();
		 */
	}

	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}
