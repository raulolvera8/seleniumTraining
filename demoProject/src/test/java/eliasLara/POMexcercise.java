package eliasLara;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import pageObjectRepository.AOSChOpayment;
import pageObjectRepository.AOSChOproductsCategory;
import pageObjectRepository.AOSChAddToCart;
import pageObjectRepository.AOSChOCheckOut;
import pageObjectRepository.AOSChOValidationPayment;
import pageObjectRepository.AOSChOhomepage;

public class POMexcercise extends Driver {
		
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//initialize Webdriver
		this.driver = initChromeDriver();

	}
	
	@Test
	public void POMExcerciseAOS() throws InterruptedException{
		
		AOSChOhomepage homePage = new AOSChOhomepage(driver);
		//AOSMyAccountPage editPage = new AOSMyAccountPage (driver);
		AOSChOproductsCategory productPage = new AOSChOproductsCategory (driver);
		AOSChAddToCart productSpecsPage = new AOSChAddToCart (driver);
		AOSChOCheckOut shoppingCartPage = new AOSChOCheckOut (driver);
		AOSChOpayment orderPaymentPage = new AOSChOpayment (driver);
		AOSChOValidationPayment validation = new AOSChOValidationPayment(driver);
		
		//click user button
		homePage.clickUserButton();
		
		//enter username
		homePage.enterUsernameInput("Elias");
		
		//enter password
		homePage.enterPasswordInput("Itstark01");
		
		//click sign in button
		homePage.clickSignInButton();
		
				
		//Click in tablets button (Home Page, Load tablets page wait).
		
		homePage.clickTabletsButton();
		
		//Click in HP Elite X2 Tablet (Tablets Page, Load product specification page).
		
		productPage.clickgetHPEliteX2Button();
		
		//Click in Add to Cart button (Product Page, no load required).
		
		productSpecsPage.clickSaveToCartButton();
		
		//Click in Checkout cart icon (Product Page, Load shopping cart label page).
		
		productSpecsPage.clickCartIcon();
		
		//Click in Checkout button (Shopping cart page, load order payment label).
		
		shoppingCartPage.clickCheckoutButton();
		
		//Click on Next button (Order Payment Page, no load required).
		
		orderPaymentPage.clickNextButton();
		
		//Click on Pay Now button (Order Payment Page, load Order Payment final page, thanks label).
		
		orderPaymentPage.clickPayNowButton();
		
		//Extract order and tracking numbers.
		validation.orderNumber();
		
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}
	
}