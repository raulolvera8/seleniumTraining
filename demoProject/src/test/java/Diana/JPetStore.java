package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import JPetStorePO.JP_DogsPage;
import JPetStorePO.JP_LoginPage;
import JPetStorePO.JP_OrderPage;
import JPetStorePO.JP_ValidationAnimalselectedPage;
import JPetStorePO.JP_homePage;
import JPetStorePO.JP_paymentDetailsPage;
import JPetStorePO.JP_shoppingCartPage;

public class JPetStore extends Driver {
	public WebDriver Driver;
	@BeforeClass (alwaysRun=true)
	public void setup() {
		System.out.println("set up driver traavels");
		this.Driver = initFirefoxDriverPetStore();
	}
	@Test 
	public void JPetstore_HomeWindow() throws InterruptedException {
		JP_homePage homeWindow = new JP_homePage(Driver);
		homeWindow.clickSignInButton();
		JP_LoginPage login = new JP_LoginPage(Driver);
		login.writeUserName("DIANA");
		login.ClearPassword();
		login.writePassword("JPETSTORE");
		login.clickLoginButton();
		homeWindow.clickDogsTab();

		
		
		JP_DogsPage DogsWindow = new JP_DogsPage(Driver);
		DogsWindow.clickItem();
	
		JP_ValidationAnimalselectedPage validation= new JP_ValidationAnimalselectedPage(Driver);
		validation.validationMsg();
		DogsWindow.clickAddToCartBtn();
		// ----- VALIDATION AMOUNT
		JP_shoppingCartPage shoppingCart = new JP_shoppingCartPage(Driver);
		shoppingCart.changeQuanity("5");
		shoppingCart.clickUpdateCartBtn();
		String TotalCost = shoppingCart.readTotalCostLabel();
		double Total_Cost = Double.valueOf(TotalCost);
		String quantity = shoppingCart.readQuantityInput();
		int quantityChanged = Integer.valueOf(quantity);
		String listPrice = shoppingCart.readListPriceLabel();
		double list_Price = Double.valueOf(listPrice);
	
		double calculatedAmount = list_Price * quantityChanged;
		if (calculatedAmount ==  Total_Cost) {
			System.out.println("Total a pagar: " + calculatedAmount);
			System.out.println("Quantity: " + quantityChanged);
			System.out.println("List Price : " + list_Price);
			shoppingCart.clickProceedtoCheckoutBtn();
		}else {
			System.out.println("FAILED");
		}
		
		JP_paymentDetailsPage paymentDetails = new JP_paymentDetailsPage(Driver);
		paymentDetails.clickContinueBtn();
		JP_OrderPage order= new JP_OrderPage(Driver);
		order.clickConfirmOrderBtn();
	
	}
	@Test
	public void JPetstore_DogWindow() {

	}
	@Test 
	public void JPetstore_validationMsg() {
		
	}
	
	public void JPetstore_addToCart() {
		
	}
	@AfterClass (alwaysRun=true)
	public void tearDown() {
	}
}
