package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.homePageObject;
import phptravelsPageObjectRepository.logInPageObject;

public class scriptCustomer extends Driver {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.driver=initFirefoxDriver();
	}

	@Test
	public void travel() {
		System.out.println("----Welcome to travels----");
		homePageObject home=new homePageObject(driver);
		logInPageObject login = new logInPageObject(driver);
		home.clickBtnAccount();
		home.clickCustomerLoginbtn();
		login.fillEmail("user@phptravels.com");
		login.fillPassword("demouser");
		login.clickLogin();


		
	}
	@AfterClass
	public void teardown() {
		
	}
}
