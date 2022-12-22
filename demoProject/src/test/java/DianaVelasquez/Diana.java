package DianaVelasquez

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.phptravelsDriver;
import phptravelsPageObjectRepository.homePageObject;

public class Diana extends Driver {
	
WebDriver driver;
@BeforeClass
public void setup() {
	System.out.println("set up driver walmart");
	this.driver=initDireFoxDriver();
}

@Test
public void travelsProject() {
	System.out.println("----Welcome to travels----");
	homePageObject home=new homePageObject(driver);
	home.clickBtnAccount();
	home.clickCustomerLoginbtn();

	
}
@AfterClass
public void teardown() {
	
}
}
