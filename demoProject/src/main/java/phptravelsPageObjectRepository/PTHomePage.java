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
import org.openqa.selenium.support.ui.WebDriverWait;

public class PTHomePage {
	WebDriver driver;

	public PTHomePage(WebDriver driver) {
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
	
public void clickSupplierLoginbtn() {
		
		getSupplierLoginBtn().click();
				
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@name='email' and @type='text']")));

		System.out.println("Supplier buttton role has been clicked...");

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
