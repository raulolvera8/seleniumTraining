package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTSupplier_Page;

public class Supplier_AddRoom extends Driver{
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		this.driver = initChromeDriver();	
	}
	
	@Test
	public void Supplier_AddRoomScript() {
		
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTSupplier_Page supplierPage = new PTSupplier_Page(driver);
		
		homePage.clickBtnAccount();
		homePage.clickSupplierLoginbtn();
		loginPage.setEmailtxtbox("supplier@phptravels.com");
		loginPage.setPasswordtxtbox("demosupplier");
		loginPage.clickLoginBtn();
		supplierPage.clickHotelsModuleBtn();
		supplierPage.clickHotelsModuleNestedBtn();
		supplierPage.clickAddRoomsBtn();
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}
