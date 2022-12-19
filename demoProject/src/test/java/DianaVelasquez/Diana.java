package DianaVelasquez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import walmartPageObject.SWhomePage;


public class Diana extends Driver {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.out.println("set up driver walmart");
		this.driver=initFirefoxDriver();
	}
	@Test
	public void walmartProject() {
		System.out.println("----Sign In Walmart----");
		SWhomePage mainWebsite = new SWhomePage(driver);
		//mainWebsite.clickCuentaBtn();
		//mainWebsite.clickIniciarSesionBtn();
		//avoiding detection
	    
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
