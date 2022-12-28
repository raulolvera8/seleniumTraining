package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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
		PTHomePage home=new PTHomePage(driver);
		PTLoginPage login = new PTLoginPage(driver);
		PTCustomerPageObject visa= new PTCustomerPageObject(driver);
		home.clickBtnAccount();
		home.clickCustomerLoginbtn();
		login.fillEmail("user@phptravels.com");
		login.fillPassword("demouser");
		login.clickLogin();
		//Click Visa Tab 
		visa.clickVisaBtn();
		//Click dropdown Btn
		visa.clickFromCountry();
		///Select From Country
		visa.selectItemFromCountry();
		//Click dropdown Btn
		visa.clickToCountryBtn();
		///Select To Country
		visa.selectItemToCountry();
		//Select DateBox
		visa.selectDateBox();
		
		


		
	}
	@AfterClass
	public void teardown() {
		
	}
}
