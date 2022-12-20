package walmartPageObject;

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

public class SWSignInPage {
	
	WebDriver driver;

	public SWSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ------email text box-----

	@FindBy(id = "email")
	WebElement txtboxEmail;

	public WebElement getTextBoxEmail() {
		return txtboxEmail;
	}

	public void insertEmailTextBox(String email) {
		getTextBoxEmail().sendKeys(email);
	}

	// ------password text box-----

	@FindBy(id = "password")
	WebElement txtboxPassword;

	public WebElement getTextBoxPassword() {
		return txtboxPassword;
	}

	public void insertPasswordTextBox(String password) {
		getTextBoxPassword().sendKeys(password);
	}

	// ------Iniciar sesión button-----

	@FindBy(xpath = "//button[@data-automation-id='formSubmit']")
	WebElement BtnSignIn;

	public WebElement getSignInButton() {
		return BtnSignIn;
	}

	public void clickSignInButton() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()= 'Iniciar sesión' and not(@disable)]" )));
		
		
		getSignInButton().click();
		System.out.println("Click Sign In button...");

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(3));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Hola, ')]")));
	}

}
