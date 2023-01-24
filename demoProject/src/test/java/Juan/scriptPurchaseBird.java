package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_BirdsDashboard;
import JPetStorePO.JP_LoginBirdsPage;
import JPetStorePO.JP_homePage;
import library.Driver;

public class scriptPurchaseBird extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initFirefoxDriver();
	}
	
	@Test
	public void HomeJPetStore() {

		JP_homePage homePage = new JP_homePage(driver);
		JP_LoginBirdsPage loginBirds = new JP_LoginBirdsPage(driver);
		JP_BirdsDashboard birdPage = new JP_BirdsDashboard(driver);

		//CLICK LOGIN BUTTON
		homePage.clickSignInButton();
		
		loginBirds.writeUserNameBird("JuanRam");
		
		loginBirds.ClearPassword();
		
		loginBirds.writePasswordBird("admin");
		
		loginBirds.clickLoginButton();
		//CLICK ON BIRDS
		homePage.clickBirdsButton();
		//CLICK THE FIRST ELEMENT
		birdPage.clickSelectBird();
		
		birdPage.clickAddToCartButton();
		
		birdPage.clickProceedToCheckoutButton();
		
		birdPage.clickContinueButton();
		
		birdPage.clickConfirmButton();
		
		birdPage.VerifyOrderBird();

	}

	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}
