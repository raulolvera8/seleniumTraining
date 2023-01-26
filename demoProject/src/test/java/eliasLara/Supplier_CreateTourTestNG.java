package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTAddTourPage_Supplier;
import phptravelsPageObjectRepository.PTDashboardPage_Supplier;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTToursMngmntPage_Supplier;

//******************************************************
// Title: Supplier_CreateTour
// Objective: CREATES A TOUR WITH SUPPLIER ROLE.
// Author: Elías Lara.
// Date of creation/adding: 01 07 23
// *******************************************************

public class Supplier_CreateTourTestNG extends Driver {

	WebDriver driver;
	utilities utility;

	@BeforeClass
	public void setup() {
		// initialize Webdriver
		this.driver = initChromeDriver();

	}

	@Parameters({ "email", "password", "tourName", "tourDesc", "adultQty", "adultPrice", "locationTour", "metaTitle",
			"metaKeywords", "metaDesc", "paymentOption", "policyAndTerms", "tourEmail", "tourWebsite", "tourPhone",
			"tourAddress", "tourHours", "tourDays", "tourNights", "tourType" })

	@Test
	public void Supplier_CreateTourScript(String email, String password, String tourName, String tourDesc,
			String adultQty, String adultPrice, String locationTour, String metaTitle, String metaKeywords, String metaDesc,
			String paymentOption, String policyAndTerms, String tourEmail, String tourWebsite, String tourPhone,
			String tourAddress, String tourHours, String tourDays, String tourNights, String tourType) {

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
		loginPage.setEmailtxtbox(email);

		// Insert email textbox, login supplier page.
		loginPage.setPasswordtxtbox(password);

		// Click in login button.
		loginPage.clickLoginBtn();

		// Click in first level Tours Module.
		dashBoard.clickToursModuleBtn();

		// Click in second level, tours module > tours.
		dashBoard.clickToursModuleNestedBtn();

		// Click in third level, tours module > tours > manage tours.
		dashBoard.clickManageToursBtn();

		// Verify if the tour is already created.
		tourManage.verifyIfTourExistPrevCreation(tourName);

		// Click in green button "Add".
		tourManage.clickAddTourBtn();

		// Insert the tour name in textbox.
		addTour.insertTourNameTxt(tourName);

		// Insert the tour description.
		addTour.insertTourDescTxt(tourDesc);

		// Insert adult quantity.
		addTour.insertAdultQtyTxt(adultQty);

		// Insert the adult price (one person value).
		addTour.insertAdultPriceTxt(adultPrice);

		// Insert trip location.
		addTour.insertLocationTourTxt(locationTour);

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

		addTour.setMetaTitleTxtbox(metaTitle);

		// Insert META Keywords textbox.

		addTour.setMetaKeywordsTxtbox(metaKeywords);

		// Insert META Description text area.

		addTour.setMetaDescTxtarea(metaDesc);

		// Click in POLICY Tab.

		addTour.clickPolicyTab();

		// Insert Payment Options textbox.

		addTour.setPaymentOptTxtbox(paymentOption);

		// Insert Policy & Terms text area.

		addTour.setPolicyAndTermsTxtarea(policyAndTerms);

		// Click in CONTACT Tab.

		addTour.clickContactTab();

		// Insert Tours Operator's Email textbox.

		addTour.setTourEmailTxtbox(tourEmail);

		// Insert Operator's Website textbox.

		addTour.setTourWebsiteTxtbox(tourWebsite);

		// Insert Operator's Phone textbox.

		addTour.setTourPhoneTxtbox(tourPhone);

		// Insert Operator's Full Address textbox.

		addTour.setTourAddressTxtbox(tourAddress);

		// Insert Tour Hours textbox.

		addTour.setTourHoursTxtbox(tourHours);

		// Insert Tour Days textbox.

		addTour.setTourDaysTxtbox(tourDays);

		// Insert Tour Nights textbox.

		addTour.setTourNightsTxtbox(tourNights);

		// Select Tour Type list.

		addTour.selectTourType(tourType);

		// Clicking the submit button.

		addTour.clickSubmitBtn();

		// Verify if tour has been added and shown properly.

		tourManage.VerifyIfTourIsAdded(tourName);

		// Click in Dasboard main button.

		dashBoard.clickDashboardBtn();

		// Click in profile button for logout option.

		dashBoard.clickProfileBtn();

		// Click in logout option after clicking the profile button.

		dashBoard.clickLogoutBtn();

		// Closing the browsers.

		utility.CloseCurrentWindow();
		utility.switchToMainWindow();

	}

	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}