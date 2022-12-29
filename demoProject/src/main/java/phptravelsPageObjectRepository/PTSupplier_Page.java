package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
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

	// ----- Tours Module > Tours > Manage Tours click

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

	// ----- Hotels Module click ---------------------------------------
	@FindBy(xpath = "//a[@aria-controls='hotelsmodule']")
	WebElement HotelsModuleBtn;

	public WebElement getHotelsModuleBtn() {
		return HotelsModuleBtn;
	}

	public void clickHotelsModuleBtn() {
		getHotelsModuleBtn().click();
		System.out.println("Hotels module clicked and expanded...");
	}

	// ----- Hotels Module > Hotels click ---------------------------------------
	@FindBy(xpath = "//div[@id='hotelsmodule']/nav[@id='drawerAccordionPages']/a[@data-bs-target='#Hotels']")
	WebElement HotelsModuleNestedBtn;

	public WebElement getHotelsModuleNestedBtn() {
		return HotelsModuleNestedBtn;
	}

	public void clickHotelsModuleNestedBtn() {

		getHotelsModuleNestedBtn().click();
		System.out.println("Hotels nested button module clicked and expanded...");

	}

	// ----- Hotels Module > Hotels > Add Room click

	@FindBy(xpath = "//div[@id='Hotels']/nav/a[text()='Add Room']")
	WebElement AddRoomsBtn;

	public WebElement getAddRoomsBtn() {
		return AddRoomsBtn;
	}

	public void clickAddRoomsBtn() {
		getAddRoomsBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_autogen1']/a"), "class",
				"select2-choice"));

		System.out.println("Add Room nested button clicked. The user is in Add Room page...");
	}
	
	

	// ################# END OF SUPPLIER DASHBOARD PAGE SECTION
	// #################################

	// ################# SUPPLIER TOURS MANAGEMENT PAGE SECTION
	// #################################

	// ------------- +ADD BUTTON --------------------------------------------

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

	// ------------- INSERT TOUR NAME TEXT BOX---------------------------------------
	@FindBy(xpath = "//input[@name='tourname']")
	WebElement TourNameTxt;

	public WebElement getTourNameTxt() {
		return TourNameTxt;
	}

	public void insertTourNameTxt(String TourName) {
		getTourNameTxt().sendKeys(TourName);
		System.out.println("Tour name has been inserted. Value = " + TourName);
	}

	// ------------- INSERT TOUR DESCRIPTION TEXT BOX---------------------------------------
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

	// ------------- INSERT ADULT QUANTITY TEXT BOX---------------------------------------
	@FindBy(xpath = "//table//input[@name='maxadult']")
	WebElement AdultQtyTxt;

	public WebElement getAdultQtyTxt() {
		return AdultQtyTxt;
	}

	public void insertAdultQtyTxt(String AdultQty) {
		getAdultQtyTxt().sendKeys(AdultQty);
		System.out.println("Adult quantity value has been inserted. Value = " + AdultQty);
	}

	// ------------- INSERT ADULTS PRICE TEXT BOX---------------------------------------
	@FindBy(xpath = "//table//input[@name='adultprice']")
	WebElement AdultPriceTxt;

	public WebElement getAdultPriceTxt() {
		return AdultPriceTxt;
	}

	public void insertAdultPriceTxt(String AdultPrice) {
		getAdultPriceTxt().sendKeys(AdultPrice);
		System.out.println("Adult Price value has been inserted. Value = " + AdultPrice);
	}

	// ------------- INSERT TOUR LOCATION ---------------------------------------

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

		// WebElement activateTxt = driver.findElement(By.xpath("//*[@id='s2id_locationlist1']/a/span[2]"));
		// Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800)", "");
		// actions.doubleClick(activateTxt);
		// actions.moveByOffset(687, 920).click();
		// actions.build().perform();
		// activateTxt.click();
		getLocationTourTxt().sendKeys(LocationTour);
		getLocationTourTxt().sendKeys(Keys.ENTER);
		System.out.println("The tour's location value has been inserted. Value = " + LocationTour);
		js.executeScript("window.scrollBy(0, 0)", "");

	}

	// ------------- CLICK IN INCLUSIONS TAB ---------------------------------------
	@FindBy(xpath = "//mwc-tab[@id='INCLUSIONS-tab']")
	WebElement InlcusionsBtn;

	public WebElement getInclusionsBtn() {
		return InlcusionsBtn;
	}

	public void clickInclusionsBtn() {
		getInclusionsBtn().click();
		System.out.println("INLCUSIONS Tab clicked...");

	}

	// ------------- CLICK IN SELECT ALL CHECKBOX---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[1]")
	WebElement SelectAllCheckbox;

	public WebElement getSelectAllCheckbox() {
		return SelectAllCheckbox;

	}

	// VERIFIES IF THE CHECKBOX IS SELECTED, IF TRUE THEN UNSELECTS IT, IF NOT JUST CONTINUES.
	public boolean verifyIsSelected() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@class='pointer']/div[@style='position: relative;'])[1]")));

		if (getSelectAllCheckbox().getAttribute("class").contains("checked"))
			return true;
		else
			return false;
	}

	public void clickSelectAllCheckbox() {

		if (verifyIsSelected() == true) {
			getSelectAllCheckbox().click();
			System.out.println("The checkbox Select all was selected. The checkbox has been unactivated...");
		} else {
			System.out.println("The checkbox Select all is already unselected. No needed to perform any action...");
		}
	}

	// ------------- CLICK IN CAB FACILITIES CHECKBOX ---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[2]")
	WebElement CabFacilitiesChkbox;

	public WebElement getCabFacilitiesChkbox() {
		return CabFacilitiesChkbox;
	}

	public void clickCabFacilitiesChkbox() {
		getCabFacilitiesChkbox().click();
		System.out.println("The checkbox Cab Facilities is now selected...");
	}

	// ------------- CLICK IN LOCAL TAX CHECKBOX---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[3]")
	WebElement LocalTaxChkbox;

	public WebElement getLocalTaxChkbox() {
		return LocalTaxChkbox;
	}

	public void clickLocalTaxChkbox() {
		getLocalTaxChkbox().click();
		System.out.println("The checkbox Local Tax is now selected...");
	}

	// ------------- CLICK IN PLAYGROUND NEARBY CHECKBOX---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[4]")
	WebElement PlaygrndNrbyChkbox;

	public WebElement getPlaygrndNrbyChkbox() {
		return PlaygrndNrbyChkbox;
	}

	public void clickPlaygrndNrbyChkbox() {
		getPlaygrndNrbyChkbox().click();
		System.out.println("The checkbox Playground Nearby is now selected...");
	}

	// ------------- CLICK IN LOCAL GUIDES CHECKBOX---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[8]")
	WebElement LocalGuidesChkbox;

	public WebElement getLocalGuidesChkbox() {
		return LocalGuidesChkbox;
	}

	public void clickLocalGuidesChkbox() {
		getLocalGuidesChkbox().click();
		System.out.println("The checkbox Local Guides is now selected...");
	}

	// ------------- CLICK IN EXCLUSIONS TAB ---------------------------------------
	@FindBy(xpath = "//mwc-tab[@id='EXCLUSIONS-tab']")
	WebElement ExclusionsBtn;

	public WebElement getExclusionsBtn() {
		return ExclusionsBtn;
	}

	public void clickExclusionsBtn() {
		getExclusionsBtn().click();
		System.out.println("EXLUSIONS Tab clicked...");

	}

	// ------------- CLICK IN VISA CHARGE CHECKBOX---------------------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[49]")
	WebElement VisaChargeChkbox;

	public WebElement getVisaChargeChkbox() {
		return VisaChargeChkbox;
	}

	public void clickVisaChargeChkbox() {
		getVisaChargeChkbox().click();
		System.out.println("The checkbox Visa Charges is now selected...");
	}

	// ################# SUPPLIER ADD TOUR PAGE SECTION
	// #################################

	// ################# SUPPLIER ADD TOUR PAGE SECTION
	// #################################

}
