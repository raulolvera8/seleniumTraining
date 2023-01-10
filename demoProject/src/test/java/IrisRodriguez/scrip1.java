package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import library.utilities;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTPayWithCardPage;
import phptravelsPageObjectRepository.PTPaymentWithStripePage;

public class scrip1 extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();
	}

	@Test
	public void ShoppingHome() {

		// =====================DECLARAR LAS PAGINAS DE OBJETOS=====================
		// SIGN IN PAGE
		PTHomePage signInPage = new PTHomePage(driver);
		PTLoginPage loginPage = new PTLoginPage(driver);
		PTAgentPage agentPage = new PTAgentPage(driver);
		PTPayWithCardPage cardPage = new PTPayWithCardPage(driver);
		PTPaymentWithStripePage stripePage = new PTPaymentWithStripePage(driver);
		utilities utils = new utilities(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================SIGN IN PAGE====================================

		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickAccountBtn();

		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER EMAIL
		loginPage.enterEmailInput("agent@phptravels.com");

		// ENTER PASSWORD
		loginPage.enterPasswordInput("demoagent");

		// CLICK LOGIN BUTTON
		loginPage.clickLoginButtonAgent();

		// =========================ADD FUNDS WINDOW====================================

		// CLICK ADD FUNDS BUTTON
		agentPage.clickBtnAddFunds();

		// PRINT WALLET BEFORE THE PAYMENT
		// double OldAmount = Integer.valueOf(agentPage.readWalletBalance());
		String valor = agentPage.readWalletBalance();
		double OldAmount = Integer.valueOf(valor);

		// SELECT STRIPE PAYMENT METHOD
		agentPage.clickrbtnStripePayment();

		// ENTER PRICE
		agentPage.enterPrice("100");

		// CLICK PAY NOW BUTTON
		agentPage.clickPayNowButton();

		// ======================== WINDOW PAYMENT WITH STRIPE ==================
		// VERIFY PAYMENT
		stripePage.VerifylabelAmount();

		// CLICK PAY NOW WITH AMOUNT
		stripePage.PayNowWithAmount();

		// ======================== WINDOW PAY WITH CARD FORM ==================
		// ENTER NUMBER CARD
		cardPage.CardNumberInput("4242 4242 4242 4242");

		// ENTER CARD EXPIRY
		cardPage.CardExpiryInput("0630");

		// ENTER CARD CVC
		cardPage.CardCVCInput("123");

		// ENTER NAME
		cardPage.NameCardInput("Agent Selenium");

		// CLICK PAGAR BUTTON
		cardPage.clickPagarButtonWithInfoCard();

		//// SCROLL DOWN
		utils.ScrollDown(driver, "0", "200");
		
		// PRINT PAYMENT SUCCESSFULL LABEL
		agentPage.PrintPaymentSuccessfulllabel();

		// PRINT WALLET AFTER THE PAYMENT
		String valor2 = agentPage.readWalletBalance();
		double NewAmount = Integer.valueOf(valor2);

		if (NewAmount > OldAmount) {
			System.out.println("The payment was successfull");
		} else {
			Assert.fail("FAILED: The Payment was not successfull");
		}

		// CLICK SIGN OUT
		agentPage.ClickLogoutButton();
		

		// WITCH TO THE MAIN WINDOW
		utils.switchToMainWindow();

	}

	@AfterClass
	public void teardown() {
		//teardownDriver();
	}
}
