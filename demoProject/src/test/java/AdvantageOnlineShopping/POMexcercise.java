package AdvantageOnlineShopping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Driver;
import pageObjectRepository.AOSMyAccountPage;
import pageObjectRepository.AOShomePage;

public class POMexcercise extends Driver {
		
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//initialize Webdriver
		this.driver = initFirefoxDriver();

	}
	
	@Test
	public void POMExcerciseAOS(){
		
		AOShomePage homePage = new AOShomePage(driver);
		AOSMyAccountPage editPage = new AOSMyAccountPage (driver);
		
		//click user button
		homePage.clickUserButton();
		
		//enter username
		homePage.enterUsernameInput("itstark");
		
		//enter password
		homePage.enterPasswordInput("Itstark123");
		
		//click sign in button
		homePage.clickSignInButton();
		
		//user now is logged in
		//click user menu button
		homePage.clickLoggedUserButton();
		
		//click my account from user menu
		homePage.clickMyAccountMenuButton();
		
		//Clic en edit button
		editPage.clickAccountDetailsButton();

		
	}
	
	@AfterClass
	public void teardown() {
		//teardownDriver();
	}

}
