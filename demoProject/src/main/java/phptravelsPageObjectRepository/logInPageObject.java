package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//########### CLASS AND CODE ADDED BY ELIAS LARA. #########################

public class logInPageObject {

	WebDriver driver;

	public logInPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//############# SUPPLIER SECTION #######################################
	
	// ----- SUPPLIER Email text box -----------

	@FindBy(xpath = "//input[@name='email' and not(@id='resetemail')]")
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
		getEmailTxtbox().sendKeys(password);
		System.out.println("Supplier email been inserted. Value is: " + password);
	}
	
	// ----- SUPPLIER login button -----------
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement loginBtn;
	
	public WebElement getLoginButton() {
		return loginBtn;
	}
	
	public void clickLoginBtn() {
		getLoginButton().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		
		System.out.println("Supplier Login button has been clicked. The user is in dashboard page...");
	}
	
	//############# END OF SUPPLIER SECTION #######################################

}
