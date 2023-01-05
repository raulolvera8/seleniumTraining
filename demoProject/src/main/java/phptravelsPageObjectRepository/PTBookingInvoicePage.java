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
import org.testng.Assert;

import library.utilities;

public class PTBookingInvoicePage {
	WebDriver driver;
	public PTBookingInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	utilities utils = new utilities(driver);

	// ---- Booking status
			@FindBy (xpath="//div[@class='infobox infobox-danger'][contains(.,'Your booking status is ( Pending ) and payment status is stripe ( Unpaid )')]") WebElement paymentStatusStripeLabel;
			@FindBy (xpath="//div[@class='infobox infobox-warning'][contains(.,'Your booking status is ( Pending ) and payment status is pay later ( Unpaid )')]") WebElement paymentStatusPLaterLabel;		
			@FindBy (xpath="//div[@class='infobox infobox-success'][contains(.,'Your booking status is ( Confirmed ) and payment status is stripe ( Paid )')]") WebElement paymentStatusPaidLabel;		

			@FindBy (xpath = "//*[@class='card-body'][contains(.,'Miss Diana Velasquez ')]") WebElement travellerDetails;
			
			@FindBy (xpath = "//*[@class='row my-2']/div") WebElement bookingInvoiceDetails;

			@FindBy (xpath="//li[contains(.,'user@phptravels.com')]") WebElement emailLabel;
			@FindBy (id="form") WebElement proceedPayBtn;
			
			// -- VALIATION BOOKING UNPAID STATUS HOTEL
			public void validationStatusStripe() {

				System.out.println("BOOKING INVOICE UNPAID" + emailLabel.getText());
				if  (emailLabel.getText().contentEquals("Email: user@phptravels.com")) {
					 
					 System.out.println(paymentStatusStripeLabel.getText());
					 System.out.println(bookingInvoiceDetails.getText());
					 System.out.println(emailLabel.getText());
				        } else {
				              Assert.fail( "FAILED" );
				        }	
			}
			// -- VALIATION BOOKING CONFIRMED STATUS HOTEL
			@FindBy (xpath="//*[@class='list-group-item'][contains(.,'Total Price')]") WebElement totalPriceLabel;
			public void validationStatusPaid() {

				System.out.println("BOOKING INVOICE PAID");
				if  (emailLabel.getText().contentEquals("Email: user@phptravels.com")) {
					 
					// System.out.println(paymentStatusPaidLabel.getText());
					 //System.out.println(bookingInvoiceDetails.getText());
					 System.out.println(totalPriceLabel.getText());
				        } else {
				              Assert.fail( "FAILED" );
				        }	
			}
			// -- VALIATION BOOKING STATUS FLIGHT

			public void validationStatusLater() {
				System.out.println("BOOKING INVOICE UNPAID");
				if  (emailLabel.getText().contentEquals("Email: user@phptravels.com")) {
					 System.out.println(paymentStatusPLaterLabel.getText());
					 System.out.println(travellerDetails.getText());
					 System.out.println(emailLabel.getText());
				        } else {
				              Assert.fail( "FAILED" );
				        }	
			}
					
			// Proceed Button
			public WebElement getPrceedPayBtn() {
				return proceedPayBtn;
			}
			public void clickProceedPayBtn() {
				getPrceedPayBtn().click();
					
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@style='width:450px']/img")));
				System.out.println("Stripe Window");
			
			}
}
