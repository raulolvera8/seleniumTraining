package phptravelsPageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PTBookingInvoicePage {
	WebDriver driver;
	public PTBookingInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// ---- Booking status
			@FindBy (xpath="//div[@class='infobox infobox-danger'][contains(.,'Your booking status is ( Pending ) and payment status is stripe ( Unpaid )')]") WebElement paymentStatusStripe;
			@FindBy (xpath="//div[@class='infobox infobox-warning'][contains(.,'Your booking status is ( Pending ) and payment status is pay later ( Unpaid )')]") WebElement paymentStatusPLater;		
			@FindBy (xpath = "//*[@class='card-body'][contains(.,'Miss Diana Velasquez ')]") WebElement travellerDetails;
			
			@FindBy (xpath = "//*[@class='row my-2']/div") WebElement bookingInvoiceDetails;

			@FindBy (xpath="//li[contains(.,'user@phptravels.com')]") WebElement reservationNumber;
			@FindBy (id="form") WebElement proceedPayBtn;
			// -- VALIATION BOOKING STATUS
			public void validationStatusStripe() {
				System.out.println("BOOKING INVOICE WINDOW");
				if  (reservationNumber.getText().contentEquals("Email: user@phptravels.com")) {
					 System.out.println(paymentStatusStripe.getText());
					 System.out.println(bookingInvoiceDetails.getText());
					 System.out.println(reservationNumber.getText());
				        } else {
				              Assert.fail( "FAILED" );
				        }	
			}
			
			public void validationStatusLater() {
				System.out.println("BOOKING INVOICE WINDOW");
				if  (reservationNumber.getText().contentEquals("Email: user@phptravels.com")) {
					 System.out.println(paymentStatusPLater.getText());
					 System.out.println(travellerDetails.getText());
					 System.out.println(reservationNumber.getText());
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
			}
}
