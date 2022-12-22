package DianaVelasquez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import walmartPageObject.SWhomePage;
import walmartPageObject.SWSignInPage;


public class Diana extends Driver {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.out.println("set up driver walmart");
		this.driver=initFirefoxDriver();
	}
	@Test
	public void walmartProject() throws InterruptedException {
		System.out.println("----Sign In Travels----");
	
	}
	@AfterClass
	public void teardown() {
		
	}
}
