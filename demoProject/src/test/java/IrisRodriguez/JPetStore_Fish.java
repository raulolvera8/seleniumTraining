package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import JPetStorePO.JP_FishPage;
import JPetStorePO.JP_homePage;
import library.Driver;
@Listeners(library.ListenersIris.class)
public class JPetStore_Fish extends Driver {

	WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriverPetStore();
	}
	
	@Test(groups = {"home"})
	public void HomeJPetStore() {
		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// HOME PAGE PETSTORE
		JP_homePage homePage = new JP_homePage(driver);
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================HOME PAGE====================================
	    
		//CLICK ON FISH OPTION
		homePage.clickFishesIcon();
	}
	
	@Test(groups = {"fishIndex"})
	public void JPetStore() {
		JP_FishPage fishPage = new JP_FishPage(driver);
		
		// PRINT ID FIRST FISH 
		fishPage.PrintIdFirstColumn();
		
		// PRINT NAME FIRST FISH
		fishPage.PrintNameFirstColumn();

		//CLICK ON FIRST ELEMENT FROM TABLE
		fishPage.clickFirstElementTable();
	}
	
//	@AfterMethod(alwaysRun = true)
//	public void tearDown(ITestResult testResultOfTestMethodThatWasRun) {
//		String testMethodName = ListenersIris.getTestMethodName(testResultOfTestMethodThatWasRun);
//		System.out.println(testMethodName + " is finished");
//	}
	
	

	@AfterClass(alwaysRun=true)
	public void teardown() {
		//teardownDriver();
	}
}
