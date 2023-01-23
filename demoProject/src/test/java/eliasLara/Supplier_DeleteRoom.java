package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTDashboardPage_Supplier;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTRoomsMngmntPage_Supplier;

//******************************************************
//Title: Supplier_DeleteRoom
//Objective: DELETES A ROOM PREVIOUSLY CREATED WITH SUPPLIER ROLE.
//Author: Elías Lara.
//Date of creation/adding: 01 18 23
//*******************************************************

public class Supplier_DeleteRoom extends Driver {

	WebDriver driver;
	utilities utility;

	@BeforeClass
	public void setup() {
		// initialize Webdriver
		this.driver = initChromeDriver();
	}

	@Test
	public void Supplier_DeleteRoomScript() {
		
		// Page object instances.
		PTHomePage homePage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTDashboardPage_Supplier dashBoard = new PTDashboardPage_Supplier(driver);
		PTRoomsMngmntPage_Supplier roomMngmntPage = new PTRoomsMngmntPage_Supplier(driver);
		utilities utility = new utilities(driver);

		// Get the Main Page ID.
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

		// Click in first level Hotels Module.
		dashBoard.clickHotelsModuleBtn();

		// Click in second level Hotels Module > Hotels.
		dashBoard.clickHotelsModuleNestedBtn();

		// Click in third level Hotels Module > Hotels > Add Room.
		dashBoard.clickAddRoomsBtn();
	}

}
