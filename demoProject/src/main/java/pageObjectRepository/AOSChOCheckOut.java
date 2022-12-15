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

public class AOSChOCheckOut {
	WebDriver driver;

	public AOSChOCheckOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

////----Select Check out Button
	@FindBy(id = "checkOutButton")
	WebElement checkOutBtn;

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}

	public void selectCheckOutBtn() {
		getCheckOutBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));

		Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style",
				"display: none; opacity: 0;"));

		System.out.println("You're going to  Window Order Payment");

	}
	
@FindBy (id="checkOutButton") WebElement checkoutButton;
	
	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	
	public void clickCheckoutButton() {
		System.out.println("Click in Checkout button at Shopping Cart Page...");
		getCheckoutButton().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(18))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementNotInteractableException.class);
	
		wait.until(ExpectedConditions.attributeContains(By.xpath("//h3[contains(text(), 'ORDER PAYMENT')]"),"innerHTML" ,"ORDER PAYMENT"));
	}
}
