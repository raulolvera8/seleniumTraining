package iris;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import walmartPageObject.SWSignInPage;

public class script1 extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initChromeDriver();
	}

	@Test
	public void GotoAccount() {

		//=====================DECLARAR LAS PAGINAS DE OBJETOS===================== 
		
		//SIGN IN PAGE
		SWSignInPage signInPage = new SWSignInPage(driver);
		
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		
		//============================================SIGN IN PAGE============================================
		// CLICK USER BUTTON
		//signInPage.clickUserButton();

		// ENTER USERNAME
		//signInPage.enterUsernameInput("IrisRod");

		// ENTER PASSWORD
		//signInPage.enterPasswordInput("Sooya12345");

		
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
