package phptravelsPageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import library.utilities;

//##################### CLASS AND CODE CREATED BY ELIAS LARA.

public class PTAddTourPage_Supplier {

	WebDriver driver;
	utilities utility;
		
	public PTAddTourPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new utilities(driver);
	}

	// ------------- INSERT TOUR NAME TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourname']")
	WebElement TourNameTxt;

	public WebElement getTourNameTxt() {
		return TourNameTxt;
	}

	public void insertTourNameTxt(String tourName) {
		getTourNameTxt().sendKeys(tourName);
		System.out.println("Tour name has been inserted. Value = " + tourName);
	}
	
	
	// ------------- INSERT TOUR DESCRIPTION TEXTBOX ---------
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

	// ------------- INSERT ADULT QUANTITY TEXTBOX -----------------
	@FindBy(xpath = "//table//input[@name='maxadult']")
	WebElement AdultQtyTxt;

	public WebElement getAdultQtyTxt() {
		return AdultQtyTxt;
	}

	public void insertAdultQtyTxt(String AdultQty) {
		getAdultQtyTxt().sendKeys(AdultQty);
		System.out.println("Adult quantity value has been inserted. Value = " + AdultQty);
	}

	// ------------- INSERT ADULTS PRICE TEXTBOX -----------------
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

		utility.ScrollDown(driver, "0", "750");

		WebElement activateTxt = driver.findElement(By.xpath("//*[@id='s2id_locationlist1']/a"));
		activateTxt.click();

		getLocationTourTxt().sendKeys(LocationTour);
		
		utility.waiting();
		
		WebElement optionSuggested = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li"));
		optionSuggested.click();
		System.out.println("The tour's location value has been inserted. Value = " + LocationTour);
		utility.ScrollDown(driver, "0", "0");

	}

	// ------------- CLICK IN INCLUSIONS TAB ---------------------------------------
	@FindBy(xpath = "//div[@id='materialTabBarJsDemo']//mwc-tab[@id='INCLUSIONS-tab']")
	WebElement InlcusionsTab;

	public WebElement getInclusionsTab() {
		return InlcusionsTab;
	}

	public void clickInclusionsTab() {
		utility.waiting();
		getInclusionsTab().click();
		System.out.println("INLCUSIONS Tab clicked...");
	}

	// ------------- CLICK IN SELECT ALL CHECKBOX------------------------
	@FindBy(xpath = "//*[@id='INCLUSIONS']/div/div/div[1]/label/div/ins")
	WebElement SelectAllCheckbox;

	public WebElement getSelectAllCheckbox() {
		return SelectAllCheckbox;

	}

	// VERIFIES IF THE CHECKBOX IS SELECTED, IF TRUE THEN UNSELECTS IT, IF NOT JUST
	// CONTINUES.
	public boolean verifyIsSelected() {

		WebElement verifyCheckbox = driver.findElement(By.xpath("//*[@id='INCLUSIONS']/div/div/div[1]/label/div"));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='INCLUSIONS']/div/div/div[1]/label/div/ins")));

		if (verifyCheckbox.getAttribute("class").contains("checked"))
			return true;
		else
			return false;
	}

	public void clickSelectAllCheckbox() {

		if (verifyIsSelected() == false) {
			utility.clickElementJavascript("//*[@id='INCLUSIONS']/div/div/div[1]/label/div/ins");
			utility.waiting();
			utility.clickElementJavascript("//*[@id='INCLUSIONS']/div/div/div[1]/label/div/ins");
			System.out.println("The checkbox Select all was unselected. The checkbox has been activated and unactivated...");
		} else {
			System.out.println("The checkbox Select all is already unselected. No needed to perform any action...");
		}
	}

	// ------------- CLICK IN CAB FACILITIES CHECKBOX -----------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[2]")
	WebElement CabFacilitiesChkbox;

	public WebElement getCabFacilitiesChkbox() {
		return CabFacilitiesChkbox;
	}

	public void clickCabFacilitiesChkbox() {
		getCabFacilitiesChkbox().click();
		System.out.println("The checkbox Cab Facilities is now selected...");
	}

	// ------------- CLICK IN LOCAL TAX CHECKBOX-------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[3]")
	WebElement LocalTaxChkbox;

	public WebElement getLocalTaxChkbox() {
		return LocalTaxChkbox;
	}

	public void clickLocalTaxChkbox() {
		getLocalTaxChkbox().click();
		System.out.println("The checkbox Local Tax is now selected...");
	}

	// ------------- CLICK IN PLAYGROUND NEARBY CHECKBOX----------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[4]")
	WebElement PlaygrndNrbyChkbox;

	public WebElement getPlaygrndNrbyChkbox() {
		return PlaygrndNrbyChkbox;
	}

	public void clickPlaygrndNrbyChkbox() {
		getPlaygrndNrbyChkbox().click();
		System.out.println("The checkbox Playground Nearby is now selected...");
	}

	// ------------- CLICK IN LOCAL GUIDES CHECKBOX---------------------
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
	@FindBy(xpath = "//div[@id='materialTabBarJsDemo']//mwc-tab[@id='EXCLUSIONS-tab']")
	WebElement ExclusionsTab;

	public WebElement getExclusionsTab() {
		return ExclusionsTab;
	}

	public void clickExclusionsTab() {
		utility.waiting();
		getExclusionsTab().click();
		System.out.println("EXLUSIONS Tab clicked...");

	}

	// ------------- CLICK IN VISA CHARGE CHECKBOX-----------------------------
	@FindBy(xpath = "(//label[@class='pointer']/div[@style='position: relative;'])[49]")
	WebElement VisaChargeChkbox;

	public WebElement getVisaChargeChkbox() {
		return VisaChargeChkbox;
	}

	public void clickVisaChargeChkbox() {
		getVisaChargeChkbox().click();
		System.out.println("The checkbox Visa Charges is now selected...");
	}

	// ------------ META INFO TAB -----------------

	@FindBy(xpath = "//div[@id='materialTabBarJsDemo']//mwc-tab[@id='META_INFO-tab']")
	WebElement MetaInfoTab;

	public WebElement getMetaInfoTab() {
		return MetaInfoTab;
	}

	public void clickMetaInfoTab() {
		utility.waiting();
		getMetaInfoTab().click();
		System.out.println("META INFO Tab clicked...");
	}

	// ------------ META TITLE TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourmetatitle']")
	WebElement MetaTitleTxtbox;

	public WebElement getMetaTitleTxtbox() {
		return MetaTitleTxtbox;
	}

	public void setMetaTitleTxtbox(String metaTitle) {
		getMetaTitleTxtbox().sendKeys(metaTitle);
		System.out.println("META Title inserted. Value = " + metaTitle);
	}

	// ------------ META KEYWORDS TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourkeywords']")
	WebElement MetaKeywordsTxtbox;

	public WebElement getMetaKeywordsTxtbox() {
		return MetaKeywordsTxtbox;
	}

	public void setMetaKeywordsTxtbox(String metaKeywords) {
		getMetaKeywordsTxtbox().sendKeys(metaKeywords);
		System.out.println("META Keywords inserted. Value = " + metaKeywords);
	}

	// ------------ META DESCRIPTION TEXTAREA -----------------

	@FindBy(xpath = "//textarea[@name='tourmetadesc']")
	WebElement MetaDescTxtarea;

	public WebElement getMetaDescTxtarea() {
		return MetaDescTxtarea;
	}

	public void setMetaDescTxtarea(String metaDesc) {
		getMetaDescTxtarea().sendKeys(metaDesc);
		System.out.println("META Description inserted. Value = " + metaDesc);
	}

	// ------------ POLICY TAB -----------------

	@FindBy(xpath = "//div[@id='materialTabBarJsDemo']//mwc-tab[@id='POLICY-tab']")
	WebElement PolicyTab;

	public WebElement getPolicyTab() {
		return PolicyTab;
	}

	public void clickPolicyTab() {
		utility.waiting();
		getPolicyTab().click();
		System.out.println("Policy Tab clicked...");
	}

	// ----------------- PAYMENT OPTIONS TEXTBOX -----------------------------

	@FindBy(xpath = "//li/input[@type='text' and @id='s2id_autogen14']")
	WebElement PaymentOptTxtbox;

	public WebElement getPaymentOptTxtbox() {
		return PaymentOptTxtbox;
	}

	public void setPaymentOptTxtbox(String paymentOpt) {
		getPaymentOptTxtbox().sendKeys(paymentOpt);
		WebElement optionSuggested = driver.findElement(By.xpath("//div[@class='select2-result-label'] "));
		utility.waiting();
		optionSuggested.click();
		System.out.println("Payment option inserted. Value = " + paymentOpt);
	}

	// ----------------- POLICY AND TERMS TEXTAREA ------------------------------

	@FindBy(xpath = "//textarea[@name='tourprivacy']")
	WebElement PolicyAndTermsTxtarea;

	public WebElement getPolicyAndTermsTxtarea() {
		return PolicyAndTermsTxtarea;
	}

	public void setPolicyAndTermsTxtarea(String PolicyAndTerms) {
		getPolicyAndTermsTxtarea().sendKeys(PolicyAndTerms);
		System.out.println("Policy and terms inserted. Value = " + PolicyAndTerms);
	}

	// ------------ CONTACT TAB -----------------

	@FindBy(xpath = "//div[@id='materialTabBarJsDemo']//mwc-tab[@id='CONTACT-tab']")
	WebElement ContactTab;

	public WebElement getContactTab() {
		return ContactTab;
	}

	public void clickContactTab() {
		Actions builder = new Actions(driver);   
		builder.moveToElement(ContactTab, 1, 1).click().build().perform();
		System.out.println("Contact Tab clicked...");
	}

	// ------------ TOURS OPERATOR'S EMAIL TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='touremail']")
	WebElement TourEmailTxtbox;

	public WebElement getTourEmailTxtbox() {
		return TourEmailTxtbox;
	}

	public void setTourEmailTxtbox(String tourEmail) {
		getTourEmailTxtbox().sendKeys(tourEmail);
		System.out.println("Operator's email inserted. Value = " + tourEmail);
	}

	// ------------ OPERATOR'S WEBSITE TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourwebsite']")
	WebElement TourWebsiteTxtbox;

	public WebElement getTourWebsiteTxtbox() {
		return TourWebsiteTxtbox;
	}

	public void setTourWebsiteTxtbox(String tourWebsite) {
		getTourWebsiteTxtbox().sendKeys(tourWebsite);
		System.out.println("Operator's website inserted. Value = " + tourWebsite);
	}

	// ------------ OPERATOR'S PHONE TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourphone']")
	WebElement TourPhoneTxtbox;

	public WebElement getTourPhoneTxtbox() {
		return TourPhoneTxtbox;
	}

	public void setTourPhoneTxtbox(String tourPhone) {
		getTourPhoneTxtbox().sendKeys(tourPhone);
		System.out.println("Operator's Phone inserted. Value = " + tourPhone);
	}

	// ------------ OPERATOR'S FULL ADDRESS TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourfulladdress']")
	WebElement TourAddressTxtbox;

	public WebElement getTourAddressTxtbox() {
		return TourAddressTxtbox;
	}

	public void setTourAddressTxtbox(String tourAddress) {
		getTourAddressTxtbox().sendKeys(tourAddress);
		System.out.println("Operator's Full Address inserted. Value = " + tourAddress);
	}

	// ------------ TOUR HOURS TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourhours']")
	WebElement TourHoursTxtbox;

	public WebElement getTourHoursTxtbox() {
		return TourHoursTxtbox;
	}

	public void setTourHoursTxtbox(String tourHours) {
		getTourHoursTxtbox().sendKeys(tourHours);
		System.out.println("Tour Hours inserted. Value = " + tourHours);
	}

	// ------------ TOUR DAYS TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tourdays']")
	WebElement TourDaysTxtbox;

	public WebElement getTourDaysTxtbox() {
		return TourDaysTxtbox;
	}

	public void setTourDaysTxtbox(String tourDays) {
		getTourDaysTxtbox().sendKeys(tourDays);
		System.out.println("Tour Days inserted. Value = " + tourDays);
	}

	// ------------ TOUR NIGHTS TEXTBOX -----------------

	@FindBy(xpath = "//input[@name='tournights']")
	WebElement TourNightsTxtbox;

	public WebElement getTourNightsTxtbox() {
		return TourNightsTxtbox;
	}

	public void setTourNightsTxtbox(String tourNights) {
		getTourNightsTxtbox().sendKeys(tourNights);
		System.out.println("Tour Nights inserted. Value = " + tourNights);
	}

	// ------------ SELECT TOUR TYPE LIST -----------------

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement TourTypeTxtbox;
	
	public WebElement getTourTypeTxtbox() {
		return TourTypeTxtbox;
	}

	public void selectTourType(String tourType) {
		WebElement expandList = driver.findElement(By.xpath("//div[@id='s2id_autogen11']/a"));
		expandList.click();
		utility.waiting();
		getTourTypeTxtbox().sendKeys(tourType);
		utility.waiting();
		WebElement optionResult = driver
				.findElement(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']"));
		optionResult.click();
		System.out.println("Tour Type selected. Value = " + tourType);
	}

	// ---------------- Click for button Submit -----------------------------

	@FindBy(xpath = "//button[@id='add']")
	WebElement SubmitBtn;

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void clickSubmitBtn() {
		utility.elementScrollDown(this.getSubmitBtn());
		getSubmitBtn().click();
		System.out.println("The Submit button has been clicked...");
	}
}