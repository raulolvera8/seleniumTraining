package JPetStorePO;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JP_homePage {
	WebDriver Driver;

	public JP_homePage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}



//******************************************************
//Title:clickReptilesIcon
//Objective: Click on Reptiles Icon.
//Author: Elías Lara.
//Date of creation/adding: 01 23 23
//*******************************************************

	@FindBy(xpath = "(//img[contains(@src, 'reptiles')])[2]")
	WebElement reptilesIcon;

	public WebElement getReptilesIcon() {
		return reptilesIcon;
	}

	public void clickReptilesIcon() {
		getReptilesIcon().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Reptiles']")));

		System.out.println("The Reptiles Icon has been clicked. The user is now in Reptiles Dashboard...");
	}
	
	
	
	//--------------------- CLICK ON FISH ICON --------------------------- IRIS
	@FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
	WebElement fishIcon;

	public WebElement getFishIcon() {
		return fishIcon;
	}
	public void clickFishesIcon() {
		getFishIcon().click();

        System.out.println("Clicking on Fish section... glu glu glu...");
		}
			
	//--------------------- CLICK ON FIRST ELEMENT FROM TABLE--------------------------- IRIS
	@FindBy(xpath = "(//td)[1]")
	WebElement FirstElementTable;

	public WebElement getFirstElementTable() {
		return FirstElementTable;
	}

	public void clickFirstElementTable() {
		getFirstElementTable().click();
		System.out.println("Clicking on first option...");
	}
	
	
	//LOGIN BUTTON
	@FindBy(xpath = "//*[text()='Sign In']" )
	WebElement signInButton;

    public WebElement getSignInButton() {
		return signInButton;
	}

	public void clickSignInButton() {
		
		getSignInButton().click();
	}
	
	//----------SELECT BIRDS BUTTON-------------
	@FindBy(xpath = "//*[@src='../images/sm_birds.gif']" )
	WebElement birdsButton;

    public WebElement getBirdsButton() {
		return birdsButton;
	}

	public void clickBirdsButton() {
		
		getBirdsButton().click();
		
		/*
		 * WebDriverWait waitElement = new WebDriverWait(Driver, Duration.ofSeconds(20),
		 * Duration.ofSeconds(5)); waitElement.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@href='Catalog.action?viewCategory=&categoryId=BIRDS']")));
		 */
		
	}


	// ---------- SELECT DOGS TAB ----------------- DIANA
		// XPATHS FOR DOGS TAB
		@FindBy(xpath="//img[@src='../images/dogs_icon.gif']")
		WebElement dogsTab;

		public WebElement getDogsTab() {
			return dogsTab;
		}
		public void clickDogsTab() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(this.Driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MainImage")));		
			getDogsTab().click();
		
		}
	
	
	

}
