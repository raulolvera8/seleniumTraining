package Diana;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
public class flightCustomer extends Driver {
WebDriver Driver;
@BeforeClass 
public void setup() {
	System.out.println("set up driver travels");
		this.Driver=initFirefoxDriver();
 }
@Test
public void travels() {
	PTHomePage home=new PTHomePage(Driver);
	PTLoginPage login = new PTLoginPage(Driver);
	
	home.clickBtnAccount();
	home.clickCustomerLoginbtn();
	login.fillEmail("user@phptravels.com");
	login.fillPassword("demouser");
	login.clickLogin();
	PTCustomerPageObject flights = new PTCustomerPageObject(Driver);
	flights.clickFlightsTab();
	
	
}

@AfterClass
public void teardown() {
	
}
}
