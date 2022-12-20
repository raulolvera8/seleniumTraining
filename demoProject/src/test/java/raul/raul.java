package raul;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import walmartPageObject.SWhomePage;
import walmartPageObject.SWSignInPage;

public class raul extends Driver{
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.out.println("Setup driver");
		this.driver=initChromeDriver();
	}
	@Test
	public void walmartProject() {
		
		System.out.println("Walmart sign in");
		SWhomePage mainWebsite = new SWhomePage(driver);
		SWSignInPage signInPage = new SWSignInPage(driver);
		
		signInPage.insertEmailTextBox("sanchezparmenides6@gmail.com");

		signInPage.insertPasswordTextBox("Rulo*24637172");
		
		signInPage.clickSignInButton();
		
		//mainWebsite.clickCuentaBtn();
		//mainWebsite.clickIniciarSesionBtn();
		//avoiding detection
	    
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
