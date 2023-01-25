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
	// XPATH FOR DOGS WINDOW
	@FindBy(xpath="//tr[4]/td[1]") WebElement itemBtn;
	@FindBy (xpath ="//table/tbody/tr[2]/td[5]") WebElement addToCartBtn;
	// ---------- CLICK ITEM -------- DIANA

	public WebElement getItem() {
		return itemBtn;
	}
	public void clickItem() {
			 getItem().click();
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(this.Driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));	
	}
	
	// ------- CLICK ADD TO CART BTN ------ DIANA
	
	public WebElement getAddToCartBtn(){
		return addToCartBtn;
	}
	public void clickAddToCartBtn() {
		getAddToCartBtn().click();
	}
	
	

}
