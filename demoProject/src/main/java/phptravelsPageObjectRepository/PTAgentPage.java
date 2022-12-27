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

public class PTAgentPage {

	WebDriver driver;

	public PTAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// ----ADD FUNDS BUTTON-----
	@FindBy(xpath = "//a[ contains (text(), 'Add Funds') and @class=' waves-effect']")
	WebElement btnAddFunds;

	public WebElement getbtnAddFunds() {
		return btnAddFunds;
	}

	public void clickBtnAddFunds() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnAddFunds().click();

		System.out.println("Clicking Add Funds button...");
	}

	/// ----SELECT STRIPE RADIOBUTTON-----
	@FindBy(xpath = "//input[@name='payment_gateway' and @value='stripe']")
	WebElement rbtnStripePayment;

	public WebElement getStripePayment() {
		return rbtnStripePayment;
	}

	public void clickrbtnStripePayment() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains (text(), 'Payment Method')]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getStripePayment().click();
		System.out.println("Clicking radiobutton Stripe payment method ...");
	}

	/// ----CLEAR AMOUNT INPUT-----
	@FindBy(name = "price")
	WebElement inputPriceClear;

	public WebElement getPriceInputClean() {
		return inputPriceClear;
	}

	public void clearPrice() {
		getPriceInputClean().clear();
	}

	/// ----ENTER AMOUNT INPUT-----
	@FindBy(name = "price")
	WebElement inputPrice;

	public WebElement getPriceInput() {
		return inputPrice;
	}

	public void enterPrice(String Price) {
		System.out.println("Entering price ...");
		getPriceInput().sendKeys(Price);
	}

	/// ----CLICK PAY NOW BUTTON-----
	@FindBy(xpath = "//button[contains (text(), 'Pay Now') and @type='submit']")
	WebElement PayNowButton;

	public WebElement getPayNowButton() {
		return PayNowButton;
	}

	public void clickPayNowButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));

		getPayNowButton().click();
		System.out.println("Clicking Pay Now button ...");
	}

	// ------ VERIFY PAY WITH STRIPE USD XX.XX ------

	@FindBy(xpath = "//strong")
	WebElement labelAmount;

	private WebElement getLabelAmount() {
		return labelAmount;
	}

	public void VerifylabelAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getLabelAmount().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small")));

		System.out.println("Pay With " + getLabelAmount().getText());
	}

	// ---- PAY NOW WITH AMOUNT XX.XX BUTTON ----
	@FindBy(xpath = "//a[contains (text(), 'Pay Now') and @type='button']")
	WebElement PayNowWithAmount;

	public WebElement getPayNowAmount() {
		return PayNowWithAmount;
	}

	public void PayNowWithAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains (text(), 'Pay Now') and @type='button']")));
		getPayNowAmount().click();
	}

	// ----- ENTER NUMBER CARD ----
	@FindBy(id = "cardNumber")
	WebElement cardNumber;

	public WebElement getCardNumber() {
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

	// ---- ENTER CARD EXPIRE ----
	@FindBy(id = "cardExpiry")
	WebElement cardExpiry;

	public WebElement getCardExpiry() {
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

	// ---- ENTER CVC CARD ----
	@FindBy(id = "cardCvc")
	WebElement cardCVC;

	public WebElement getCardCVC() {
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

	// ---- ENTER NAME CARD ----
	@FindBy(id = "billingName")
	WebElement nameCard;

	public WebElement getCardName() {
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

	// ---- CLICK PAGAR BUTTON ----
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement PagarButton;

	public WebElement getPagarButtonWithCardInfo() {
		return PagarButton;
	}

	public void clickPagarButtonWithInfoCard() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

		getPagarButtonWithCardInfo().click();
		System.out.println("Clicking Pagar button ...");
	}

	// ------ VERIFY PAYMENT SUCCESSFULL ----

	@FindBy(xpath = "//strong[contains (text(), 'Payment successfull')]")
	WebElement labelSuccessfull;

	private WebElement getLabelSuccessfull() {
		return labelSuccessfull;
	}

	public void Verifylabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		getLabelAmount().isDisplayed();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//strong[contains (text(), 'Payment successfull')]")));

		System.out.println("Hi, Agent.. " + getLabelSuccessfull().getText());
	}


	// --- LOGOUT BUTTON FROM USER VIEW ----
	@FindBy(xpath = "(//a[ contains (text(), 'Logout')])[2]")
	WebElement LogOut;

	public WebElement getLogouttButton() {
		return LogOut;
	}

	public void ClickLogoutButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[ contains (text(), 'Logout')])[2]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getLogouttButton().click();
		System.out.println("Clicking LOGOUT button ...");
	}

	// ---- HOME PAGE FROM LOGO IMAGE ----
	@FindBy(xpath = "(//a[@href='https://phptravels.net/'])[1]")
	WebElement logopage;

	public WebElement getLogoPage() {
		return logopage;
	}

	public void ClickLogoPage() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='https://phptravels.net/'])[1]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getLogoPage().click();
		System.out.println("Welcome to Home Page phptravels ...");
	}

	//----  WALLET BALANCE 

	@FindBy(xpath = "//p[contains (text(), 'Wallet Balance') and @class='info__desc']")
	WebElement walletbalance;

	private WebElement getWalletBalance() {
		return walletbalance;
	}

	public void VerifyWalletBalance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains (text(), 'Wallet Balance') and @class='info__desc']")));

		System.out.println("Hi, Your " + getWalletBalance().getText());
	}
	
	// ---- VERIFY AMOUNT BLANCE
	@FindBy(xpath = "//h4[contains (text(), 'USD ') and @class='info__title']")
	WebElement walletbalanceAmount;

	private WebElement getWalletBalanceAmount() {
		return walletbalanceAmount;
	}

	public void VerifyWalletBalanceAmount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[contains (text(), 'USD ') and @class='info__title']")));

		System.out.println("Is now " + getWalletBalanceAmount().getText());
	}
	
}
