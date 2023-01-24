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

public class JP_DogsPage {
	WebDriver Driver;

	public JP_DogsPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}
	@FindBy(xpath="//a[text()='K9-PO-02']") WebElement item;
	public WebElement getItem() {
		return item;
	}
	public void clickItem() {
			 getItem().click();
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(this.Driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));	
	}

}
