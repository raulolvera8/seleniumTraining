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
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
////----SELECT ITEM-----
@FindBy (xpath="//*[@class='cell categoryRight']//li[@class='ng-scope'][1]") WebElement item;

public WebElement getItem(){
	return item;
}
public void selectItem() {
			
	getItem().click();
	Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(60))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(ElementNotInteractableException.class);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Color:']")));

	Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(60))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(ElementNotInteractableException.class);
	
	waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style", "display: none; opacity: 0;"));
	System.out.println("Item  has been selected");

}
}
