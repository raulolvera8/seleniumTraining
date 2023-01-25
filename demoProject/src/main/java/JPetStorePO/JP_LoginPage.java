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

public class JP_LoginPage {
	WebDriver driver;

	public JP_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@name='username']")
	WebElement userName;

	// ------FLYING FROM
	public WebElement getUserName() {
		return userName;
	}

	public void writeUserName(String userName) {
		getUserName().sendKeys(userName);

		
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
	WebElement userPassword;

	public WebElement getPassword() {
		return userPassword;
	}

	public void writePassword(String password) {
		getPassword().sendKeys(password);


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
