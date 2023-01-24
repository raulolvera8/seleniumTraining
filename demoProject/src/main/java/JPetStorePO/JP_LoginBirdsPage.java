package JPetStorePO;

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

public class JP_LoginBirdsPage {
	WebDriver driver;

	public JP_LoginBirdsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@name='username']")
	WebElement userNameBird;

	// ------FLYING FROM
	public WebElement getUserNameBird() {
		return userNameBird;
	}

	public void writeUserNameBird(String userNameBird) {
		getUserNameBird().sendKeys(userNameBird);

		
	}
	
	@FindBy(xpath = "//*[@name='password']")
	WebElement clearPassword;

    public WebElement getClearPassword() {
		return clearPassword;
	}

	public void ClearPassword() {
		
		getClearPassword().clear();
		
	
	}
	
	
	
	@FindBy(xpath = "//*[@name='password']")
	WebElement userPasswordBird;

	public WebElement getPasswordBird() {
		return userPasswordBird;
	}

	public void writePasswordBird(String passwordBird) {
		getPasswordBird().sendKeys(passwordBird);


	}
	
	@FindBy(xpath = "//*[@name='signon']")
	WebElement loginButton;

    public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickLoginButton() {
		
		getLoginButton().click();
		
		
		 
		 
	}
	



	
	
	
	
	
	
	


}
