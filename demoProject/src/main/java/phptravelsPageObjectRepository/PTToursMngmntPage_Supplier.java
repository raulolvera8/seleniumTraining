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
import org.testng.Assert;

public class PTToursMngmntPage_Supplier {

	WebDriver driver;

	public PTToursMngmntPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ******************************************************
	// Objective: VERIFIES IF THE TOUR ELEMENT EXIST PREVIOUS THE CREATION.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	public void verifyIfTourExistPrevCreation(String tourName) {
		try {
			boolean tourElement = driver.findElement(By.xpath(
					"//div[@id='layoutDrawer_content']//table/tbody/tr[contains(@class,'xcrud')]/td[5]/a[contains(text(),'"
							+ tourName + "')]"))
					.isDisplayed();
			if (tourElement) {
				System.out.println(
						"The tour is already created or the tour name is the same of an existing one. Please check.");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("No element matching with the info given was found. Continuing with the execution.");
		}
	}

	// ******************************************************
	// Objective: CLICK IN ADD BUTTON.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

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

	// ******************************************************
	// Objective: VERIFIES IF THE TOUR HAS BEEN ADDED IN 'TOURS MANAGEMENT' SCREEN.
	// Author: Elías Lara.
	// Date of creation/adding: 01 07 23
	// *******************************************************

	public void VerifyIfTourIsAdded(String tourName) {
		try {
			boolean tourElement = driver.findElement(By.xpath(
					"//div[@id='layoutDrawer_content']//table/tbody/tr[contains(@class,'xcrud')]/td[5]/a[contains(text(),'"
							+ tourName + "')]"))
					.isDisplayed();
			if (tourElement) {
				System.out.println("The tour is shown properly in 'Manage Tours' page...");
			}
		} catch (Exception e) {
			System.out.println("The tour has not been reflected as expected. Please check.");
			e.printStackTrace();
			Assert.fail();
		}
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
}