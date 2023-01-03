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
		
		//Page object instances.
		
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTSupplier_Page supplierPage = new PTSupplier_Page(driver);
		
		
		// Account selection, main page.
		homePage.clickBtnAccount();
		
		//Click in Supplier login, main page.
		homePage.clickSupplierLoginbtn();
		
		//Insert email textbox, login supplier page.
		loginPage.setEmailtxtbox("supplier@phptravels.com");
		
		//Insert email textbox, login supplier page.
		loginPage.setPasswordtxtbox("demosupplier");
		
		//Click in login button.
		loginPage.clickLoginBtn();
		
		//Click in first level Tours Module.
		supplierPage.clickToursModuleBtn();
		
		//Click in second level, tours module > tours.
		supplierPage.clickToursModuleNestedBtn();
		
		//Click in third level, tours module > tours > manage tours.
		supplierPage.clickManageToursBtn();
		
		//Click in green button "Add".
		supplierPage.clickAddTourBtn();
		
		//Insert the tour name in textbox.
		supplierPage.insertTourNameTxt("Huatulco Trip.");
		
		//Insert the tour description.
		supplierPage.insertTourDescTxt("This is a test, describing a Huatulco trip.");
		
		//Insert adult quantity.
		supplierPage.insertAdultQtyTxt("2");
		
		//Insert the adult price (one person value).
		supplierPage.insertAdultPriceTxt("250.00");
		
		//Insert trip location.
		supplierPage.insertLocationTourTxt("Huatulco");
		
		// Click in "Inclusions" Tab.
		supplierPage.clickInclusionsBtn();
		
		//Select the checkbox...
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
