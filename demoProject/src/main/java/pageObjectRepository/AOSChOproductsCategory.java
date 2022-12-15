package pageObjectRepository;

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

public class AOSChOproductsCategory {
	WebDriver driver;

	public AOSChOproductsCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

////----SELECT ITEM-----
	@FindBy(xpath = "//*[@class='cell categoryRight']//li[@class='ng-scope'][1]")
	WebElement item;

	public WebElement getItem() {
		return item;
	}

	public void selectItem() {

		getItem().click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Color:']")));

		Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style",
				"display: none; opacity: 0;"));
		System.out.println("Item  has been selected");

	}
	
	@FindBy (xpath="//a[text()='HP Elite x2 1011 G1 Tablet']/ancestor::li[contains(@ng-repeat, 'productsFilterForCategoriesProduct')]/img") WebElement HPEliteX2Button;
	
	public WebElement getHPEliteX2Button() {
		return HPEliteX2Button;	
	}
	
	public void clickgetHPEliteX2Button() {
		System.out.println("Click on HP Elite X2 tablet button in Products Page...");
		getHPEliteX2Button().click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(18))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("//h2[contains(text(), 'PRODUCT SPECIFICATIONS')]"),"innerHTML" ,"PRODUCT SPECIFICATIONS"));
	}
}
