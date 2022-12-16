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
public void msgValidation() {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
			.withTimeout(Duration.ofSeconds(60))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(ElementNotInteractableException.class);
	
	wait.until(ExpectedConditions.attributeToBeNotEmpty(numberLabel, "innerHTML"));

	 if  (getLabel().getAttribute("innerHTML").contentEquals("Thank you for buying with Advantage")) {
		 
		 System.out.println("--" + getLabel().getAttribute("innerHTML"));
		
	        } else {
	              Assert.fail( "FAILED" );
	        }	
}

//-----------------------order number//label[contains(text(),'9866')]

@FindBy(id ="orderNumberLabel") WebElement numberLabel;
@FindBy(id ="trackingNumberLabel") WebElement trackingLabel;

public WebElement getNumLabel() {
	return numberLabel;
}
public WebElement getTrackingLabel() {
	return trackingLabel;
}
public void orderTrackinfNumbers() {								
	
	 if  (getNumLabel().getText().contains("9866") && getTrackingLabel().getText().contains("9866") ) {
		 System.out.println("--TRACKING NUMBER AND ORDER NUMBER: ");
		// WebElement num= driver.findElement(By.xpath("//p[@class='roboto-regular ng-binding']"));
		 //System.out.println("--number label: " + num.getText());

		 System.out.println("Order number: " +  getNumLabel().getText());
		 System.out.println("Tracking number: " +  getTrackingLabel().getText());

	        } else {
	              Assert.fail( "FAILED" );
	        }	
}
	 
}

