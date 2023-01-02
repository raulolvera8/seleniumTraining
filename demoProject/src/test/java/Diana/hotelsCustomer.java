package Diana;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTCustomerPageObject;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

public class hotelsCustomer extends Driver{
	WebDriver driver;
	public void  scrollDown() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scroll(0,800)");
	   }
	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.driver=initFirefoxDriver();
	}

	@Test
	public void travel() {
		System.out.println("----Welcome to Hotels----");
		PTHomePage home=new PTHomePage(driver);
		PTLoginPage login = new PTLoginPage(driver);
		PTCustomerPageObject hotels= new PTCustomerPageObject(driver);
		home.clickBtnAccount();
		home.clickCustomerLoginbtn();
		login.fillEmail("user@phptravels.com");
		login.fillPassword("demouser");
		hotels.clickGotItBtn();

		login.clickLogin();
		//---Click hotels tab
		hotels.clickHotelsBtn();
		scrollDown();
		hotels.clickhotelDiv();
		//

		
		
	}
	@AfterClass
	public void teardown() {
		
	}
}
