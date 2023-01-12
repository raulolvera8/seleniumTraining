package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;

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

import library.utilities;

public class PTAgentPage {

	WebDriver driver;
	utilities utility;

	public PTAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new utilities(driver);

	}

	/// -------- ADD FUNDS BUTTON -------- IRIS
	@FindBy(xpath = "//a[ contains (text(), 'Add Funds') and @class=' waves-effect']")
	WebElement btnAddFunds;

	private WebElement getbtnAddFunds() {
		return btnAddFunds;
	}

	public void clickBtnAddFunds() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(40), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getbtnAddFunds().click();

		System.out.println("Clicking Add Funds button...");
	}
	// --------------------------------------------

	/// -------- SELECT STRIPE RADIOBUTTON -------- IRIS
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
	// --------------------------------------------

	/// -------- ENTER AMOUNT INPUT -------- IRIS
	@FindBy(name = "price")
	WebElement inputPrice;

	private WebElement getPriceInput() {
		return inputPrice;
	}

	public void enterPrice(String Price) {
		getPriceInput().clear();
		System.out.println("Entering price ...");
		getPriceInput().sendKeys(Price);
	}
	// --------------------------------------------

	/// -------- CLICK PAY NOW BUTTON -------- IRIS
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
	// --------------------------------------------

	/// -------- VERIFY PAYMENT SUCCESSFULL -------- IRIS
	@FindBy(xpath = "//*[contains (text(), 'Payment successfull')]")
	WebElement labelSuccessfull;

	private WebElement getLabelSuccessfull() {
		return labelSuccessfull;
	}

	public void PrintPaymentSuccessfulllabel() {
		utility.elementScrollDown(this.getLabelSuccessfull());
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains (text(), 'Payment successfull')]")));

		System.out.println("Hi, Agent.. " + getLabelSuccessfull().getText());
	}
	// --------------------------------------------

	/// -------- LOGOUT BUTTON FROM USER VIEW -------- IRIS
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
	// --------------------------------------------

	/// -------- MY BOOKINGS BUTTON FROM USER VIEW -------- IRIS
	@FindBy(xpath = "(//a[ contains (text(), 'My Bookings')])[2]")
	WebElement MyBookingsButton;

	private WebElement getMyBookingsButton() {
		return MyBookingsButton;
	}

	public void ClickMyBookingsButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[ contains (text(), 'My Bookings')])[2]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getMyBookingsButton().click();
		System.out.println("Clicking My Bookings button ...");
	}
	// --------------------------------------------

	/// -------- VIEW VOUCHER BUTTON -------- IRIS
	@FindBy(xpath = "(//a[ contains (text(), 'View Voucher')])[3]")
	WebElement ViewVoucher;

	private WebElement getViewVoucher() {
		return ViewVoucher;
	}

	public void ClickViewVoucherButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[ contains (text(), 'View Voucher')]")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getViewVoucher().click();
		System.out.println("Clicking View Voucher button ...");
	}
	// --------------------------------------------

	/// -------- LABEL AMOUNT VALIDATION ----------- IRIS
	@FindBy(xpath = "//h4[@class='info__title']")
	WebElement walletBalanceLabel;

	public WebElement getWalletBalancelabel() {
		List<WebElement> listH4 = driver.findElements(By.xpath("//h4[@class='info__title']"));
		WebElement valor = listH4.get(0);
		return valor;
	}

	public String readWalletBalance() {
		if (this.getWalletBalancelabel().getText().isEmpty()) {
			return "0";
		} else {
			String texto = this.getWalletBalancelabel().getText();
			return texto.substring(4);
		}
	}
	// --------------------------------------------

}