package phptravelsPageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import library.utilities;

public class PTAddRoomPage_Supplier {

	WebDriver driver;
	utilities utility;

	public PTAddRoomPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new utilities(driver);
	}

	// ******************************************************
	// Objective: INSERT HOTEL NAME TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 16 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement HotelNameTxtbox;

	public WebElement getHotelNameTxt() {
		return HotelNameTxtbox;
	}

	public void insertHotelNameTxt(String hotelName) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(
				ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_autogen1']/a"), "class", "select2-choice"));

		WebElement activateTxt = driver.findElement(By.xpath("//div[@id='s2id_autogen1']/a"));
		activateTxt.click();

		getHotelNameTxt().sendKeys(hotelName);

		utility.waiting();

		WebElement optionSuggested = driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li"));
		optionSuggested.click();
		System.out.println("The Hotel name value has been inserted. Value = " + hotelName);
	}

	// ******************************************************
	// Objective: INSERT ROOM TYPE TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 16 23
	// *******************************************************

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement RoomTypeTxtbox;

	public WebElement getRoomTypeTxtbox() {
		return RoomTypeTxtbox;
	}

	public void insertRoomTypeTxtbox(String roomType) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_autogen3']/a"), "class",
				"select2-choice select2-default"));

		WebElement activateTxt = driver.findElement(By.xpath("//div[@id='s2id_autogen3']/a"));
		activateTxt.click();

		getHotelNameTxt().sendKeys(roomType);

		utility.waiting();

		WebElement optionSuggested = driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li"));
		optionSuggested.click();
		System.out.println("The Room Type value has been inserted. Value = " + roomType);
	}

	// ******************************************************
	// Objective: INSERTS ROOM DESCRIPTION TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 16 23
	// *******************************************************

	@FindBy(xpath = "//html/body[@contenteditable='true']")
	WebElement RoomDescTxt;

	public WebElement getRoomDescTxt() {
		return RoomDescTxt;
	}

	public void insertRoomDescTxt(String roomDesc) {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, roomdesc']"));
		driver.switchTo().frame(iframe);
		getRoomDescTxt().sendKeys(roomDesc);
		driver.switchTo().defaultContent();
		System.out.println("Room description has been inserted. Value = " + roomDesc);
	}

	// ******************************************************
	// Objective: SELECT PRICE TYPE DROPDOWN.
	// Author: Elías Lara.
	// Date of creation/adding: 01 16 23
	// *******************************************************

	@FindBy(xpath = "//select[@id='price_type']")
	WebElement PriceTypeSelect;

	public WebElement getPriceTypeList() {
		return PriceTypeSelect;
	}

	public void selectPriceTypeList(String priceType) {

		Select select = new Select(PriceTypeSelect);

		select.selectByVisibleText(priceType);
		System.out.println("Price type selected. Value = " + priceType);

	}

	// ******************************************************
	// Objective: INSERT PRICE TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 16 23
	// *******************************************************

	@FindBy(xpath = "//input[@name='basicprice']")
	WebElement PriceTxtbox;

	public WebElement getPriceTxtbox() {
		return PriceTxtbox;
	}

	public void setPriceTxtbox(String price) {
		getPriceTxtbox().sendKeys(price);
		System.out.println("Price has been inserted. Value = " + price);
	}

	// ******************************************************
	// Objective: INSERT QUANTITY TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//input[@name='quantity']")
	WebElement QtyTxtbox;

	public WebElement getQtyTxtbox() {
		return QtyTxtbox;
	}

	public void setQtyTxtbox(String qty) {
		getQtyTxtbox().sendKeys(qty);
		System.out.println("Quantity has been inserted. Value = " + qty);
	}

	// ******************************************************
	// Objective: INSERT MINIMUM STAY (MIN STAY) TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//input[@name='minstay']")
	WebElement MinStayTxtbox;

	public WebElement getMinStayTxtbox() {
		return MinStayTxtbox;
	}

	public void setMinStayTxtbox(String minStay) {
		getMinStayTxtbox().sendKeys(minStay);
		System.out.println("Minimum Stay (Min Stay) has been inserted. Value = " + minStay);
	}

	// ******************************************************
	// Objective: SELECT MAXIMUM ADULTS (MAX ADULTS) QUANTITY DROPDOWN.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//select[@name='adults']")
	WebElement MaxAdultsSelect;

	public WebElement getMaxAdultsList() {
		return MaxAdultsSelect;
	}

	public void selectMaxAdultsList(String adultsQty) {

		Select select = new Select(MaxAdultsSelect);

		select.selectByVisibleText(adultsQty);
		System.out.println("Adults quantity selected. Value = " + adultsQty);
	}

	// ******************************************************
	// Objective: SELECT MAXIMUM CHILDREN (MAX CHILD) QUANTITY DROPDOWN.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//select[@name='children']")
	WebElement MaxChildSelect;

	public WebElement getMaxChildList() {
		return MaxChildSelect;
	}

	public void selectMaxChildList(String childQty) {

		Select select = new Select(MaxChildSelect);

		select.selectByVisibleText(childQty);
		System.out.println("Children quantity selected. Value = " + childQty);
	}

	// ******************************************************
	// Objective: INSERT NUMBER OF EXTRA BEDS (NO. OF EXTRA BEDS) TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//input[@name='extrabeds']")
	WebElement ExtraBedsTxtbox;

	public WebElement getExtraBedsTxtbox() {
		return MinStayTxtbox;
	}

	public void setExtraBedsTxtbox(String extBeds) {
		getPriceTxtbox().sendKeys(extBeds);
		System.out.println("Number of extra beds (No. of extra beds) has been inserted. Value = " + extBeds);
	}

	// ******************************************************
	// Objective: INSERT EXTRA BEDS CHARGES TEXTBOX.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	@FindBy(xpath = "//input[@name='bedcharges']")
	WebElement ExtraBedsChrgTxtbox;

	public WebElement getExtraBedsChrgTxtbox() {
		return ExtraBedsChrgTxtbox;
	}

	public void setExtraBedsChrgTxtbox(String extBedsChrg) {
		getPriceTxtbox().sendKeys(extBedsChrg);
		System.out.println("Extra Bed Charges has been inserted. Value = " + extBedsChrg);
	}

	// ******************************************************
	// Objective: CLICK IN 'SUBMIT' BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 18 23
	// *******************************************************

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