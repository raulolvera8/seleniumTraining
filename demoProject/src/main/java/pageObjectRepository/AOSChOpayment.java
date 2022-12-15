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

public class AOSChOpayment {
//next_btn
	WebDriver driver;

	public AOSChOpayment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ------Next button shipping details
	@FindBy(id = "next_btn")
	WebElement nextBtn;

	public WebElement getNextbtn() {
		return nextBtn;
	}

	public void clickNextbtn() {
		getNextbtn().click();
		System.out.println("Next to pay now");
	}

	/// ---- Pay now button
	@FindBy(id = "pay_now_btn_MasterCredit")
	WebElement payNowBtn;

	public WebElement getPayNowBtn() {
		return payNowBtn;
	}

	public void clicPayNowBtn() {
		// WebElement number= driver.findElement(By.xpath("//*[@class='roboto-regular
		// ng-binding']//*[@class='ng-binding']"));
		getPayNowBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));

		Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style",
				"display: none; opacity: 0;"));
		System.out.println("you have paid ");

		// System.out.println(number.getText());

	}

	@FindBy(id = "next_btn")
	WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}

	public void clickNextButton() throws InterruptedException {
		System.out.println("Clicking the next button in Order Payment Page...");
		getNextButton().click();

		Thread.sleep(3000);

	}

	@FindBy(id = "pay_now_btn_SAFEPAY")
	WebElement payNowButton;

	public WebElement getPayNowButton() {
		return payNowButton;
	}

	public void clickPayNowButton() {
		System.out.println("Click in Pay Now button in Order Payment Page...");
		getPayNowButton().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(18))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeContains(
				By.xpath("//span[contains(text(),'Thank you for buying with Advantage')]"), "innerHTML",
				"Thank you for buying with Advantage"));
	}

}
