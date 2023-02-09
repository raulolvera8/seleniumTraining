package Juan;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import JPetStorePO.JP_BirdsDashboard;
import JPetStorePO.JP_homePage;
import library.Driver;
 

@Listeners(library.listenersJuan.class)

public class scriptPetStore extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initFirefoxDriverPetStore();
	}
	
	@Test(groups = {"Home"}) 
	public void HomeJPetStore() {

		JP_homePage homePage = new JP_homePage(driver);  
		
		//CLICK ON BIRDS
		homePage.clickBirdsButton();
	
		
	}
	
	@Test(groups={"Birds"}) 
	public void BirdsPetStore() {
		
		JP_BirdsDashboard birdPage = new JP_BirdsDashboard(driver);
		
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