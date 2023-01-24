package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_BirdsDashboard;
import JPetStorePO.JP_homePage;
import library.Driver;

public class scriptPetStore extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initFirefoxDriver();
	}
	
	@Test
	public void HomeJPetStore() {

		JP_homePage homePage = new JP_homePage(driver);
		JP_BirdsDashboard birdPage = new JP_BirdsDashboard(driver);

	
	    
		//CLICK ON BIRDS
		homePage.clickBirdsButton();
		//CLICK THE FIRST ELEMENT
		birdPage.clickSelectBird();
		//VERIFY THE BIRD PAGE
		birdPage.VerifySelectedBird();

	}

	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}