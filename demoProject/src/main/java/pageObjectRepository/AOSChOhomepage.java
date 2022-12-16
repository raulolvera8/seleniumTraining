package pageObjectRepositor;

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

public class AOSChOhomepage {
	WebDriver driver;
public AOSChOhomepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//user menu elements

	@FindBy (id="menuUser") WebElement userButton;
	
	private WebElement getUserButton() {
		return userButton;
	}
	
	public void clickUserButton() {
		System.out.println("Click user button");
		getUserButton().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(18))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='PopUp']"), "style", "display: block;"));
		
				
				
	}
	
	//elements from login popup
		@FindBy (name="username") WebElement usernameInput;
		
		private WebElement getUserNameInput() {
			return usernameInput;
		}
		
		public void enterUsernameInput( String username) {
			
			System.out.println("Entering username...");
			getUserNameInput().sendKeys(username);
		}

		
		@FindBy (name = "password" )WebElement passwordInput;
		
		private WebElement getPasswordInput() {
			return passwordInput;
		}
		
		public void enterPasswordInput(String password) {
			System.out.println("Entering password...");
			getPasswordInput().sendKeys(password);
			
		}
		
		
		@FindBy (id= "sign_in_btnundefined") WebElement signinButton;
		
		private WebElement getSignInButton() {
			return signinButton;
		}
		
		
		public void clickSignInButton() {
			
			WebDriverWait waitElement = new WebDriverWait (driver,Duration.ofSeconds(6),Duration.ofSeconds(3));
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SIGN IN']")));
			
			System.out.println("Click Sign In button...");
			getSignInButton().click();
			
			//wait for pop up disappears
					WebDriverWait waitPopUp= new WebDriverWait (driver,Duration.ofSeconds(15),Duration.ofSeconds(3));
					waitPopUp.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='PopUp']"), "style", "display: none;"));
		}
		
		//---SELECT ITEM
		@FindBy(id="speakersImg") WebElement categorie;
		public WebElement getCategorie() {
			return categorie;
		}
		public void selectCategorie() {
			getCategorie().click();
			Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3))
					.ignoring(ElementNotInteractableException.class);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=' Colorful style meets serious sound']")));

			Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver)
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3))
					.ignoring(ElementNotInteractableException.class);
			
			waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style", "display: none; opacity: 0;"));
			
			System.out.println("DONE");
		}
		
}
