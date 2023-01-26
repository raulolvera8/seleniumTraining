package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import library.Driver;
import JPetStorePO.JP_DogsPage;
import JPetStorePO.JP_LoginPage;
import JPetStorePO.JP_OrderPage;
import JPetStorePO.JP_ValidationAnimalselectedPage;
import JPetStorePO.JP_homePage;
import JPetStorePO.JP_paymentDetailsPage;
import JPetStorePO.JP_shoppingCartPage;

public class JPetStore extends Driver {
	public WebDriver Driver;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		System.out.println("set up driver traavels");
		this.Driver = initFirefoxDriverPetStore();
	}
	@Test(groups = { "pets" }, priority = 0)

	public void JPetstore_HomeWindow() throws InterruptedException {
		JP_homePage homeWindow = new JP_homePage(Driver);
		JP_ValidationAnimalselectedPage validation = new JP_ValidationAnimalselectedPage(Driver);
		JP_DogsPage DogsWindow = new JP_DogsPage(Driver);

		// CLICK DOGS TAB
		homeWindow.clickDogsTab();
		// CLIC ANIMAL'S NAME
		DogsWindow.clickItem();
		// VALIDATION ANIMAL'S NAME SELECTED
		validation.validationMsg();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
	}
}
