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

	/// -------- ADD FUNDS BUTTON --------
	@FindBy(xpath = "//a[ contains (text(), 'Add Funds') and @class=' waves-effect']")
	WebElement btnAddFunds;

	private WebElement getbtnAddFunds() {
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

	/// -------- SELECT STRIPE RADIOBUTTON --------
	@FindBy(xpath = "//input[@name='payment_gateway' and @value='stripe']")
	WebElement rbtnStripePayment;

	private WebElement getStripePayment() {
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

	/// -------- CLEAR AMOUNT INPUT --------
	@FindBy(name = "price")
	WebElement inputPriceClear;

	private WebElement getPriceInputClean() {
		return inputPriceClear;
	}

	public void clearPrice() {
		getPriceInputClean().clear();
	}

	/// -------- ENTER AMOUNT INPUT --------
	@FindBy(name = "price")
	WebElement inputPrice;

	private WebElement getPriceInput() {
		return inputPrice;
	}

	public void enterPrice(String Price) {
		System.out.println("Entering price ...");
		getPriceInput().sendKeys(Price);
	}

	/// -------- CLICK PAY NOW BUTTON --------
	@FindBy(xpath = "//button[contains (text(), 'Pay Now') and @type='submit']")
	WebElement PayNowButton;

	private WebElement getPayNowButton() {
		return PayNowButton;
	}

	public void clickPayNowButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));

		getPayNowButton().click();
		System.out.println("Clicking Pay Now button ...");
	}

	/// -------- VERIFY PAY WITH STRIPE USD XX.XX --------
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

	/// -------- PAY NOW WITH AMOUNT XX.XX BUTTON --------
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
	}

	/// -------- ENTER NUMBER CARD --------
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

	/// -------- ENTER CARD EXPIRE --------
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

	/// -------- ENTER CVC CARD --------
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

	/// -------- ENTER NAME CARD --------
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

	/// -------- CLICK PAGAR BUTTON FROM VIEW AFTER PAYMENT METHOD --------
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement PagarButton;

	private WebElement getPagarButtonWithCardInfo() {
		return PagarButton;
	}

	public void clickPagarButtonWithInfoCard() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

		getPagarButtonWithCardInfo().click();
		System.out.println("Clicking Pagar button ...");
	}

	/// -------- VERIFY PAYMENT SUCCESSFULL --------

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

	/// -------- LOGOUT BUTTON FROM USER VIEW --------
	@FindBy(xpath = "(//a[ contains (text(), 'Logout')])[2]")
	WebElement LogOut;

	private WebElement getLogouttButton() {
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

	/// -------- HOME PAGE FROM LOGO IMAGE --------
	@FindBy(xpath = "(//a[@href='https://phptravels.net/'])[1]")
	WebElement logopage;

	private WebElement getLogoPage() {
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

	/// -------- WALLET BALANCE --------

	@FindBy(xpath = "//p[contains (text(), 'Wallet Balance') and @class='info__desc']")
	WebElement walletbalance;

	private WebElement getWalletBalance() {
		return walletbalance;
	}

	public void VerifyWalletBalance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains (text(), 'Wallet Balance') and @class='info__desc']")));

		System.out.println("Hi, Your " + getWalletBalance().getText());
	}

	/// -------- VERIFY AMOUNT BLANCE --------
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

	/// -------- ADD FLIGHTS BUTTON --------
	@FindBy(xpath = "//a[ contains (text(), 'flights') and @class='active_flights waves-effect']")
	WebElement btnFlights;

	private WebElement getbtnFlights() {
		return btnFlights;
	}

	public void clickbtnFlights() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[ contains (text(), 'flights') and @class='active_flights waves-effect']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnFlights().click();

		System.out.println("Clicking Flights button...");
	}

	/// -------- FLYING FROM INPUT --------
	@FindBy(xpath = "//input[@id='autocomplete']")
	WebElement FlyingFromInput;

	private WebElement getFlyingFromInput() {
		return FlyingFromInput;
	}

	public void flyingFromInput(String city) {
		System.out.println("Entering city ...");
		getFlyingFromInput().sendKeys(city);
	}

	/// -------- FLYING FROM AUTOCOMPLETE LOCATION --------
	@FindBy(xpath = "(//div[@class='autocomplete-result'])[1]")
	WebElement FlyingFromAutocomplete;

	private WebElement getFlyingFromAutocomplete() {
		return FlyingFromAutocomplete;
	}

	public void flyingFromAutocomplete() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='autocomplete-result'])[1]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getFlyingFromAutocomplete().click();

		System.out.println("Clicking autocomplete first option button...");
	}

	/// -------- TO DESTINATION INPUT --------
	@FindBy(id = "autocomplete2")
	WebElement toDestinationInput;

	private WebElement getToDestinationInput() {
		return toDestinationInput;
	}

	public void toDestinationInput(String city) {
		System.out.println("Entering city destination ...");
		getToDestinationInput().sendKeys(city);
	}

	/// -------- TO DESTINATION AUTOCOMPLETE LOCATION SELECT FIRST RESULT --------
	@FindBy(xpath = "(//div[@class='autocomplete-result'])[1]")
	WebElement toDestinationAutocomplete;

	private WebElement getToDestinationAutocomplete() {
		return toDestinationAutocomplete;
	}

	public void ToDestinationAutocomplete() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='autocomplete-result'])[2]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getToDestinationAutocomplete().click();

		System.out.println("Clicking autocomplete second option button...");
	}

	/// -------- DATE INPUT FOR TO SEE THE CALENDAR OPTION --------
	@FindBy(xpath = "//input[@id='departure' and @class='depart form-control']")
	WebElement dateFly;
	
	private WebElement getDateInput() {
		return dateFly;
	}
	
	public void DateInput() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='departure' and @class='depart form-control']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getDateInput().click();

		System.out.println("Clicking autocomplete date option button...");
	}
	
	/// ------------ SELECT DAY FROM CALENDAR PICKER (OPTION 6 DAY ) ------------
	@FindBy(xpath = "(//td[@class='day  new'])[6]")
	WebElement datepicker;
	
	private WebElement getDatepickerOption() {
		return datepicker;
	}
	
	public void SelectDateFromCalendar() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='day  new'])[6]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getDatepickerOption().click();

		System.out.println("Selecting day...");
	}
	
	
	/// ------------ SELECT INPUT TRAVELERS -------------
	@FindBy (xpath = "//a[@class='dropdown-toggle dropdown-btn travellers waves-effect' and @role='button']")
	WebElement travelersInput;
	
	private WebElement getTravelersInput() {
		return travelersInput;
	}
	
	public void clickTravelersInput() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle dropdown-btn travellers waves-effect' and @role='button']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getTravelersInput().click();

		System.out.println("Clicking travelers button...");
	}
	
	/// --------------- SELECT 2 ADULTS TRAVELLERS OPTION -----------------
	@FindBy (xpath = "//div[@class='dropdown-item adult_qty']//i[@class='la la-plus']")
	WebElement adultsOptionPlus;
	
	private WebElement getAdultsOptionPlus()
	{
		return adultsOptionPlus;
		
	}
	
	public void clickAdultsOptionPlus() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown-item adult_qty']//i[@class='la la-plus']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getAdultsOptionPlus().click();

		System.out.println("Adding 1 Adult ...");
	}
	
	/// ----- PRINT NUMBER OF PASSENGERS ------
	@FindBy(xpath = "//span[@class='guest_flights']")
	WebElement NumberPassengers;
	
	private WebElement getNumberPassengers() {
		return NumberPassengers;
	}
	
	public void PrintNumberPassangers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='guest_flights']")));

		System.out.println("Number of Passengers " + getNumberPassengers().getText());
	}
	
	/// ------- SEARCH FLIGHTS BUTTON ------
	@FindBy (id = "flights-search")
	WebElement searchFlightButton;
	
	private WebElement getsearchFlightButton() {
		return searchFlightButton;
	}
	
	public void clickSearchFlightButton() {
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("flights-search")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getsearchFlightButton().click();

		System.out.println("Clicking search flights button  ...");
	}
	
	/// ----- SELECT FIRST TRAVEL ON VIEW FLIGHTS ------
	@FindBy (xpath = "(//button[@class='btn btn-block theme-search-results-item-price-btn ladda waves-effect'])[1]//span")
	WebElement firstflight;
	
	private WebElement getFirstFlight()
	{
		return firstflight;
	}
	
	public void clickFirstFlight() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-block theme-search-results-item-price-btn ladda waves-effect'])[1]//span")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getFirstFlight().click();

		System.out.println("Clicking first flight option  ...");
	}
	
	/// ========== DEMO INFORMATION FROM BOOK FLIGHT VIEW ============
	
	/// ------- FIRST NAME -------
	@FindBy (xpath = "(//div[@class='row'])[3]")
	WebElement firstnameLabel;
	
	private WebElement getfirstnamelabel()
	{
		return firstnameLabel;
	}
	
	public void PrintFirstName() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[3]")));

		System.out.println(getfirstnamelabel().getText());
	}
	
	
	
	/// ------- LAST NAME -------
	@FindBy (xpath = "(//div[@class='row'])[4]")
	WebElement lastnameLabel;
	
	private WebElement getlastnamelabel()
	{
		return lastnameLabel;
	}
	
	public void PrintLastNameLabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[4]")));

		System.out.println(getlastnamelabel().getText());
	}
	
	/// ------- EMAIL -------
	@FindBy (xpath = "(//div[@class='row'])[5]")
	WebElement emailLabel;
	
	private WebElement getEmailLabel()
	{
		return emailLabel;
	}
	
	public void PrintEmailLabel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='row'])[5]")));

		System.out.println(getEmailLabel().getText());
	}
	
	
	
}