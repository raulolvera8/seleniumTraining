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

public class PTDashboardPage_Supplier {

	WebDriver driver;

	public PTDashboardPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ******************************************************
	// Objective: CLICK IN TOURS MODULE BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//a[@aria-controls='toursmodule']")
	WebElement ToursModuleBtn;

	public WebElement getToursModuleBtn() {
		return ToursModuleBtn;
	}

	public void clickToursModuleBtn() {
		getToursModuleBtn().click();
		System.out.println("Tours module clicked and expanded...");
	}

	// ******************************************************
	// Objective: CLICK IN TOURS MODULE BUTTON > TOURS BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='toursmodule']/nav[@id='drawerAccordionPages']/a[@data-bs-target='#Tours']")
	WebElement ToursModuleNestedBtn;

	public WebElement getToursModuleNestedBtn() {
		return ToursModuleNestedBtn;
	}

	public void clickToursModuleNestedBtn() {

		getToursModuleNestedBtn().click();
		System.out.println("Tours nested button module clicked and expanded...");

	}

	// ******************************************************
	// Objective: CLICK IN TOURS MODULE BUTTON > TOURS BUTTON > MANAGE TOURS BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='Tours']/nav/a[text()='Manage Tours']")
	WebElement ManageToursBtn;

	public WebElement getManageToursBtn() {
		return ManageToursBtn;
	}

	public void clickManageToursBtn() {
		getManageToursBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		System.out.println("Manage tours nested button clicked. The user is in Manage tours page...");
	}

	// ******************************************************
	// Objective: CLICK IN HOTELS MODULE BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//a[@aria-controls='hotelsmodule']")
	WebElement HotelsModuleBtn;

	public WebElement getHotelsModuleBtn() {
		return HotelsModuleBtn;
	}

	public void clickHotelsModuleBtn() {
		getHotelsModuleBtn().click();
		System.out.println("Hotels module clicked and expanded...");
	}

	// ******************************************************
	// Objective: CLICK IN HOTELS MODULE BUTTON > HOTELS BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='hotelsmodule']/nav[@id='drawerAccordionPages']/a[@data-bs-target='#Hotels']")
	WebElement HotelsModuleNestedBtn;

	public WebElement getHotelsModuleNestedBtn() {
		return HotelsModuleNestedBtn;
	}

	public void clickHotelsModuleNestedBtn() {

		getHotelsModuleNestedBtn().click();
		System.out.println("Hotels nested button module clicked and expanded...");

	}

	// ******************************************************
	// Objective: CLICK IN HOTELS MODULE BUTTON > HOTELS BUTTON > ADD ROOM BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='Hotels']/nav/a[text()='Add Room']")
	WebElement AddRoomsBtn;

	public WebElement getAddRoomsBtn() {
		return AddRoomsBtn;
	}

	public void clickAddRoomsBtn() {
		getAddRoomsBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_autogen1']/a"), "class", "select2-choice"));

		System.out.println("Add Room nested button clicked. The user is in Add Room page...");
	}

	// ******************************************************
	// Objective: CLICK IN DASHBOARD BUTTON FOR SUPPLIER ROLE.
	// Author: Elías Lara.
	// Date of creation/adding: 01 18 23
	// *******************************************************

	@FindBy(xpath = "//div[text()='Dashboard']")
	WebElement dashboardBtn;

	public WebElement getDashboardBtn() {
		return dashboardBtn;
	}

	public void clickDashboardBtn() {
		getDashboardBtn().click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1[text()='Dashboard']")));
		System.out.println("Dashboard main button has been clicked. Dashboard page is displayed...");
	}

	// ******************************************************
	// Objective: CLICK IN PROFILE BUTTON FOR SUPPLIER ROLE.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//button[@id='dropdownMenuProfile']")
	WebElement profileBtn;

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public void clickProfileBtn() {
		getProfileBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]//i[text()='logout']")));

		System.out.println("Profile button has been clicked. Dropdown is displayed...");
	}

	// ******************************************************
	// Objective: CLICK IN LOGOUT OPTION FOR SUPPLIER ROLE.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	@FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//i[text()='logout']")
	WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void clickLogoutBtn() {
		getLogoutBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@name='email' and @type='text']")));

		System.out.println("The user is logged off as expected.");
	}

	/// CLICK PENDING BOOKING---- JUAN
	@FindBy(xpath = "//*[@class='icon-circle bg-warning text-white']")
	WebElement pendingBooking;

	public WebElement getPendingBooking() {
		return pendingBooking;
	}

	public void clickPendingBookingBtn() {
		getPendingBooking().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dashboard']")));

		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
		wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='bodyload']"), "style", "display: none;"));

		System.out.println("CLICK IN PENDING BOOKING");
	}

	// CLICK BOOKING STATUS

	@FindBy(xpath = "//select[@id='booking_status']")
	WebElement bookingStatus;

	public WebElement getBookingStatus() {
		return bookingStatus;
	}

	public void clickBookingStatus() {
		getBookingStatus().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dashboard']")));

		System.out.println("CLICK IN BOOKING STATUS");
	}

	// SELECT VALUE CANCELL
	@FindBy(xpath = "//*[@value='64,hotels,Cancelled']")
	WebElement statusCancel;

	public WebElement getStatusCancel() {
		return statusCancel;
	}

	public void clickStatusCancel() {
		getStatusCancel().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dashboard']")));

		System.out.println("CLICK IN STATUS CANCEL");
	}

	// CLICK CANCEL BOOKING
	@FindBy(xpath = "//*[@class='icon-circle bg-danger text-white']")
	WebElement cancelBooking;

	public WebElement getCancelBooking() {
		return cancelBooking;
	}

	public void clickCancelBookingBtn() {
		getCancelBooking().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dashboard']")));

		System.out.println("CLICK IN CANCEL BOOKING");
	}

	// VERIFY THE ID

	@FindBy(xpath = "//*[text()='64']")
	WebElement verifyId;

	private WebElement verifyId() {
		return verifyId;
	}

	public void VerifyId() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);

		verifyId().isDisplayed();

		System.out.println("THE ID NUMBER IS : " + verifyId().getText());

	}

}
