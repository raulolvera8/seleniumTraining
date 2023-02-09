package Juan;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import JPetStorePO.JP_BirdsDashboard;
import JPetStorePO.JP_LoginPage;
import JPetStorePO.JP_homePage;
import library.Driver;

@Listeners(library.listenersJuan.class)


public class scriptPurchaseBird extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initFirefoxDriverPetStore();
	}
	
	
	  @Test 
	  public void HomeJPetStore() {
	  
	  JP_homePage homePage = new JP_homePage(driver); 
	  JP_LoginPage loginBirds = new JP_LoginPage(driver);
	  JP_BirdsDashboard birdPage = new JP_BirdsDashboard(driver);

	  
	  //CLICK LOGIN BUTTON
	  homePage.clickSignInButton();
	  //WRITE THE USERNAME
	  loginBirds.writeUserName("juan21"); 
	  //CLEAR THE TEXT OF PASSWORD
	  loginBirds.ClearPassword(); 
	  //WRITE THE PASSWORD
	  loginBirds.writePassword("admina"); 
	  //CLICK LOGIN BUTTON
	  loginBirds.clickLoginButton(); 
	  //CLICK ON BIRDS 
	  homePage.clickBirdsButton();
	  //CLICK THE FIRST ELEMENT
	  birdPage.clickSelectBird();
      //CLICK ADD TO CART BUTTON
	  birdPage.clickAddToCartButton();
      //CLICK PROCEED TO CHECKOUT BUTTON
	  birdPage.clickProceedToCheckoutButton();
	  //CLICK CONTINUE BUTTON
	  birdPage.clickContinueButton();
	  //CLICK CONFIRM BUTTON
	  birdPage.clickConfirmButton();
	  //VERIFY THE ORDER
	  birdPage.VerifyOrderBird();
	  }
	  
	  @Test
	  public void testAddCategories() throws Exception {
		    if (true) {
		        throw new SkipException("Skipping test");
		    }
		}


	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}
