package walmartPageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SWhomePage {
	WebDriver driver;

	public SWhomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//------my account button-----
	@FindBy(xpath = "//div[@class='dn db-hdkp relative']")
	WebElement cuentaBtn;

	public WebElement getCuentaButton() {
		return cuentaBtn;
	}

	public void clickCuentaBtn() {
		if (getClosePopPup().isDisplayed()) {
			getBtnclosePopup().click();
			elementoCuenta();
		} else {
			elementoCuenta();
		}
	}

	public void elementoCuenta() {
		getCuentaButton().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@class='absolute bg-white br3 br--bottom left-0 lh-copy mt3 overflow-hidden shadow-1']")));

		Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		waits.until(ExpectedConditions.attributeToBe(By.xpath(
				"//*[@class='dn db-hdkp relative']//*[@class='flex items-center no-underline ph3 white desktop-header-trigger lh-title lh-solid']"),
				"aria-expanded", "true"));

		System.out.println("Clicking Cuenta Button");
	}

//------Log in----
	@FindBy(xpath = "//*[@class='w_AX w_AZ w_Ad db mb3 w-100']")
	WebElement iniciarSesionBtn;

	public WebElement getiniciarSesionBtn() {
		return iniciarSesionBtn;
	}

	public void clickIniciarSesionBtn() {

		getiniciarSesionBtn().click();

		System.out.println("Clicking Iniciar Sesión Button");

	}

///----Close popup ubication
	@FindBy(xpath = "//*[@class='w_GM w_GP']")
	WebElement closePopup;
	@FindBy(xpath = "//*[@class='w_JG']")
	WebElement closeBtnPopPup;

	public WebElement getClosePopPup() {
		return closePopup;
	}

	public WebElement getBtnclosePopup() {
		return closeBtnPopPup;
	}

	public void closePoppup() {

	}
	
	//CLICK ¿QUE QUIERES COMPRAR HOY? BUTTON
	@FindBy(xpath = "//button[@class='flex items-center no-underline ph3 white desktop-header-trigger lh-title lh-solid pointer ba b--transparent bg-transparent sans-serif']")
	WebElement comprarhoyButton;

	private WebElement getcomprarhoyButton() {
		return comprarhoyButton;
	}

	public void clickcomprarhoyButton() {
		System.out.println("Clicking ¿Qué quieres comprar hoy? button");
		getcomprarhoyButton().click();
		
	}


}
