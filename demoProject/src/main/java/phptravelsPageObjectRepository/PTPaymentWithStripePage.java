package phptravelsPageObjectRepository;

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

import library.utilities;

public class PTPaymentWithStripePage {

	WebDriver driver;

	public PTPaymentWithStripePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	utilities utils = new utilities(driver);

	/// -------- VERIFY PAY WITH STRIPE USD XX.XX (LABEL) -------- IRIS
	@FindBy(xpath = "//strong")
	WebElement labelAmount;

	private WebElement getLabelAmount() {
		return labelAmount;
	}

	public void VerifylabelAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getLabelAmount().isDisplayed();
		
		// SWITCH TO NEW WINDOW
		utils.switchToNewWindow();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small")));

		System.out.println("Pay With " + getLabelAmount().getText());
	}

	/// -------- PAY NOW BUTTON WITH AMOUNT XX.XX BUTTON -------- IRIS
	@FindBy(xpath = "//a[contains (text(), 'Pay Now') and @type='button']")
	WebElement PayNowWithAmount;

	private WebElement getPayNowAmount() {
		return PayNowWithAmount;
	}

	public void PayNowWithAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains (text(), 'Pay Now') and @type='button']")));
		getPayNowAmount().click();
		System.out.println("Clicking Pay Now button");

	}

}
