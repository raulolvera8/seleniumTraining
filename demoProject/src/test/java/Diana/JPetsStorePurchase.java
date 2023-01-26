package Diana;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import JPetStorePO.JP_DogsPage;
import JPetStorePO.JP_LoginPage;
import JPetStorePO.JP_OrderPage;
import JPetStorePO.JP_ValidationAnimalselectedPage;
import JPetStorePO.JP_homePage;
import JPetStorePO.JP_paymentDetailsPage;
import JPetStorePO.JP_shoppingCartPage;
import library.Driver;


public class JPetsStorePurchase extends Driver {
	public WebDriver Driver;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		System.out.println("set up driver traavels");
		this.Driver = initFirefoxDriverPetStore();
	}
	@Parameters({ "quantity" })
	@Test(groups = { "pets" }, priority = 0)

	public void JPetstore_HomeWindow(String quantities) throws InterruptedException {
		// CLICK SIGN IN ACCOUNT ICON
		JP_homePage homeWindow = new JP_homePage(Driver);
		homeWindow.clickSignInButton();
		// SIGN IN ACCOUNT
		JP_LoginPage login = new JP_LoginPage(Driver);
		// WRITE USER
		login.writeUserName("DIANA");
		// CLEAR PASSWORD
		login.ClearPassword();
		// WRITE PASSWORD
		login.writePassword("JPETSTORE");
		// CLICK LOGIN BUTTON
		login.clickLoginButton();
		// CLICK DOGS TAB
		homeWindow.clickDogsTab();
		// CLIC ANIMAL'S NAME
		JP_DogsPage DogsWindow = new JP_DogsPage(Driver);

		DogsWindow.clickItem();
		// VALIDATION ANIMAL'S NAME SELECTED
		JP_ValidationAnimalselectedPage validation = new JP_ValidationAnimalselectedPage(Driver);
		validation.validationMsg();
		// CLICK ADD TO CART BUTTON
		DogsWindow.clickAddToCartBtn();
		// ----- VALIDATION TOTAL PRICE, LIST PRICE, QUANTITY SELECTED
		JP_shoppingCartPage shoppingCart = new JP_shoppingCartPage(Driver);
		// QUANTITY CHANGED
		shoppingCart.changeQuanity(quantities);
		// CLICK UPDATE BUTTON
		shoppingCart.clickUpdateCartBtn();
		// QUANTITY, TOTAL COST, LIST PRICE ARE SAVED
		String TotalCost = shoppingCart.readTotalCostLabel();
		double Total_Cost = Double.valueOf(TotalCost);
		String quantity = shoppingCart.readQuantityInput();
		int quantityChanged = Integer.valueOf(quantity);
		String listPrice = shoppingCart.readListPriceLabel();
		double list_Price = Double.valueOf(listPrice);
		// MULTIPLICATION LIST PRICE * QUANTITY
		double calculatedAmount = list_Price * quantityChanged;
		// VALIDATION RESULTS OF MULTIPLICATION
		if (calculatedAmount == Total_Cost) {
			System.out.println("Total a pagar: " + calculatedAmount);
			System.out.println("Quantity: " + quantityChanged);
			System.out.println("List Price : " + list_Price);
			shoppingCart.clickProceedtoCheckoutBtn();
		} else {
			System.out.println("FAILED");
		}
		// PAYMENT DETAILS
		JP_paymentDetailsPage paymentDetails = new JP_paymentDetailsPage(Driver);
		// CONTINUE TO NEXT WEBSITE
		paymentDetails.clickContinueBtn();
		// CONFIRM ORDER BTN
		JP_OrderPage order = new JP_OrderPage(Driver);
		order.clickConfirmOrderBtn();
		// CONFIRM ORDER LABEL
		order.readconfirmationLabel();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
	}
}
