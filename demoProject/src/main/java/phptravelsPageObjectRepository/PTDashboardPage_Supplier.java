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

//##################### CLASS AND CODE CREATED BY ELIAS LARA.

public class PTDashboardPage_Supplier {

	WebDriver driver;

	public PTDashboardPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

		wait.until(
				ExpectedConditions.attributeToBe(By.xpath("//div[@id='s2id_autogen1']/a"), "class", "select2-choice"));

		System.out.println("Add Room nested button clicked. The user is in Add Room page...");
	}

}
