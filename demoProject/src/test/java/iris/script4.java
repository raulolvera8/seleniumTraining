package iris;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import walmartPageObject.SWhomePage;

public class script4 extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initChromeDriver();
	}
	
	@Test
	public void YouWantButton() {

		//=====================DECLARAR LAS PAGINAS DE OBJETOS===================== 
		
		//SIGN IN PAGE
		SWhomePage signInPage = new SWhomePage(driver);
		
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		
		//============================================SIGN IN PAGE============================================
		// CLICK ¿QUE QUIERES COMPRAR? BUTTON
		signInPage.clickcomprarhoyButton();

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
