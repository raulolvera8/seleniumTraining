package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_homePage;
import library.Driver;

public class JPetStore_SearchFish extends Driver {

	WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	
	@Test(groups = {"home"})
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
	
	@AfterClass(alwaysRun=true)
	public void teardown() {
		//teardownDriver();
	}
}
