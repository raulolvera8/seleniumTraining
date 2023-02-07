package IrisRodriguez;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;

import JPetStorePO.JP_ResultsFromSearchPage;
import JPetStorePO.JP_homePage;
import library.Driver;
import library.ListenersIris;
@Listeners(library.ListenersIris.class)
public class JPetStore_SearchFish extends Driver {

	WebDriver driver;

	@BeforeClass()
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriverPetStore();
	}
	
	@Test()
	public void HomeJPetStore() {
		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// HOME PAGE PETSTORE
		JP_homePage homePage = new JP_homePage(driver);
		JP_ResultsFromSearchPage searchPage = new JP_ResultsFromSearchPage(driver);
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================HOME PAGE====================================
	    
		// ENTER WORD ON SEARCH INPUT
		homePage.EnterTextInputSearch("fish");
		
		// CLICK ON SEARCH BUTTON
		homePage.clickSearchButton();
		
		// PRINT ALL RESULTS
		searchPage.PrintResults();

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResultOfTestMethodThatWasRun) {
		String testMethodName = ListenersIris.getTestMethodName(testResultOfTestMethodThatWasRun);
		System.out.println(testMethodName + "() Thread: " + Thread.currentThread().getId() + " Ending session: "
				+ testResultOfTestMethodThatWasRun.getAttribute("session"));
	}
	
	@AfterClass()
	public void teardown() {
		//teardownDriver();
	}
}
