package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AOSChAddToCart {
	WebDriver driver;

	public AOSChAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//-----ADD TO CART BUTTON---------
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCartButton;

	public WebElement getAddToCart() {
		return addToCartButton;
	}

	public void buttonAddToCart() {
		getAddToCart().click();

//
		Wait<WebDriver> waitAttribute = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		waitAttribute.until(ExpectedConditions.attributeToBe(By.id("toolTipCart"), "style", "display: none;"));

		System.out.println("Item is added to cart");
	}

//------SELECT CART-----

	@FindBy(id = "shoppingCartLink")
	WebElement cartBtn;

	public WebElement getBtnCart() {
		return cartBtn;
	}

	public void selectCartIcon() {
		getBtnCart().click();

		/*
		 * Wait<WebDriver> waitAttribute = new FluentWait<WebDriver>(this.driver)
		 * .withTimeout(Duration.ofSeconds(60)) .pollingEvery(Duration.ofSeconds(3))
		 * .ignoring(ElementNotInteractableException.class);
		 * 
		 * waitAttribute.until(ExpectedConditions.attributeToBe(By.id("toolTipCart"),
		 * "style", "display: none;"));
		 */

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='TOTAL:']")));

		Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style",
				"display: none; opacity: 0;"));

		System.out.println("Go to Shopping cart");

	}
	
@FindBy (name="save_to_cart") WebElement saveToCartButton;
	
	public WebElement getsaveToCartButton() {
		return saveToCartButton;	
	}
	
	public void clickSaveToCartButton() throws InterruptedException {
		System.out.println("Click on Save to Cart button in Product Specification Page...");
		getsaveToCartButton().click();
		
		Thread.sleep(5000);
	}
	
	@FindBy (id="menuCart") WebElement cartIcon;
	
	public WebElement getCartIcon() {
		return cartIcon;	
	}
	
	public void clickCartIcon() {
		System.out.println("Click on Save to Cart icon in Product Specification Page...");
		getCartIcon().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(18))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("//h3[contains(text(), 'SHOPPING CART')]"),"innerHTML" ,"SHOPPING CART"));
	}
	
	
}
