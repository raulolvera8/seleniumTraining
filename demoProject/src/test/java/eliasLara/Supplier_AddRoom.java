package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTAddRoomPage_Supplier;
import phptravelsPageObjectRepository.PTDashboardPage_Supplier;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTRoomsMngmntPage_Supplier;

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
		PTDashboardPage_Supplier dashBoard = new PTDashboardPage_Supplier(driver);
		PTAddRoomPage_Supplier addRoomPage = new PTAddRoomPage_Supplier(driver);
		PTRoomsMngmntPage_Supplier roomMngmntPage = new PTRoomsMngmntPage_Supplier(driver);
		utilities utility = new utilities(driver);
		
		//Get the Main Page ID.
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

		// Insert Room name.
		addRoomPage.insertHotelNameTxt("Hyatt Regency Perth");

		// Insert Room type.
		addRoomPage.insertRoomTypeTxtbox("Two-Bedroom Apartment");

		// Insert Room description text area.
		addRoomPage.insertRoomDescTxt("This is a brief description of the Room.");

		// Select Price Type drop down.
		addRoomPage.selectPriceTypeList("By Fixed");

		// Insert Price text box.
		addRoomPage.setPriceTxtbox("250.00");

		// Insert Quantity Text box.
		addRoomPage.setQtyTxtbox("4");

		// Insert Minimum Stay (Min Stay) text box.
		addRoomPage.setMinStayTxtbox("3");

		// Select Maximum Adults Quantity (Max Adults) drop down.
		addRoomPage.selectMaxAdultsList("10");

		// Select Maximum Children Quantity (Max Child) drop down.
		addRoomPage.selectMaxChildList("4");

		// Insert Number of Extra Beds (No. of Extra Beds) text box.
		addRoomPage.setExtraBedsTxtbox("1");

		// Insert Extra Bed Charges.
		addRoomPage.setExtraBedsChrgTxtbox("50.00");

		// Click in Submit button.
		addRoomPage.clickSubmitBtn();

		// Verify if the room has been registered and saved properly.
		roomMngmntPage.VerifyIfRoomIsAdded("Two-Bedroom Apartment");

		// Click in Dashboard Main button.
		dashBoard.clickDashboardBtn();

		// Click in Profile dropdown.
		dashBoard.clickProfileBtn();

		// Click in Logout button.
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
