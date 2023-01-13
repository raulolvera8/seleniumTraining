package phptravelsPageObjectRepository;

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

//########### CLASS AND CODE ADDED BY ELIAS LARA. #########################

public class PTLoginPage {

	WebDriver driver;

	public PTLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ######### ACCEPT COOKIES ########
	@FindBy(id = "cookie_stop")
	WebElement gotitBtn;

	public WebElement getGotItBtn() {
		return gotitBtn;
	}

	public void clickGotItBtn() {
		getGotItBtn().click();
		;
	}
	// ############# SUPPLIER SECTION #######################################

	// ----- SUPPLIER Email text box -----------

	@FindBy(xpath = "//form//input[@name='email' and @type='text']")
	WebElement EmailTxtbox;

	public WebElement getEmailTxtbox() {
		return EmailTxtbox;
	}

	public void setEmailtxtbox(String email) {
		getEmailTxtbox().sendKeys(email);
		System.out.println("Supplier email been inserted. Value is: " + email);
	}

	// ----- SUPPLIER password text box -----------

	@FindBy(xpath = "//input[@name='password']")
	WebElement PasswordTxtbox;

	public WebElement getPasswordTxtbox() {
		return PasswordTxtbox;
	}

	public void setPasswordtxtbox(String password) {
		getPasswordTxtbox().sendKeys(password);
		System.out.println("Supplier email been inserted. Value is: " + password);
	}

	// ----- SUPPLIER login button -----------

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	public WebElement getLoginButton() {
		return loginBtn;
	}

	public void clickLoginBtn() {
		getLoginButton().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));

		System.out.println("Supplier Login button has been clicked. The user is in dashboard page...");
	}

	// ############# END OF SUPPLIER SECTION #######################################

	/// -------------Customer Account-------Diana----/////
	@FindBy(xpath = "//*[@class='form-group']//input")
	WebElement emailTb;
	@FindBy(xpath = "//*[@class='form-group mb-2']//input")
	WebElement passwordTb;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
	WebElement logInBtn;

	public WebElement getEmailTb() {
		return emailTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}

	public void fillEmailTb(String email) {
		getEmailTb().sendKeys(email);
	}

	public void fillPasswordTb(String password) {
		getPasswordTb().sendKeys(password);
	}

	public void clickLoginCustomerBtn() {
		getLogInBtn().click();

	}
	// ############# END OF CUSTOMER SECTION #######################################

	// ELEMENTS FROM LOGIN AGENT ------ IRIS
	@FindBy(xpath = "//input[@name='email' and (@type='email')]")
	WebElement emailInput;

	private WebElement getEmailInput() {
		return emailInput;
	}

	public void enterEmailInput(String email) {
		System.out.println("Entering email...");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email' and (@type='email')]")));

		getEmailInput().sendKeys(email);
	}

	@FindBy(name = "password")
	WebElement passwordInput;

	private WebElement getPasswordInput() {
		return passwordInput;
	}

	public void enterPasswordInput(String password) {
		System.out.println("Entering password...");
		getPasswordInput().sendKeys(password);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;

	private WebElement getLoginButtonAgent() {
		return LoginButton;
	}

	public void clickLoginButtonAgent() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getLoginButtonAgent().click();
	}
	// -------------------------------------------------------------

}
