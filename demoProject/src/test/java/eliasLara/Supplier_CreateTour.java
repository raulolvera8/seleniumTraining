package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTSupplier_Page;
import phptravelsPageObjectRepository.PTLoginPage;

public class Supplier_CreateTour extends Driver {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//initialize Webdriver
		this.driver = initChromeDriver();

	}
	
	@Test
	public void Supplier_CreateTourScript() {
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTSupplier_Page supplierPage = new PTSupplier_Page(driver);
		
		
		homePage.clickBtnAccount();
		homePage.clickSupplierLoginbtn();
		loginPage.setEmailtxtbox("supplier@phptravels.com");
		loginPage.setPasswordtxtbox("demosupplier");
		loginPage.clickLoginBtn();
		supplierPage.clickToursModuleBtn();
		supplierPage.clickToursModuleNestedBtn();
		supplierPage.clickManageToursBtn();
		supplierPage.clickAddTourBtn();
		supplierPage.insertTourNameTxt("Huatulco Trip.");
		supplierPage.insertTourDescTxt("This is a test, describing a Huatulco trip.");
		supplierPage.insertAdultQtyTxt("2");
		supplierPage.insertAdultPriceTxt("250.00");
		supplierPage.insertLocationTourTxt("Huatulco");
		supplierPage.clickInclusionsBtn();
		supplierPage.clickSelectAllCheckbox();
		supplierPage.clickCabFacilitiesChkbox();
		supplierPage.clickLocalTaxChkbox();
		supplierPage.clickPlaygrndNrbyChkbox();
		supplierPage.clickExclusionsBtn();
		supplierPage.clickVisaChargeChkbox();
		
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}
