package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import JPetStorePO.JP_DogsPage;
import JPetStorePO.JP_ValidationAnimalselectedPage;
import JPetStorePO.JP_homePage;

public class JPetStore extends Driver {
	public WebDriver Driver;
	@BeforeClass
	public void setup() {
		System.out.println("set up driver traavels");
		this.Driver = initFirefoxDriverPetStore();
	}
	@Test 
	public void JPetstore_HomeWindow() {
		JP_homePage homeWindow = new JP_homePage(Driver);
		homeWindow.clickDogsTab();
		JP_DogsPage DogsWindow = new JP_DogsPage(Driver);
		DogsWindow.clickItem();
		JP_ValidationAnimalselectedPage validation= new JP_ValidationAnimalselectedPage(Driver);
		validation.validationMsg();
	}
	@Test
	public void JPetstore_DogWindow() {
		
	}
	@Test 
	public void JPetstore_validationMsg() {

	}
	@AfterClass
	public void tearDown() {
	}
}
