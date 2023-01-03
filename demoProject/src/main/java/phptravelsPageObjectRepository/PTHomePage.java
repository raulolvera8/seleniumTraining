package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
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
	// ------------- SELECT LANGUAGE  ---------------------------------------
	@FindBy (id="languages") WebElement languagesDropDownList;
	public WebElement getlanguagesDropDownList() {
		return languagesDropDownList;
	}
	public void clickLanguageDropDownlist() {
		getlanguagesDropDownList().click();
	}
	public void clickLanguage() {
		List <WebElement> listLanguage = driver.findElements(By.xpath("//*[@class='dropdown-menu show']/li"));
		listLanguage.get(8).click();
		
	}
	/// ----Account Button-----
	@FindBy(id = "ACCOUNT")
	WebElement btnAccount;

	public WebElement getBtnAccount() {
		return btnAccount;
	}

	public void clickBtnAccount() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(2));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACCOUNT")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style", "display: none;"));

		getBtnAccount().click();

		System.out.println("Clicking account button...");

	}

	/// -----Customer login----- Diana
	@FindBy(xpath = "//a[ contains (text(), 'Customer Login' ) ]")
	WebElement customerLoginBtn;

	public WebElement getCustomerLogBtn() {
		return customerLoginBtn;
	}

	public void clickCustomerLoginbtn() {
	
		getCustomerLogBtn().click();
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.id("preloader"), "style", "display: none;"));

	}

	// ------Agent login -------- Iris
	@FindBy(xpath = "//a[ contains (text(), 'Agents Login' ) ]")
	WebElement agentLoginBtn;

	public WebElement getAgentLogBtn() {
		return agentLoginBtn;
	}

	public void clickAgentLoginbtn() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[ contains (text(), 'Agents Login' ) ]")));

		getAgentLogBtn().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@name='email' and @type='text']")));

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

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@name='email' and @type='text']")));

		System.out.println("Supplier buttton role has been clicked...");

	}

}
