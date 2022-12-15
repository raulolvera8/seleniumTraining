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
import org.testng.Assert;

public class AOSChOValidationPayment {
WebDriver driver;
	public AOSChOValidationPayment (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//*[contains(@id,'trackingNumberLabel')]
@FindBy (xpath="//span[contains(text(),'Thank you for buying with Advantage')]") WebElement msgValidation;
public WebElement getLabel() {
	return msgValidation;
}
public void msgValidation() {//*[@id='orderPaymentSuccess']//h2//span"
	Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(60))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(ElementNotInteractableException.class);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
	
	Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(90))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(ElementNotInteractableException.class);
	waits.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style", "display: none; opacity: 0;"));
	
	 if  (getLabel().getAttribute("innerHTML").contentEquals("Thank you for buying with Advantage")) {
		 
		 System.out.println("--" + getLabel().getAttribute("innerHTML"));
		
	        } else {
	              Assert.fail( "FAILED" );
	        }	
}

//-----------------------order number

@FindBy(xpath ="//p[@class='roboto-regular ng-binding']") WebElement numberLabel;


public WebElement getNumLabel() {
	return numberLabel;
}
@FindBy(id="trackingNumberLabel") WebElement trackingNumberLabel;

public WebElement getTrackingNumberLabel() {
	return trackingNumberLabel;
}

@FindBy(id= "orderNumberLabel") WebElement orderNumberLabel;
public WebElement getOrderNumberLabel() {
	return orderNumberLabel;
}

public void orderNumber() {
//	WebElement num= driver.findElement(By.xpath("//label[contains(text(),'9866')]"));
//	 System.out.println("--number label: " + getNumLabel().getAttribute("innerText"));
//	 System.out.println("--number label: " + getNumLabel().getText());
//	 System.out.println("--number label: " + num.getText());

//	 if  (getNumLabel().getText().contains("9866")) {
//		 System.out.println("--TRACKING NUMBER AND ORDER NUMBER: ");
//
//		 System.out.println(getNumLabel().getText());
//		
//	        } else {
//	              Assert.fail( "FAILED" );
//	        }	

	Wait<WebDriver> waits = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(40))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(ElementNotInteractableException.class);
	waits.until(ExpectedConditions.attributeToBeNotEmpty(orderNumberLabel,"innerHTML"));
	
	System.out.println("Tracking:" + getTrackingNumberLabel().getAttribute("innerHTML"));
	
	System.out.println("Order:" + getOrderNumberLabel().getAttribute("innerHTML"));
	
	if (Integer.parseInt(getTrackingNumberLabel().getAttribute("innerHTML"))>0) {
		System.out.println("Valid tracking number");
	}
	
	else {
		 Assert.fail("Invalid tracking number");
	}
}
	 
}

