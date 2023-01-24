package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_FishPage;
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
		JP_FishPage fishPage = new JP_FishPage(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================HOME PAGE====================================
	    
		//CLICK ON FISH OPTION
		homePage.clickFishesIcon();
		
		// PRINT ID FIRST FISH 
		fishPage.PrintIdFirstColumn();
		
		// PRINT NAME FIRST FISH
		fishPage.PrintNameFirstColumn();

		//CLICK ON FIRST ELEMENT FROM TABLE
		fishPage.clickFirstElementTable();

	}

	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}
