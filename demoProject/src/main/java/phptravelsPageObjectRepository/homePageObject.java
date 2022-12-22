package phptravelsPageObjectRepository;

import java.time.Duration;
<<<<<<< HEAD
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
=======

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
>>>>>>> b7680ff254da4cbc59384a24eccfc9a5205b460b
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.WebDriverWait;
>>>>>>> b7680ff254da4cbc59384a24eccfc9a5205b460b

public class homePageObject {
	WebDriver driver;

	public homePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// ----Account Button-----
	@FindBy(id = "ACCOUNT")
	WebElement btnAccount;

	public WebElement getBtnAccount() {
		return btnAccount;
	}

	public void clickBtnAccount() {
		getBtnAccount().click();

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCOUNT")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
				"display: none; opacity: 0;"));

		System.out.println("Clicking account button...");

	}

	/// -----Customer login-----
	@FindBy(xpath = "//a[ contains (text(), 'Customer Login' ) ]")
	WebElement customerLoginBtn;

	public WebElement getCustomerLogBtn() {
		return customerLoginBtn;
	}

	public void clickCustomerLoginbtn() {
		getCustomerLogBtn().click();
	}

	// ------Agent login -------- Iris
	@FindBy(xpath = "//a[ contains (text(), 'Agent Login' ) ]")
	WebElement agentLoginBtn;

	public WebElement getAgentLogBtn() {
		return agentLoginBtn;
	}

	public void clickAgentLoginbtn() {
		getAgentLogBtn().click();
		System.out.println("Login Agent Account...");
	}
	
	/// -----Supplier login----- Elías Lara.
	
	@FindBy(xpath = "//a[text()='Supplier Login']")
	WebElement SupplierLoginBtn;
	
	public WebElement getSupplierLoginBtn() {
		return SupplierLoginBtn;
	}
	
	public void clickSupplierLoginBtn() {
		
		getSupplierLoginBtn().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email' and not(@id='resetemail')]")));
		
		System.out.println("Supplier Login button has been clicked. The user is in the proper Login page...");
	}

	// ELEMENTS FROM LOGIN FORM ------ Iris
	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement emailInput;

	private WebElement getEmailInput() {
		return emailInput;
	}

	public void enterUsernameInput(String email) {
		System.out.println("Entering email...");
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
}
