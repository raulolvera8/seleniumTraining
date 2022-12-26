package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//##################### CLASS AND CODE CREATED BY ELIAS LARA.

public class PTSupplier_Page {

	WebDriver driver;

	public PTSupplier_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ################# SUPPLIER DASHBOARD PAGE SECTION
	// #################################

	// ----- Tours Module click ---------------------------------------

	@FindBy(xpath = "//a[@aria-controls='toursmodule']")
	WebElement ToursModuleBtn;

	public WebElement getToursModuleBtn() {
		return ToursModuleBtn;
	}

	public void clickToursModuleBtn() {
		getToursModuleBtn().click();
		System.out.println("Tours module clicked and expanded...");
	}

	// ----- Tours Module > Tours click ---------------------------------------
	@FindBy(xpath = "//a[@data-bx-target='#Tours']")
	WebElement ToursModuleNestedBtn;

	public WebElement getToursModuleNestedBtn() {
		return ToursModuleNestedBtn;
	}

	public void clickToursModuleNestedBtn() {
		getToursModuleBtn().click();
		System.out.println("Tours module clicked and expanded...");
	}

	// ----- Tours Module nested > Tours > Manage Tours click
	// ---------------------------------------
	@FindBy(xpath = "//div[@id='Tours']/nav/a[1]")
	WebElement ManageToursBtn;

	public WebElement getManageToursBtn() {
		return ManageToursBtn;
	}

	public void clickTManageToursBtn() {
		getToursModuleBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		System.out.println("Supplier Login button has been clicked. The user is in dashboard page...");
	}

	// ################# END OF SUPPLIER DASHBOARD PAGE SECTION
	// #################################

	// ################# SUPPLIER TOURS MANAGEMENT PAGE SECTION
	// #################################
	@FindBy(xpath = "//button[@type='submit']")
	WebElement AddTourBtn;

	public WebElement getAddTourBtn() {
		return AddTourBtn;
	}

	public void clickAddTourBtn() {
		getAddTourBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tourname']")));

		System.out.println("Add Tour button clicked. The user is in Add Tour page...");

	}

	// ################# END OF SUPPLIER TOURS MANAGEMENT PAGE SECTION
	// #################################

}
