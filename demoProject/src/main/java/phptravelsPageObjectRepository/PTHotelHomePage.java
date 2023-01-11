package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PTHotelHomePage {
	WebDriver driver;

	public PTHotelHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[@class='owl-stage']/div[position()=6]/*[@class='card-item mb-0']/*[@class='card-body']/h6") WebElement nameHotelLabel;
	//@FindBy (xpath="//*[@class=' waves-effect']/strong[contains(text(),'Islamabad Marriott Hotel')]") WebElement nameHotelLabel;

	public WebElement getNameHotelLabel() {
		return nameHotelLabel;
	}
	public String readNameHotelLabel() {
		String nameHotelLabel= this.getNameHotelLabel().getText();
		return nameHotelLabel;
	}
	public void clickHotelName() {
		getNameHotelLabel().click();
				Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
				"display: none;"));		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sec__title_left left-line']")));			
	
	}
}
