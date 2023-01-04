package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
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

public class PTHotelBookingPage {
	WebDriver driver;
	public PTHotelBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Filling form information
	@FindBy (name="firstname_1") WebElement firstNametb;
	@FindBy (name="lastname_1") WebElement lastNametb;
	@FindBy(name="title_1") WebElement DropDowntitle;
	@FindBy(id="gateway_stripe") WebElement payWithStripeRadioBtn;
	@FindBy (xpath="//*[@class='custom-checkbox']") WebElement termsAndConditionsCheckBox;
	@FindBy (id="booking") WebElement bookingBtn;
	// First Name
	public WebElement getFirstNametb() {
		return firstNametb;
	}
	public void writefirstNametb(String firstName) {			
		getFirstNametb().sendKeys(firstName);
	}
	public WebElement getlastNametb() {
		return lastNametb;
	}
	// Last Name
	public void writelastNametb(String lastName) {			
		getlastNametb().sendKeys(lastName);
	}
	// Title
	public WebElement getDropDowntitle() {
		return DropDowntitle;
	}
	public void selectDropDowntitle() {
		getDropDowntitle().click();
	}
	
	public void selectValueTitle() {	
		List <WebElement> listTitle = driver.findElements(By.xpath("//*[@name='title_1']//option"));
		listTitle.get(1).click();
	}
	// Pay with stripe  
	public WebElement getPayStripe() {
		return payWithStripeRadioBtn;
	}
	public void selectPayStripeRadioBtn() {
		getPayStripe().click();
	}
	// ACCEPT TERMS AND CONDITIONS  termsAndConditionsCheckBoxbookingBtn
			public WebElement getCheckboxTerms() {
				return termsAndConditionsCheckBox;
			}
			public void selectCheckBoxTerms() {
				getCheckboxTerms().click();
			}
			// CONFIRM BOOKING BTN
			public WebElement getBookingBtn() {
				return bookingBtn;
			}

			public void clickConfirmBookingBtn() {
				getBookingBtn().click();
				Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
				wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='preloader']"), "style",
						"display: none;"));
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='title'][contains(text(), 'Your Personal Information')]")));
				System.out.println("HOTEL BOOKING WINDOW");
			}
}
