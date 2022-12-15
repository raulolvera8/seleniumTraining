package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AOSMyAccountPage {
	WebDriver driver;
	
	public AOSMyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//*[@href='#/accountDetails']") WebElement editAccountDetailsButton;//
	
	public WebElement geteditAccountDetailsButton() {
		return editAccountDetailsButton;		
	}
	
	public void clickAccountDetailsButton() {
		System.out.println("Click en edit button");
		geteditAccountDetailsButton().click();
		
		
	}



}
