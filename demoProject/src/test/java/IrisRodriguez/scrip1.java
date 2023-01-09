package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;
import phptravelsPageObjectRepository.PTMenuPage;
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
		PTMenuPage menuPage = new PTMenuPage(driver);
		PTAgentPage agentPage = new PTAgentPage(driver);
		PTPayWithCardPage cardPage = new PTPayWithCardPage(driver);
		PTPaymentWithStripePage stripePage = new PTPaymentWithStripePage(driver);

		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		// =========================SIGN IN PAGE====================================

		// CLICK BUTTON SELECT TYPE ACCOUNT
		signInPage.clickBtnAccount();

		// CLICK USER BUTTON
		signInPage.clickAgentLoginbtn();

		// ENTER EMAIL
		// loginPage.enterEmailInput("agent.phptravels@gmail.com");
		loginPage.enterEmailInput("agent@phptravels.com");

		// ENTER PASSWORD
		// loginPage.enterPasswordInput("26dediciembre");
		loginPage.enterPasswordInput("demoagent");

		// CLICK LOGIN BUTTON
		loginPage.clickLoginButtonAgent();

		// =========================ADD FUNDS WINDOW====================================

		// CLICK ADD FUNDS BUTTON
		agentPage.clickBtnAddFunds();

		// PRINT WALLET BEFORE THE PAYMENT
		agentPage.VerifyWalletBalance();

		// SELECT STRIPE PAYMENT METHOD
		agentPage.clickrbtnStripePayment();

		// CLEAN DEFECT PRICE
		agentPage.clearPrice();

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

		// VERIFY PAYMENT SUCCESSFULL
		agentPage.Verifylabel();

		// PRINT WALLET AFTER THE PAYMENT
		agentPage.VerifyWalletBalanceAmount();

		// CLICK SIGN OUT
		agentPage.ClickLogoutButton();

		// CLICK TO HOME PAGE
		menuPage.ClickLogoPage();
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
