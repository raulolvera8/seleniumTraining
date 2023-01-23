package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_ReptilesDashboard;
import JPetStorePO.JP_homePage;
import library.Driver;

public class PetStore_ReptilesValidations extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = initChromeDriverWtURL("https://petstore.octoperf.com/actions/Catalog.action");
	}

	@Test
	public void PetStore_ReptilesValidationsScript() {
		//Page Object Instances.
		JP_homePage homePage = new JP_homePage(driver);
		JP_ReptilesDashboard reptilesDash = new JP_ReptilesDashboard(driver);
		
		//Click on reptiles icon.
		homePage.clickReptilesIcon();
		
		//Extract the values from reptiles rows.
		reptilesDash.getFirstColumn();
		reptilesDash.getSecondColumn();
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}

}
