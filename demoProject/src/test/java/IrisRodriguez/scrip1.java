package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.homePageObject;

public class scrip1 extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}

	@Test
	public void ShoppingHome() {

		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// SIGN IN PAGE
		homePageObject signInPage = new homePageObject(driver);
		

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================SIGN IN PAGE====================================
		
		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickBtnAccount();
		
		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER USERNAME
	    signInPage.enterUsernameInput("agent@phptravels.com");

		// ENTER PASSWORD
		signInPage.enterPasswordInput("demoagent");

	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
