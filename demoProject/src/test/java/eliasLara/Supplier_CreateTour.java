package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTAddTourPage_Supplier;
import phptravelsPageObjectRepository.PTDashboardPage_Supplier;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTToursMngmntPage_Supplier;

public class Supplier_CreateTour extends Driver {

	WebDriver driver;
	utilities utility;

	@BeforeClass
	public void setup() {
		// initialize Webdriver
		this.driver = initChromeDriver();

	}

	@Test
	public void Supplier_CreateTourScript() {

		// Page object instances.

		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTDashboardPage_Supplier dashBoard = new PTDashboardPage_Supplier(driver);
		PTToursMngmntPage_Supplier tourManage = new PTToursMngmntPage_Supplier(driver);
		PTAddTourPage_Supplier addTour = new PTAddTourPage_Supplier(driver);
		utilities utility = new utilities(driver);

		// Obtain the main page identificator.
		utility.saveMainWindowHandle();

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

		// Click in first level Tours Module.
		dashBoard.clickToursModuleBtn();

		// Click in second level, tours module > tours.
		dashBoard.clickToursModuleNestedBtn();

		// Click in third level, tours module > tours > manage tours.
		dashBoard.clickManageToursBtn();

		// Verify if the tour is already created.
		tourManage.verifyIfTourExistPrevCreation("Huatulco Trip.");

		// Click in green button "Add".
		tourManage.clickAddTourBtn();

		// Insert the tour name in textbox.
		addTour.insertTourNameTxt("Huatulco Trip.");

		// Insert the tour description.
		addTour.insertTourDescTxt("This is a test, describing a Huatulco trip.");

		// Insert adult quantity.
		addTour.insertAdultQtyTxt("2");

		// Insert the adult price (one person value).
		addTour.insertAdultPriceTxt("250.00");

		// Insert trip location.
		addTour.insertLocationTourTxt("Huatulco");

		// Click in "Inclusions" Tab.
		addTour.clickInclusionsTab();

		// Select the checkbox required (each related to its name)...
		addTour.clickSelectAllCheckbox();
		addTour.clickCabFacilitiesChkbox();
		addTour.clickLocalTaxChkbox();
		addTour.clickPlaygrndNrbyChkbox();

		// Click in "Exclusions" tab and clicking Visa Charge.
		addTour.clickExclusionsTab();
		addTour.clickVisaChargeChkbox();

		// Click META INFO Tab.

		addTour.clickMetaInfoTab();

		// Insert META Title textbox.

		addTour.setMetaTitleTxtbox("Huatulco Trip");

		// Insert META Keywords textbox.

		addTour.setMetaKeywordsTxtbox("HUATULCO");

		// Insert META Description text area.

		addTour.setMetaDescTxtarea("This is a description for a meta text area.");

		// Click in POLICY Tab.

		addTour.clickPolicyTab();

		// Insert Payment Options textbox.

		addTour.setPaymentOptTxtbox("Credit Card");

		// Insert Policy & Terms text area.

		addTour.setPolicyAndTermsTxtarea("This is a text describing the policy and terms for Huatulco's trip.");

		// Click in CONTACT Tab.

		addTour.clickContactTab();

		// Insert Tours Operator's Email textbox.

		addTour.setTourEmailTxtbox("huatulcotrip@dummymail.com");

		// Insert Operator's Website textbox.

		addTour.setTourWebsiteTxtbox("www.huatulcotrip.com");

		// Insert Operator's Phone textbox.

		addTour.setTourPhoneTxtbox("528441234567");

		// Insert Operator's Full Address textbox.

		addTour.setTourAddressTxtbox("Random St. 3254 Portland, Oregon.");

		// Insert Tour Hours textbox.

		addTour.setTourHoursTxtbox("72");

		// Insert Tour Days textbox.

		addTour.setTourDaysTxtbox("3");

		// Insert Tour Nights textbox.

		addTour.setTourNightsTxtbox("2");

		// Select Tour Type list.

		addTour.selectTourType("Couples");

		// Clicking the submit button.

		addTour.clickSubmitBtn();

		// Verify if tour has been added and shown properly.

		tourManage.VerifyIfTourIsAdded("Huatulco Trip");

		// Click in profile button for logout option.

		tourManage.clickProfileBtn();

		// Click in logout option after clicking the profile button.

		tourManage.clickLogoutBtn();

		// Close current window.

		utility.CloseCurrentWindow();

	}

	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}