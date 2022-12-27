package IrisRodriguez;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import phptravelsPageObjectRepository.PTAgentPage;
import phptravelsPageObjectRepository.PTHomePage;
import phptravelsPageObjectRepository.PTLoginPage;

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

		// CLICK ADD FUNDS BUTTON
		agentPage.clickBtnAddFunds();

		// PRINT WALLET BEFORE THE PAYMENT
		agentPage.VerifyWalletBalance();
		agentPage.VerifyWalletBalanceAmount();

		// SELECT STRIPE PAYMENT METHOD
		agentPage.clickrbtnStripePayment();

		// CLEAN DEFECT PRICE
		agentPage.clearPrice();

		// ENTER PRICE
		agentPage.enterPrice("200");

		// CLICK PAY NOW BUTTON
		agentPage.clickPayNowButton();

		// VERIFY PAYMENT
		agentPage.VerifylabelAmount();

		// CLICK PAY NOW WITH AMOUNT
		agentPage.PayNowWithAmount();

		// ENTER NUMBER CARD
		agentPage.CardNumberInput("4242 4242 4242 4242");

		// ENTER CARD EXPIRY
		agentPage.CardExpiryInput("0630");

		// ENTER CARD CVC
		agentPage.CardCVCInput("123");

		// ENTER NAME
		agentPage.NameCardInput("Agent Selenium");

		// CLICK PAGAR BUTTON
		agentPage.clickPagarButtonWithInfoCard();

		// VERIFY PAYMENT SUCCESSFULL
		agentPage.Verifylabel();

		// PRINT WALLET AFTER THE PAYMENT
		agentPage.VerifyWalletBalance();
		agentPage.VerifyWalletBalanceAmount();

		// CLICK SIGN OUT
		agentPage.ClickLogoutButton();

		// CLICK TO HOME PAGE
		agentPage.ClickLogoPage();
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}
