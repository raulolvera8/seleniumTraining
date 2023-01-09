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
import org.openqa.selenium.support.ui.WebDriverWait;

public class PTPayWithCardPage {

	WebDriver driver;

	public PTPayWithCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/// -------- CLICK CANCELAR BOTON POP UP SEGURIDAD METHOD -------- IRIS
		@FindBy(xpath="//*[@class='mt5 flex-container justify-content-center']//button") WebElement cancelPopUpBtn;
		public WebElement getCancelPopUpBtn() {
			return cancelPopUpBtn;
		}
		public void clickCancelPopUpBtn() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ModalContent VerificationModal-modal ModalContent--afterOpen']")));
			
			getCancelPopUpBtn().click();
			System.out.println("Pop up was closed");
		}
		
	/// -------- ENTER NUMBER CARD -------- IRIS
	@FindBy(id = "cardNumber")
	WebElement cardNumber;

	private WebElement getCardNumber() {
		return cardNumber;
	}

	public void CardNumberInput(String CardNumber) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(), 'Travel Booking')]")));

		System.out.println("Entering card number ...");
		getCardNumber().sendKeys(CardNumber);
	}

	/// -------- ENTER CARD EXPIRE -------- IRIS
	@FindBy(id = "cardExpiry")
	WebElement cardExpiry;

	private WebElement getCardExpiry() {
		return cardExpiry;
	}

	public void CardExpiryInput(String CardExpiry) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(), 'Travel Booking')]")));

		System.out.println("Entering card number expiry ...");
		getCardExpiry().sendKeys(CardExpiry);
	}

	/// -------- ENTER CVC CARD -------- IRIS
	@FindBy(id = "cardCvc")
	WebElement cardCVC;

	private WebElement getCardCVC() {
		return cardCVC;
	}

	public void CardCVCInput(String CardCVC) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(), 'Travel Booking')]")));

		System.out.println("Entering Card CVC ...");
		getCardCVC().sendKeys(CardCVC);
	}

	/// -------- ENTER NAME CARD -------- IRIS
	@FindBy(id = "billingName")
	WebElement nameCard;

	private WebElement getCardName() {
		return nameCard;
	}

	public void NameCardInput(String NameCard) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(), 'Travel Booking')]")));

		System.out.println("Entering name card ...");
		getCardName().sendKeys(NameCard);
	}

	/// -------- CLICK PAGAR BUTTON FROM VIEW AFTER PAYMENT METHOD -------- IRIS
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement PagarButton;

	private WebElement getPagarButtonWithCardInfo() {
		return PagarButton;
	}

	public void clickPagarButtonWithInfoCard() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

		getPagarButtonWithCardInfo().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='infobox infobox-success'][contains(.,' ( Paid')]")));

		System.out.println("Clicking Pagar button ...");
	}	
}
