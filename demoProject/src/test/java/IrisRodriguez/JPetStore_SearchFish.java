package IrisRodriguez;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import JPetStorePO.JP_homePage;
import library.Driver;

public class JPetStore_SearchFish extends Driver {

	WebDriver driver;

	@BeforeClass()
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	
	@Test()
	public void HomeJPetStore() {
		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// HOME PAGE PETSTORE
		JP_homePage homePage = new JP_homePage(driver);
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================HOME PAGE====================================
	    
		// ENTER WORD ON SEARCH INPUT
		homePage.EnterTextInputSearch("fish");
		
		// CLICK ON SEARCH BUTTON
		homePage.clickSearchButton();

	}
	
	@AfterClass()
	public void teardown() {
		//teardownDriver();
	}
}
