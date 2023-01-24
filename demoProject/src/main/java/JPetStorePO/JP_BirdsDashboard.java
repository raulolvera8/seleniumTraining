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

public class JP_BirdsDashboard {
	WebDriver Driver;

	public JP_BirdsDashboard(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}



	@FindBy(xpath ="//*[@href='/actions/Catalog.action?viewProduct=&productId=AV-CB-01']")
	WebElement selectBird;

public WebElement getSelectBird() {
		return selectBird;
	}

	public void clickSelectBird() {
		
		getSelectBird().click();
	}





	@FindBy(xpath = "//*[text()='Amazon Parrot']")
	WebElement selectedBird;

	private WebElement getSelectedBird() {
		return selectedBird;
	}

	public void VerifySelectedBird() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.Driver).withTimeout(Duration.ofSeconds(60))
		.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		getSelectedBird().isDisplayed();
		
		for (String winHandle : Driver.getWindowHandles()) {
			Driver.switchTo().window(winHandle);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Amazon Parrot']")));

		System.out.println("Bird selected is: " + getSelectedBird().getText());
	}


}