package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath = "//div[@id='toursmodule']/nav[@id='drawerAccordionPages']/a[@data-bs-target='#Tours']")
	WebElement ToursModuleNestedBtn;

	public WebElement getToursModuleNestedBtn() {
		return ToursModuleNestedBtn;
	}

	public void clickToursModuleNestedBtn() {

		getToursModuleNestedBtn().click();
		System.out.println("Tours nested button module clicked and expanded...");

	}

	// ----- Tours Module nested > Tours > Manage Tours click
	// ---------------------------------------
	@FindBy(xpath = "//div[@id='Tours']/nav/a[1]")
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

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tourname']")));

		System.out.println("Add Tour button clicked. The user is in Add Tour page...");

	}

	// ################# END OF SUPPLIER TOURS MANAGEMENT PAGE SECTION
	// #################################

	// ################# SUPPLIER ADD TOUR PAGE SECTION
	// #################################

	@FindBy(xpath = "//input[@name='tourname']")
	WebElement TourNameTxt;

	public WebElement getTourNameTxt() {
		return TourNameTxt;
	}

	public void insertTourNameTxt(String TourName) {
		getTourNameTxt().sendKeys(TourName);
		System.out.println("Tour name has been inserted. Value = " + TourName);
	}

	@FindBy(xpath = "//html/body[@contenteditable='true']")
	WebElement TourDescTxt;

	public WebElement getTourDescTxt() {
		return TourDescTxt;
	}

	public void insertTourDescTxt(String TourDesc) {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, tourdesc']"));
		driver.switchTo().frame(iframe);
		getTourDescTxt().sendKeys(TourDesc);
		driver.switchTo().defaultContent();
		System.out.println("Tour description has been inserted. Value = " + TourDesc);
	}

	@FindBy(xpath = "//table//input[@name='maxadult']")
	WebElement AdultQtyTxt;

	public WebElement getAdultQtyTxt() {
		return AdultQtyTxt;
	}

	public void insertAdultQtyTxt(String AdultQty) {
		getAdultQtyTxt().sendKeys(AdultQty);
		System.out.println("Adult quantity value has been inserted. Value = " + AdultQty);
	}

	@FindBy(xpath = "//table//input[@name='adultprice']")
	WebElement AdultPriceTxt;

	public WebElement getAdultPriceTxt() {
		return AdultPriceTxt;
	}

	public void insertAdultPriceTxt(String AdultPrice) {
		getAdultPriceTxt().sendKeys(AdultPrice);
		System.out.println("Adult Price value has been inserted. Value = " + AdultPrice);
	}

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement LocationTourTxt;

	public WebElement getLocationTourTxt() {
		return LocationTourTxt;
	}

	public void insertLocationTourTxt(String LocationTour) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_locationlist1']/a"), "class",
				"select2-choice select2-default"));

		WebElement activateTxt = driver.findElement(By.xpath("//div[@id='s2id_locationlist1']/a"));
		
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(activateTxt).click().build();
		 * System.out.println("Actions class method Executed?");
		 * getLocationTourTxt().sendKeys(LocationTour);
		 * getLocationTourTxt().sendKeys(Keys.ENTER);
		 * System.out.println("The tour's location value has been inserted. Value = " +
		 * LocationTour);
		 */
		
	}

	// ################# SUPPLIER ADD TOUR PAGE SECTION
	// #################################

}
