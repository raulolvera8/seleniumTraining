package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_homePage;
import library.Driver;

public class JPetStore_Fish extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}
	
	@Test
	public void HomeJPetStore() {

		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// HOME PAGE PETSTORE
		JP_homePage homePage = new JP_homePage(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================HOME PAGE====================================
	    
		//CLICK ON FISH OPTION
		homePage.clickFishesIcon();

		//CLICK ON FIRST ELEMENT FROM TABLE
		homePage.clickFirstElementTable();

	}

	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}
